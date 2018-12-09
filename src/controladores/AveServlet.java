package controladores;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AveDao;
import dao.GalponDao;
import dao.RazaDao;
import model.Ave;

/**
 * Servlet implementation class AveServlet
 */
@WebServlet("/ave")
public class AveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void procesar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		SimpleDateFormat simpleFecha = new SimpleDateFormat("yyyy-mm-dd");
		int seleccion = Integer.parseInt(request.getParameter("seleccion"));
		switch (seleccion) {
		case 1: // Formulario
			try { // Actualizar
				request.setAttribute("objeto", new AveDao().find(Integer.parseInt(request.getParameter("id"))));
			} catch (Exception ex) { // Registrar
				ex.printStackTrace();
			}
			request.setAttribute("g", new GalponDao().list());
			request.setAttribute("r", new RazaDao().list());
			url = "/WEB-INF/ave/registrar-ave.jsp";
			break;
		case 2: // Consultar las aves
			request.setAttribute("lista", new AveDao().list());
			url = "/WEB-INF/ave/consultar-aves.jsp";
			break;
		case 3: // Registrar ave
			try {
				request.setAttribute("exito",
						new AveDao().insert(new Ave(Integer.parseInt(request.getParameter("edad")),
								simpleFecha.parse(request.getParameter("fechaBaja")),
								simpleFecha.parse(request.getParameter("fechaIngreso")),
								request.getParameter("obsInicial"), Float.parseFloat(request.getParameter("peso")),
								request.getParameter("sexaje"),
								new RazaDao().find(Integer.parseInt(request.getParameter("raza"))),
								new GalponDao().find(Integer.parseInt(request.getParameter("galpon"))))));
				request.setAttribute("lista", new AveDao().list());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			url = "/WEB-INF/ave/consultar-aves.jsp";
			break;
		case 4: // Actualizar el ave
			try {
				request.setAttribute("exito",
						new AveDao().update(new Ave(Integer.parseInt(request.getParameter("edad")),
								simpleFecha.parse(request.getParameter("fechaBaja")),
								simpleFecha.parse(request.getParameter("fechaIngreso")),
								request.getParameter("obsInicial"), Float.parseFloat(request.getParameter("peso")),
								request.getParameter("sexaje"),
								new RazaDao().find(Integer.parseInt(request.getParameter("raza"))),
								new GalponDao().find(Integer.parseInt(request.getParameter("galpon"))))));
				request.setAttribute("lista", new AveDao().list());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			url = "/WEB-INF/ave/consultar-aves.jsp";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesar(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesar(request, response);
	}

}

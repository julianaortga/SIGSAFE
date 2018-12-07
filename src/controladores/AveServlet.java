package controladores;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AveDao;
import dao.GalponDao;
import dao.LineaGDao;
import dao.RazaDao;
import dao.TipoAveDao;
import model.Ave;
import model.Galpon;
import model.LineaG;
import model.Raza;
import model.TipoAve;

/**
 * Servlet implementation class AveServlet
 */
@WebServlet("/ave")
public class AveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void procesar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		String nombre;
		int id=0, tipo=0;
		SimpleDateFormat simpleFecha = new SimpleDateFormat("dd/MM/yyyy");
		TipoAveDao myTipoAveDao = new TipoAveDao();
		TipoAve myTipoAve;
		RazaDao myRazaDao = new RazaDao();
		Raza myRaza;
		LineaGDao myLineaDao = new LineaGDao();
		LineaG myLineaG;
		AveDao myAveDao = new AveDao();
		Ave myAve;
		Galpon myGalpon;
		GalponDao myGalponDao = new GalponDao();

		int seleccion = Integer.parseInt(request.getParameter("seleccion"));

		switch (seleccion) {
		case 1: // Redireccionar a el módulo de las aves
			url = "/WEB-INF/ave/modulo-ave.jsp";
			break;
		case 2: // Redireccionar al formulario de tipo de ave
			url = "/WEB-INF/ave/registrar-tipo-ave.jsp";
			break;
		case 3: // Redireccionar al formulario de linea genetica
			List<TipoAve> combo1 = myTipoAveDao.list();
			request.setAttribute("combo", combo1);
			url = "/WEB-INF/ave/registrar-linea-genetica.jsp";
			break;
		case 4: // Redireccionar al formulario de raza
			List<TipoAve> combo = myTipoAveDao.list();
			request.setAttribute("combo", combo);
			url = "/WEB-INF/ave/registrar-raza.jsp";
			break;
		case 5: // Redireccionar al formulario de ave
			url = "/WEB-INF/ave/registrar-ave.jsp";
			break;
		case 6: // Registrar tipo ave
			nombre = request.getParameter("nombre");

			myTipoAve = new TipoAve(nombre);
			request.setAttribute("req", myTipoAveDao.insert(myTipoAve));
			url = "/WEB-INF/ave/consultar-tipos-ave.jsp";
			break;
		case 7: // Registrar raza

			nombre = request.getParameter("nombre");
			int tipo_ave = Integer.parseInt(request.getParameter("tipoAveBean"));
			TipoAve tp = myTipoAveDao.find(tipo_ave);

			myRaza = new Raza(nombre, tp);

			request.setAttribute("req", myRazaDao.insert(myRaza));
			url = "/WEB-INF/ave/consultar-razas.jsp";
			break;
		case 8: // Registrar linea genetica

			nombre = request.getParameter("nombre");
			String observacion = request.getParameter("observacion");
			int tipo_ave2 = Integer.parseInt(request.getParameter("tipoAveBean"));
			TipoAve tp2 = myTipoAveDao.find(tipo_ave2);

			myLineaG = new LineaG(nombre, observacion, tp2);

			request.setAttribute("req", myLineaDao.insert(myLineaG));
			url = "/WEB-INF/ave/consultar-lineas-geneticas.jsp";
			break;
		case 9: // Registrar ave

			nombre = request.getParameter("nombre");
			int edad = Integer.parseInt(request.getParameter("edad"));
			String obsInicial = request.getParameter("obsInicial");
			float peso = Float.parseFloat(request.getParameter("peso"));
			String sexaje = request.getParameter("sexaje");

			try {
				String fechaBaja = request.getParameter("fechaBaja");
				String fechaIngreso = request.getParameter("fechaIngreso");

				Date fechaIng = simpleFecha.parse(fechaIngreso);
				Date fechaBaj = simpleFecha.parse(fechaBaja);

				int raza = Integer.parseInt(request.getParameter("raza"));
				int galpon = Integer.parseInt(request.getParameter("galpon"));
				Raza raz = myRazaDao.find(raza);
				Galpon gal = myGalponDao.find(galpon);

				myAve = new Ave(edad, fechaBaj, fechaIng, obsInicial, peso, sexaje, raz, gal);

				request.setAttribute("req", myAveDao.insert(myAve));
				url = "/WEB-INF/ave/consultar-aves.jsp";
			} catch (ParseException e) {

				e.printStackTrace();
			}
			break;
		case 10: // Consultar los tipos de aves
			request.setAttribute("combo", myTipoAveDao.list());
			url = "/WEB-INF/ave/consultar-tipos-ave.jsp";
			break;
		case 11: // Consultar las razas
			request.setAttribute("combo", myRazaDao.list());
			url = "/WEB-INF/ave/consultar-razas.jsp";
			break;
		case 12: // Consultar las lineas genéticas
			request.setAttribute("combo", myLineaDao.list());
			url = "/WEB-INF/ave/consultar-lineas-geneticas.jsp";
			break;
		case 13: // Consultar las aves
			request.setAttribute("combo", myAveDao.list());
			url = "/WEB-INF/ave/consultar-aves.jsp";
			break;
		case 14: //Redireccionar al actualizar el tipo del ave
			try {
				int i = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("objeto", myTipoAveDao.find(i));
				url = "/WEB-INF/ave/registrar-tipo-ave.jsp";
			} catch (Exception ex) {
				ex.printStackTrace();
				url = "/WEB-INF/ave/modulo-ave.jsp";
			}
			break;
		case 15: //Redireccionar al actualizar la raza
			try {
				request.setAttribute("combo", myTipoAveDao.list());
				int i = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("objeto", myRazaDao.find(i));
				url = "/WEB-INF/ave/registrar-raza.jsp";
			} catch (Exception ex) {
				ex.printStackTrace();
				url = "/WEB-INF/ave/modulo-ave.jsp";
			}
			break;
		case 16: //Redireccionar al actualizar la linea genetica
			try {
				request.setAttribute("combo", myTipoAveDao.list());
				int i = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("objeto", myLineaDao.find(i));
				url = "/WEB-INF/ave/registrar-linea-genetica.jsp";
			} catch (Exception ex) {
				ex.printStackTrace();
				url = "/WEB-INF/ave/modulo-ave.jsp";
			}
			break;
		case 17: //Redireccionar al actualizar el ave
			try {
				request.setAttribute("combo", myRazaDao.list());
				request.setAttribute("combo", myGalponDao.list());
				int i = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("objeto", myAveDao.find(i));
				url = "/WEB-INF/ave/registrar-ave.jsp";
			} catch (Exception ex) {
				ex.printStackTrace();
				url = "/WEB-INF/ave/modulo-ave.jsp";
			}
			break;
		case 18: // Actualizar el tipo de ave
			
			myTipoAve = new TipoAve(Integer.parseInt(request.getParameter("id")),
					request.getParameter("nombre").toString());
			request.setAttribute("exito", myTipoAveDao.update(myTipoAve));
			request.setAttribute("combo", myTipoAveDao.list());
			url = "/WEB-INF/ave/consultar-tipos-ave.jsp";
			break;
		case 19: // Actualizar la raza
			
			id= Integer.parseInt(request.getParameter("id"));
			nombre = request.getParameter("nombre");
			tipo = Integer.parseInt(request.getParameter("tipoAveBean"));
			myTipoAve = myTipoAveDao.find(tipo);
			
			myRaza = new Raza(id,nombre,myTipoAve);
			
			request.setAttribute("exito", myRazaDao.update(myRaza));
			request.setAttribute("combo", myRazaDao.list());
			url = "/WEB-INF/ave/consultar-razas.jsp";
			break;
		case 20: // Actualizar la linea genetica
			
			id= Integer.parseInt(request.getParameter("id")); 
			nombre = request.getParameter("nombre");
			observacion = request.getParameter("obsercacion");
			tipo = Integer.parseInt(request.getParameter("tipoAveBean"));
			myTipoAve = myTipoAveDao.find(tipo);
			
			myLineaG = new LineaG(id,nombre,observacion,myTipoAve);
			request.setAttribute("exito", myLineaDao.update(myLineaG));
			request.setAttribute("combo", myLineaDao.list());
			url = "/WEB-INF/ave/consultar-tipos-ave.jsp";
			break;
		case 21: // Actualizar el ave
			myTipoAve = new TipoAve(Integer.parseInt(request.getParameter("id")),
					request.getParameter("nombre").toString());
			request.setAttribute("exito", myTipoAveDao.update(myTipoAve));
			request.setAttribute("combo", myTipoAveDao.list());
			url = "/WEB-INF/ave/consultar-tipos-ave.jsp";
			System.out.println("holamundo");
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

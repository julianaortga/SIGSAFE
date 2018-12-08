package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import model.Usuario;

/**
 * Servlet implementation class SeguridadServlet
 */
@WebServlet("/seguridad")
public class SeguridadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="";
		Usuario myUsuario;
		UsuarioDao myUsuarioDao ;
		int seleccion = Integer.parseInt(request.getParameter("seleccion"));
		
		switch(seleccion) {
		case 1:
			
			String correo = request.getParameter("correo");
			myUsuarioDao = new UsuarioDao();
			myUsuario = myUsuarioDao.find(correo);
            System.out.println("user"+myUsuario.getCorreo());
            url = "/WEB-INF/index.jsp";

			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeguridadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}

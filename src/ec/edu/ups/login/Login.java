package ec.edu.ups.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Llego una peticion Post");
		response.setContentType("text/html");
		response.getWriter();
		try {
			String usuario = request.getParameter("usuario");
			String contrasenia = request.getParameter("contrasenia");

			if (usuario.equals("admin") && contrasenia.equals("12345")) {
				HttpSession session = request.getSession(true);
				
				session.setAttribute("usuario", usuario);
				System.out.println("sessionCreated");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/calculadora.html");
				dispatcher.forward(request, response);

			} else {
				
				HttpSession session = request.getSession(false);
				System.out.println("sessionDestroyed");
				System.out.println("DATOS INCORRECTOS");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/notFound.html");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

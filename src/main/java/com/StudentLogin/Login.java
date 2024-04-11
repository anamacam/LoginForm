package com.StudentLogin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class Login
 */
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		// Validación de usuario y contraseña

		if (userName != null && !userName.isEmpty() && password != null && !password.isEmpty()) {
			User user = new User(userName, password);
			LoginDao loginDao = new LoginDao();

			try {
				if (loginDao.insert(user)) {
					response.sendRedirect("LoginSuccessfully.jsp");
				} else {
					response.sendRedirect("Login.jsp");
				}
			} catch (SQLException e) {
				e.printStackTrace(); //
			}
		} else {
			// Si los campos de usuario y contraseña están vacíos, redirigir a la página de
			// inicio de sesión
			response.sendRedirect("Login.jsp");
		}

	}
}

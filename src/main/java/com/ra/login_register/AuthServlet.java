package com.ra.login_register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// auth - authentication -> xác thực
@WebServlet(name = "authServlet", value = "/authServlet")
public class AuthServlet extends HttpServlet
{
	
	// method là get
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// req - request
		// resp - response
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	// method post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// tài khoản fix cứng username: admin - password: 123
		if (username.equals("admin") && password.equals("123"))
		{
			// đăng nhập thành công
			req.getRequestDispatcher("/admin.jsp").forward(req, resp);
		}
		else
		{
			// đăng nhập thất bại
			req.setAttribute("error", "username or password is incorrect");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}

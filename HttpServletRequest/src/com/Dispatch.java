package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispatch extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	request.getRequestDispatcher("/servlet/Reg").forward(request, response);
	// 不可以转发请求到其它应用	request.getRequestDispatcher("http://www.baidu.com").forward(request, response);
	//	response.sendRedirect("http://www.baidu.com");
		response.sendRedirect(request.getContextPath()+"/Ok.html");
		request.getRequestDispatcher("/servlet/demo6").include(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
	}

}

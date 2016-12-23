package com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UEditorServlet
 */
@WebServlet("/UEditorServlet")
public class UEditorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UEditorServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "text/html");
		String rootPath = getServletContext().getRealPath("/");
		response.getWriter().write(new UEditorActionEnter(request, rootPath).exec());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

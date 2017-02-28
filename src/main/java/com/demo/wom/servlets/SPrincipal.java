package com.demo.wom.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.wom.utils.AccionProxy;

public class SPrincipal extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected javax.servlet.ServletConfig config = null;
	protected javax.servlet.ServletContext sc = null;

	public SPrincipal() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametro, accion = null;
		parametro = request.getParameter("pAccion");

		if (parametro != null && parametro.length() > 0) {

			accion = parametro;
			AccionProxy accProxy = AccionProxy.getInstance();
			accProxy.creaAction(request, response, accion);

		}
	}

	public void init(javax.servlet.ServletConfig config) throws ServletException {
		sc = config.getServletContext();
		this.config = config;

	}

}

package com.demo.wom.utils;

public class ListarOtrosLibros extends Accion {

	
	public void execute () {
		
		String informe = " No hay libros disponibles de ningún tipo, todos están prestados";  
		request.setAttribute("LibrosEncontrados", informe);
		
		
	}
	
	
}

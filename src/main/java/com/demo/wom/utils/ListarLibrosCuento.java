package com.demo.wom.utils;

public class ListarLibrosCuento extends Accion {

	
	public void execute () {
		
		String informe = " No hay libros de cuento disponibles, no se quedar�n de otros g�neros";  
		request.setAttribute("LibrosEncontrados", informe);
		
		
	}
	
	
}



package com.demo.wom.utils;

public class ListarLibrosCuento extends Accion {

	
	public void execute () {
		
		String informe = " No hay libros de cuento disponibles, no se quedarán de otros géneros";  
		request.setAttribute("LibrosEncontrados", informe);
		
		
	}
	
	
}



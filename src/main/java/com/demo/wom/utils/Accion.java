package com.demo.wom.utils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class Accion { 

	protected HttpServletRequest request; 
	protected HttpServletResponse response;
	
	public void setRequest(HttpServletRequest request) { this.request = request; }
	public void setResponse(HttpServletResponse response) { this.response = response; }
	
	public void setActionParams (HttpServletRequest request, HttpServletResponse response ){
		this.request = request; this.response = response; 
	}
	
	
	public abstract void execute() throws Exception;
	
	public boolean executeAction() { 
		
		
		boolean resp = true;
		
		try{ 
			execute();
		} catch (Throwable ex) 
		{
			System.out.println(" Exception: " + ex.toString() + " en " + getClass() );
			resp = false; 
		}
		return resp;
	}
	
	
	
}


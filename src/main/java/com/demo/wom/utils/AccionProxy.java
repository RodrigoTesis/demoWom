package com.demo.wom.utils;

//import javax.servlet.ServletContext;
//import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccionProxy {

	private static AccionProxy accProxy;
	
	public AccionProxy() { }
	
	public static AccionProxy getInstance(){
		
		if ( accProxy == null ){ accProxy = new AccionProxy(); } 
		return accProxy;
		
	} //getInstance
	
	public void creaAction (	HttpServletRequest request, HttpServletResponse response, String actionName){
		try{
			
			Boolean otraAcc = false;
		    String nombAcc = actionName;
		    String tipoRespAccExe,valorRespAccExe = null;

		    AccionConf confAcc = new AccionConf();
		    confAcc.setPropertiesPath("com.ro.ejercicioMVC.acciones");
		    do {
		    	
		    	String nuevaAcc = confAcc.getProperty(nombAcc + ".srcAction");
		        if ( nuevaAcc != null ){ nuevaAcc = nuevaAcc.trim(); }
		        
		        Accion accion;
				accion = (Accion) Class.forName(nuevaAcc).newInstance();
				accion.setActionParams(request, response);
				Boolean RespAccExe = accion.executeAction();
				
				if (RespAccExe.equals(true))
				{ 
					tipoRespAccExe =  confAcc.getProperty(nombAcc + ".true.resultType");
					if (tipoRespAccExe != null ){ tipoRespAccExe = tipoRespAccExe.trim(); }
					
					valorRespAccExe = confAcc.getProperty(nombAcc+".true.resultValue");
	                if ( valorRespAccExe != null ) { valorRespAccExe = valorRespAccExe.trim(); }
					
					if (tipoRespAccExe.equals("action")) { 

						otraAcc = true;
		                nombAcc = valorRespAccExe;
						
					} else {
						try { 
							otraAcc = false;
							request.getRequestDispatcher("/"+ valorRespAccExe).forward(request, response);
							break;
						} catch (Exception e) {  System.out.println(" error en forward: " + e.getMessage()); }
					}
					
				} else if (RespAccExe.equals(false)) {
					
					tipoRespAccExe =  confAcc.getProperty(nombAcc + ".false.resultType");
					if (tipoRespAccExe != null ){ tipoRespAccExe = tipoRespAccExe.trim(); }
					
					valorRespAccExe = confAcc.getProperty(nombAcc+".false.resultValue");
	                if ( valorRespAccExe != null ) { valorRespAccExe = valorRespAccExe.trim(); }
					
					if (tipoRespAccExe.equals("action")) { 

						otraAcc = true;
		                nombAcc = valorRespAccExe;
						
					} else {
						try { 
							otraAcc = false;
							request.getRequestDispatcher("/"+ valorRespAccExe).forward(request, response);
							break;
						} catch (Exception e) {  System.out.println(" error en forward: " + e.getMessage()); }
					}

				}
		        
		    	
		    } while( otraAcc.equals(true) ) ;


		} catch (Exception ex) {System.out.println(" Exception: " + ex.getMessage() ); }	
		  
	}
	
	
	
	
	
}


package br.com.garbo.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import br.com.garbo.utilities.Utils;

/**
 * Application Lifecycle Listener implementation class AplicacaoListener
 *
 */
@WebListener
public class AplicacaoListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener, ServletRequestAttributeListener {

    public AplicacaoListener() {
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	Utils.gerarLog("Sessão criada: " + se.getSession().getId());
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	Utils.gerarLog("Aplicação iniciada.");
    }    
    
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	Utils.gerarLog("Sessão encerrada: " + se.getSession().getId());
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	Utils.gerarLog("Aplicação finalizada.");
    }
    
    public void attributeRemoved(ServletRequestAttributeEvent srae)  {
    	
    	if (srae.getServletRequest().getAttributeNames().hasMoreElements()) {
        	String atr = srae.getServletRequest().getAttributeNames().nextElement();    	
        	Utils.gerarLog("Atributo adicionado ao request: " + atr);
		} else {
	    	Utils.gerarLog("Atributo adicionado ao request.");
		}
    }    

    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	String atr = srae.getServletRequest().getAttributeNames().nextElement();    	
    	Utils.gerarLog("Atributo adicionado ao request: " + atr);
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	
		if (srae.getServletRequest().getAttributeNames().hasMoreElements()) {
			String atr = srae.getServletRequest().getAttributeNames().nextElement();
			Utils.gerarLog("Atributo alterado no request: " + atr);
		} else {
			Utils.gerarLog("Atributo alterado no request.");
		}
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	String atr = se.getSession().getAttributeNames().nextElement();
    	Utils.gerarLog("Atributo adicionado a sessão: " + atr);
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	if (se.getSession().getAttributeNames().hasMoreElements()) {
        	String atr = se.getSession().getAttributeNames().nextElement();
        	Utils.gerarLog("Atributo removido da sessão: " + atr);			
		} else {
	    	Utils.gerarLog("Atributo removido da sessão.");			
		}
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  {    	
    	if (se.getSession().getAttributeNames().hasMoreElements()) {
        	String atr = se.getSession().getAttributeNames().nextElement();
        	Utils.gerarLog("Atributo atualizado na sessão: " + atr);		
		} else {
			Utils.gerarLog("Atributo atualizado na sessão.");		
		}    	
    }
	
}

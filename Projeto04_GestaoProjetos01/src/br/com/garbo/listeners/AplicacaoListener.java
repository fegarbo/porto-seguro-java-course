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

/**
 * Application Lifecycle Listener implementation class AplicacaoListener
 *
 */
@WebListener
public class AplicacaoListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener, ServletRequestAttributeListener {

    public AplicacaoListener() {
    }

    public void sessionCreated(HttpSessionEvent se)  { 

    }

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 

    }

    public void sessionDestroyed(HttpSessionEvent se)  { 

    }

    public void contextDestroyed(ServletContextEvent sce)  { 

    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  { 

    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 

    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 

    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 

    }

    public void contextInitialized(ServletContextEvent sce)  { 

    }
	
}

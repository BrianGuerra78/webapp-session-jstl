package org.bguerra.apiserclet.webapp.headers.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.bguerra.apiserclet.webapp.headers.models.Carro;

@WebListener
public class AplicacionListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {
    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Inicializando la aplicacion!");
        servletContext = sce.getServletContext();
        servletContext.setAttribute("mensaje", "Algun valor global de la app!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //sce.getServletContext().log("Destruyendo la aplicacion!");
        servletContext.log("Destruyendo la aplicacion!");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //sre.getServletContext().log("Inicializando el request!");
        servletContext.log("Inicializando el request!");
        sre.getServletRequest().setAttribute("mensaje", "guardando algun valor para el request");
        sre.getServletRequest().setAttribute("title", "Catalogo Servlet");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        //sre.getServletContext().log("Destruyendo el request!");
        servletContext.log("Destruyendo el request!");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        servletContext.log("Iniciando la sesion http");
        Carro carro = new Carro();
        HttpSession session = se.getSession();
        session.setAttribute("carro", carro);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        servletContext.log("Destruyendo la session http");
    }
}

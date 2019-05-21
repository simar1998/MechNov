package api;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.print("Application Servlet Context Listener Initialized ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}

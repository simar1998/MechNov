package subroutines;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import subroutines.thread.*;

@WebListener
public class ApplicationServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Application Servlet Context Listener Initialized ");
        Thread commsThread1 = new Thread(new CommunicationThread());
        commsThread1.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}

package subroutines;

import subroutines.thread.HibernateThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Application Servlet Context Listener Initialized ");
        HibernateThread.buildSessionFactory();
        Thread commsThread1 = new Thread(new HibernateThread());
        commsThread1.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}

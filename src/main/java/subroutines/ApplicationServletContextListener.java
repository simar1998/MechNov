package subroutines;

import pojo.Command;
import pojo.printer.Printer;
import serialcomms.SerialCommunicator;
import subroutines.thread.HibernateThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        HibernateThread.buildSessionFactory();
        Thread hibernateThread = new Thread(new HibernateThread());
        hibernateThread.start();

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}

package subroutines;

import pojo.Command;
import pojo.printer.Printer;
import serialcomms.SerialCommunicator;
import subroutines.thread.HibernateThread;
import subroutines.thread.PrinterCommunicationHandler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        //SerialCommunicator serialCommunicator = new SerialCommunicator("COM3" , 115200);
        //serialCommunicator.serialWrite("G28"  + " \r\n\r\n ");
        //PrinterCommunicationHandler.getPrinterBundle("Ender 3");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}

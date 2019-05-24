package pojo.crud;

import org.hibernate.Session;
import pojo.printer.Printer;
import subroutines.thread.HibernateThread;

public class HelperCRUD {

    public static void saveObjectIntoDB(Object object){
        Session session = HibernateThread.getSession().openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        HibernateThread.shutDown();
    }


}

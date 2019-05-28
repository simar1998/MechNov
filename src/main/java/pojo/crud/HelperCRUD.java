package pojo.crud;

import org.hibernate.Query;
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

    public static String getAllObjectsFromDB(String tableName){
        Session session = HibernateThread.getSession().openSession();
        Query query = session.createQuery("from "+tableName);
        String response = query.list().toString();
        session.close();
        return response;
    }



}

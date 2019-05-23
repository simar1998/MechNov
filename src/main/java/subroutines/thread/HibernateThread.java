package subroutines.thread;

import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import pojo.printer.descriptors.ControlLoopPID;

import javax.persistence.metamodel.EntityType;
import java.util.EnumSet;

public class HibernateThread implements Runnable{

    public ControlLoopPID controlLoopPID = new ControlLoopPID(1310,1114,2056);

    public static SessionFactory ourSessionFactory;

    public static SessionFactory getSession() throws HibernateException {
        return ourSessionFactory;
    }

    public static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure();

        ourSessionFactory = configuration.buildSessionFactory();
        return ourSessionFactory;
    }

    public static void shutDown(){
        ourSessionFactory.close();
    }

    @Override
    public void run() {
        final Session session = getSession().openSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o.toString());
                }
            }
            session.save(controlLoopPID);
            session.getTransaction().commit();
        } finally {
            session.close();
        }


    }

}

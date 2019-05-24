package subroutines.thread;

import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pojo.printer.descriptors.ControlLoopPID;

import javax.persistence.metamodel.EntityType;

/**
 * The type Hibernate thread.
 */
public class HibernateThread implements Runnable{

    /**
     * The Control loop pid.
     */
    //public ControlLoopPID controlLoopPID = new ControlLoopPID(1310,1114,2056);

    /**
     * The constant ourSessionFactory.
     */
    public static SessionFactory ourSessionFactory;

    /**
     * Gets session.
     *
     * @return the session
     * @throws HibernateException the hibernate exception
     */
    public static SessionFactory getSession() throws HibernateException {
        return ourSessionFactory;
    }

    /**
     * Build session factory session factory.
     *
     * @return the session factory
     */
    public static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure();

        ourSessionFactory = configuration.buildSessionFactory();
        return ourSessionFactory;
    }

    /**
     * Shut down.
     */
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
        } finally {
            session.close();
        }


    }

}

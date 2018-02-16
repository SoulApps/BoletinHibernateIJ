package Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import primero.HibernateUtil;
import primero.Profesor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static HibernateUtils instancia;

    private HibernateUtils() {
    }

    public static HibernateUtils getInstance() {
        if (instancia == null) {
            instancia = new HibernateUtils();
        }
        return instancia;
    }


    public static void openSesionConection(){
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public static <T> void insertSession(T object){
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
    }

    // Generic function
    public static <T> T loadData(Class<T> type, Serializable id){
        return session.load(type,id);
    }

    public static void closeSesionConection(){
        session.close();
        System.exit(1);
    }


    public static <T> void updateData(T object) {
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
    }

    public static <T> void deleteData(T object) {
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
    }

    public static void updateHQL(String hql,List<String> identifiers, Object... params){
        Transaction tx = session.beginTransaction();
        Query query =  session.createQuery(hql);
        for(int i = 0; i < params.length; i++){
            query.setParameter(identifiers.get(i), params[i]);
        }
        int modified = query.executeUpdate();
        tx.commit();
    }

   // public static <T> T selectHQL(String hql, List<String> identifiers, Object... params){

        //return ;
   // }

}

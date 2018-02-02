package primero;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main{
	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx=session.beginTransaction();
		Asignatura asig = new Asignatura();
		asig.setNombre("Prueba");
		asig.setCodAsig("DDD");
		session.save(asig);
		tx.commit();
		session.close();
		
	}
}
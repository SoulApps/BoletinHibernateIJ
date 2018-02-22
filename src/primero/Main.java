package primero;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Inserto una fila en la tabla Asignatura");

		Asignatura dep = new Asignatura();
		dep.setNombre("MARKETING");
		dep.setCodAsig("PP");

		session.save(dep);
		tx.commit();
		session.close();
	}

}
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().
	            configure("hibernate.cfg.xml").
	            addAnnotatedClass(Order.class).
	            addAnnotatedClass(OrderDetail.class).
	            buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {			
			// start a transaction
			session.beginTransaction();
				
			// get the order and oredrDetails from database
			Order order1 = session.get(Order.class, 1);
			OrderDetail detail1 = session.get(OrderDetail.class, 1);

			// delete order
			System.out.println("\nDeleting student: " + order1);
			session.delete(order1);
			
			// delete oredrDetails
			System.out.println("\nDeleting student: " + detail1);
			session.delete(detail1);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}

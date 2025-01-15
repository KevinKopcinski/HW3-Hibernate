import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

	public class MainDelete {
	
		public static void main(String[] args) {
	
			SessionFactory factory = new Configuration().
		            configure("hibernate.cfg.xml").
		            addAnnotatedClass(Professor.class).
		            addAnnotatedClass(Customer.class).
		            buildSessionFactory();
			
			Session session = factory.getCurrentSession();
				//			Session session = factory.getCurrentSession();
			try {			
				// start a transaction
				session.beginTransaction();
					
				// get the professor and customer from database
				Professor professor = session.get(Professor.class, 1);
				Customer customer = session.get(Customer.class, 2);

				// delete professor
				System.out.println("\nDeleting student: " + professor);
				session.delete(professor);
				
				// delete customer
				System.out.println("\nDeleting student: " + customer);
				session.delete(customer);
				
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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().
	            configure("hibernate.cfg.xml").
	            addAnnotatedClass(Professor.class).
	            addAnnotatedClass(Customer.class).
	            buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			
			Professor professor1 = new Professor("321-A", "Math");

			Customer customer1 = new Customer("Jared", "123 Home street");
		
			professor1.setCustomer(customer1);
			customer1.setProfessor(professor1);

			session.save(professor1);
			
			session.getTransaction().commit();
		
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			factory.close();
		}		
		

		System.out.println("Done!");
	}

}

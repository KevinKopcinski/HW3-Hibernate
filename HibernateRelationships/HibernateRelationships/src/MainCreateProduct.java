import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateProduct {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
	            configure("hibernate.cfg.xml").
	            addAnnotatedClass(Product.class).
	            addAnnotatedClass(OrderDetail.class).
	            buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			
			Product product1 = new Product();
			OrderDetail detail1 = new OrderDetail();
			OrderDetail detail2 = new OrderDetail();

			
			product1.add(detail1);
			product1.add(detail2);


			session.save(product1);
			
			session.getTransaction().commit();
		
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			factory.close();
		}		
		

		System.out.println("Done!");
		
		
		
	}

}

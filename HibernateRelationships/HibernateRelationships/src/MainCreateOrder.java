import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().
	            configure("hibernate.cfg.xml").
	            addAnnotatedClass(Order.class).
	            addAnnotatedClass(OrderDetail.class).
	            buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
		
			session.beginTransaction();
			
			Order order1 = new Order();
			OrderDetail detail1 = new OrderDetail();
			OrderDetail detail2 = new OrderDetail();

			
			order1.add(detail1);
			order1.add(detail2);


			session.save(order1);
			
			session.getTransaction().commit();
		
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			factory.close();
		}		
		

		System.out.println("Done!");
		
		
	}

}

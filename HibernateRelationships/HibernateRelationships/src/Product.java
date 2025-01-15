import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="customer_name")
	private String customer_name;
	
	@OneToMany(cascade= {CascadeType.PERSIST})
	@JoinColumn(name="orderDetail")
	private List<OrderDetail> orderDetail;
	
	
	Product(){
		orderDetail = new ArrayList<>();
	}
	
	void add(OrderDetail detail) {
		orderDetail.add(detail);
	}
}

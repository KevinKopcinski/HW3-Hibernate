import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name="Product")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private Date date; // 
	
	@Column(name="customer_name")
	private String customer_name;
	
	@OneToMany(cascade= {CascadeType.PERSIST})
	@JoinColumn(name="orderDetail")
	private List<OrderDetail> orderDetail;

	Order(){
		orderDetail = new ArrayList<>();
	}
	
	Order(Date date, String customer_name){
		this.date = date;
		this.customer_name = customer_name;
	}
	
	void setOrderDetail(OrderDetail detail) {
		orderDetail = new ArrayList<>();
	}
	
	void add(OrderDetail detail) {
		orderDetail.add(detail);
	}

}

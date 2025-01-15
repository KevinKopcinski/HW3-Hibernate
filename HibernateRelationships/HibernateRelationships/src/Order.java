import javax.persistence.*;
import java.util.Date;
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

}

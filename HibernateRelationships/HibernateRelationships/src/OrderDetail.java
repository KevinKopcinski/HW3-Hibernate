import javax.persistence.*;

@Entity
@Table(name="orderDetail")
public class OrderDetail {
	@ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

import javax.persistence.*;

@Entity
@Table(name="orderDetail")
public class OrderDetail {
	@ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderID;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productID;
    
    OrderDetail(){
    	//no args
    }
    
    void setOrderID(Order orderID) {
    	this.orderID = orderID;
    }
    
    void setProductID(Product productID) {
    	this.productID = productID;
    }
}

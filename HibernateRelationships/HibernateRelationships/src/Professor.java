import javax.persistence.*;


@Entity
@Table(name="Professor")
public class Professor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="office_number")
	private String office_number;
	
	@Column(name="research_area")
	private String research_area;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
	Professor(String office_number, String research_area){
		this.office_number = office_number;
		this.research_area= research_area;
	}
	
	Customer getCustomer() {
		return customer;
	}
	
	void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}

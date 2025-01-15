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
	private Customer customer_id;
	
}

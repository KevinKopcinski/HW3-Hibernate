import javax.persistence.*;

@Entity
@Table(name="Customer")
public class Customer {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="name")
		private String name;
		
		@Column(name="address")
		private String address;

		@OneToOne
		private Professor professor;
	
		Customer(String name, String address){
			this.name = name;
			this.address = address;
		}
		
		Professor getCustomer() {
			return professor;
		}
		
		void setProfessor(Professor professor) {
			this.professor = professor;
		}
	
}

package models;

import javax.persistence.*;

import play.db.ebean.Model;
import play.data.validation.*;

@Entity
public class Cliente extends Model {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	
	@Constraints.Required
	public String nombre_cte;
	
	@Constraints.Required
	public String ap_pat_cte;
		
	@Constraints.Required
	public String rfc_cte;

	// Para agregar una nueva columna se declaran aqui sus nombres
	public String ap_mat_cte;

	public static Finder<Long, Cliente> 
		find = new Finder<Long, Cliente>(Long.class, Cliente.class);
}

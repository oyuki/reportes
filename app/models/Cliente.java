package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.Model;
import play.data.validation.*;

@Entity
@Table(name="clientes")
public class Cliente extends Model {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long num_cte;
	
	@Constraints.Required
	public String nomb_cte;
	
	@Constraints.Required
	public String ap_pat_cte;
		
	@Constraints.Required
	public String rfc_cte;

	// Para agregar una nueva columna se declaran aqui sus nombres
	@Constraints.Required
	public String ap_mat_cte;

	@Constraints.Required
	public String calle_cte;
	
	@Constraints.Required
	public String num_calle_cte;
	
	@Constraints.Required
	public String colonia_cte;
	
	@Constraints.Required
	public String codp_cte;
	
	@Constraints.Required
	public String mun_cte;
	
	@Constraints.Required
	public String est_cte;
	
	@Constraints.Required
	public String tel_cte;

	@Constraints.Required
	public String email_cte;

	public String nombre() {
		return nomb_cte.concat(" ").concat(ap_pat_cte).concat(" ").concat(ap_mat_cte);
	}
	
    public static List<Cliente> findByNombre(String nombre) {
        return Cliente.find.where()
            .like("nomb_cte","%" + nombre + "%")
            .findList();
    }

	public static Finder<Long, Cliente> 
		find = new Finder<Long, Cliente>(Long.class, Cliente.class);
}

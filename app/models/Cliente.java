package models;

import java.util.*;

import javax.persistence.*;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;
import play.db.ebean.Model.*;
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
	
	public static Cliente create(formas.Cliente cliente) {
		models.Cliente nuevoCliente = new models.Cliente();
		
		// Se asignan los valores de la forma al modelo para después guardarlo
		nuevoCliente.nomb_cte = cliente.nombre_cte;
		nuevoCliente.ap_pat_cte = cliente.ap_pat_cte;
		nuevoCliente.rfc_cte = cliente.rfc_cte;
		nuevoCliente.ap_mat_cte = cliente.ap_mat_cte;
		nuevoCliente.calle_cte = cliente.calle_cte;
		nuevoCliente.mun_cte = cliente.mun_cte;
		nuevoCliente.num_calle_cte = cliente.num_calle_cte;
		nuevoCliente.colonia_cte = cliente.colonia_cte;
		nuevoCliente.codp_cte = cliente.codp_cte;
		nuevoCliente.mun_cte = cliente.mun_cte;
		nuevoCliente.est_cte = cliente.est_cte;
		nuevoCliente.tel_cte = cliente.tel_cte;
		nuevoCliente.email_cte = cliente.email_cte;
		
		// Ebean se encarga de guardar el nuevo registro
		Ebean.save(nuevoCliente);
		return nuevoCliente;
	}
    public static List<Cliente> findByNombre(String nombre) {
        return Cliente.find.where()
            .like("nomb_cte","%" + nombre + "%")
            .findList();
    }

	public static Finder<Long, Cliente> 
		find = new Finder<Long, Cliente>(Long.class, Cliente.class);
}

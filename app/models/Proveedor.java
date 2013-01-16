package models;


import java.util.*;

import javax.persistence.*;

import com.avaje.ebean.Ebean;

import com.avaje.ebean.ExpressionList;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import play.data.validation.*;

@Entity
@Table(name="proveedores")
public class Proveedor extends Model{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long  clav_proveed;
	
	public String compania_proveed;
	public String rfc_proveed;
	public String f_alta_proveed;
	public String calle_proveed;
	public String num_calle_proveed;
	public String colonia_proveed;
	public String codp_proveed;
	public String mun_proveed;
	public String est_proveed;
	public String cont1_proveed;
	public String tel_cel_cont1_proveed;
	public String email_cont1_proveed;
	public String cont2_proveed;
	public String tel_cel_cont2_proveed;
	public String email_cont2_proveed;
	public String observaciones_proveed;

	public String nombre() {
		return clav_proveed + ' ' + compania_proveed  + ' ' + cont1_proveed;
	}
	public static Finder<Long, Proveedor> 
	find = new Finder<Long, Proveedor>(Long.class, models.Proveedor.class);

	public static ExpressionList<Proveedor> findByCompania(String compania) {
		return models.Proveedor.find.where().eq("compania_proveed", compania);
	}

}


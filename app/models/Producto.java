package models;

import java.util.*;

import javax.persistence.*;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model.*;
import play.data.validation.*;

@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long clav_prod;

	@Constraints.Required
	public String nomb_prod;
	
	@Constraints.Required
	public Integer prec_prod;
	
	
	public static Finder<Long, models.Producto> 
	find = new Finder<Long, models.Producto>(Long.class, models.Producto.class);

	public static List<models.Producto> findByNombre(String nombre) {
		return models.Producto.find.where().like("nomb_prod", "%" + nombre + "%").findList();
	}
}

package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;


@Entity
@Table(name="detalle_comanda")
public class VentaDetalle extends Model {
	@Id
	public long num_coman_det;
	
	public long num_coman;
	public long clav_prod_coman;
	public long cant_prod_coman;
	public long prec_prod_det;
	
	public Producto producto() {
		return Ebean.find(Producto.class, clav_prod_coman);
	}
	
	public long total() {
		return cant_prod_coman * prec_prod_det;
	}
	
	public static Finder<Long, VentaDetalle> 
	find = new Finder<Long, VentaDetalle>(Long.class, VentaDetalle.class);

}

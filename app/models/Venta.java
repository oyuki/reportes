package models;

import java.util.List;

import javax.persistence.*;

import play.db.ebean.Model.Finder;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;
import com.avaje.ebean.Query;

@Entity
@Table(name="comandas")
public class Venta {
	@Id
	public long num_coman;
	
	public String fech_coman;
	public Integer empl_coman;
	public Integer mesa_coman;
	public String estatus_coman;
	public String turno_coman;

	public List<VentaDetalle> detalles() {
		return VentaDetalle.find.where().eq("num_coman", num_coman).findList();
	}
	
	public long total() {
		long total = 0;
		for(VentaDetalle detalle: detalles()) {
			total += detalle.prec_prod_det * detalle.cant_prod_coman;
		}
		return total;
	}
	
	public Empleado empleado() {
		return Ebean.find(Empleado.class, empl_coman);
	}
	
	public static Finder<Long, Venta> 
	find = new Finder<Long, Venta>(Long.class, Venta.class);

}

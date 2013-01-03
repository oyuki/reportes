package models;


import java.util.*;

import javax.persistence.*;

import com.avaje.ebean.Ebean;

import com.avaje.ebean.ExpressionList;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import play.data.validation.*;

@Entity
@Table(name="empleados")
public class Empleado extends Model{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long num_empl;

	public String nomb_empl;
	public String ap_pat_empl;
	public String ap_mat_empl;
	public String f_nac_empl;
	public String calle_empl;
	public String num_calle_empl;
	public String colonia_empl;
	public String codp_empl;
	public String mun_empl;
	public String est_empl;
	public String edo_civil_empl;
	public String tel_fijo_empl;
	public String f_alta_empl;
	public String cen_trab_empl;
	public String puesto_empl;
	public String f_ini_puesto_act_empl;
	public String tel_cel_empl;

	public String nombre() {
		return nomb_empl + ' ' + ap_pat_empl + ' ' + ap_mat_empl;
	}
	public static Finder<Long, Empleado> 
	find = new Finder<Long, Empleado>(Long.class, models.Empleado.class);

	public static ExpressionList<Empleado> findByPuesto(String puesto) {
		return models.Empleado.find.where().eq("puesto_empl", puesto);
	}

}

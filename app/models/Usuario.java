package models;

import java.util.*;

import javax.persistence.*;

import com.avaje.ebean.Ebean;

import com.avaje.ebean.ExpressionList;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import play.data.validation.*;
import play.mvc.*;

import formas.usuarios.*;

@Entity
@Table(name="empleados")
public class Usuario extends Model {
	@Id
	public long num_empl;
	public String pass_empl;

	public static Finder<Long, Usuario> 
	find = new Finder<Long, Usuario>(Long.class, Usuario.class);
	
}

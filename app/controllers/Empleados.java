package controllers;

import java.util.List;

import com.avaje.ebean.Ebean;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;

import views.html.empleados.*;

public class Empleados extends Controller {
	
	public static Result index(String format) {
		return ok(index.render(form(formas.empleados.Filtro.class)));
    }
	
	public static Result puesto(String format) {
		return ok();
	}
}

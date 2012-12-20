package controllers;

import java.util.List;

import com.avaje.ebean.Ebean;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;

import views.html.*;


public class Proveedores extends Controller {

	public static Result index() {
	  return ok(views.html.proveedores.index.render(form(formas.proveedores.Filtro.class)));
	}

public static Result individual() {
	 
	 return ok(views.html.proveedores.individual.render(form(formas.proveedores.Individual.class)));
 }
	
	
}

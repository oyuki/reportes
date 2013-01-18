package controllers;

import java.util.List;

import com.avaje.ebean.Ebean;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;

import views.html.*;

@Security.Authenticated(Acceso.class)
public class Niveles  extends Controller{
	
	public static Result index(){
		return ok(views.html.niveles.index.render(form(formas.niveles.Filtro.class)));
	}

}

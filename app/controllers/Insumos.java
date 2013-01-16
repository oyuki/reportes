package controllers;

import java.util.List;

import com.avaje.ebean.Ebean;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;

import views.html.insumos.*;

public class Insumos extends Controller {
	
	public static Result index(String format) {
		return ok(views.html.insumos.index.render(form(formas.insumos.Filtro.class)));
	}

}

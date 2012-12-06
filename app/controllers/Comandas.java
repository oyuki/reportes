package controllers;

import java.util.List;

import com.avaje.ebean.Ebean;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;

import views.html.*;

public class Comandas extends Controller {
	
public static Result index() {
	
	return ok(views.html.comandas.index.render(form(formas.comandas.Filtro.class)));

   }
}
package controllers;

import java.io.ByteArrayOutputStream;
import java.util.List;

import models.*;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;

import views.html.usuarios.*;

public class Usuarios extends Controller{
	public static Result index() {
		return ok(index.render(form(formas.usuarios.Filtro.class)));
	}

	public static Result verificar() {
		Form<formas.usuarios.Filtro> forma = form(formas.usuarios.Filtro.class).bindFromRequest();
		formas.usuarios.Filtro usuarioForma = forma.get();
		List<Usuario> usuarios = Usuario.find
				.where()
				.eq("num_empl", usuarioForma.num_empleado)
				.eq("pass_empl", usuarioForma.password)
				.eq("puesto_empl", 0)
				.findList();
		if(usuarios.size() > 0) {
			session("logeado", "true");
			return redirect("/");
		} else {
		    return redirect("/prohibido");
		}
	}
	
	public static Result prohibido() {
		return ok("No tienes permiso de ver esta pagina");
	}
}

package controllers;

import java.util.List;

import models.Cliente;

import com.avaje.ebean.Ebean;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;

import views.html.*;

public class Clientes extends Controller {
	
	public static Result index() {
		List<Cliente> clientes = Cliente.find.all();
		return ok(views.html.clientes.index.render(clientes));
	}
	
	public static Result nuevo() {
		return ok(views.html.clientes.nuevo.render(form(formas.Cliente.class)));
	}
	
	public static Result crear() {
		// Recuperamos los parametros que mandan en el request
		Form<formas.Cliente> clienteForma = form(formas.Cliente.class).bindFromRequest();
		
		// ligamos nuestra forma con los parametros que nos mandaron
		formas.Cliente cliente = clienteForma.get();
		
		// Creamos un nuevo objeto del modelo donde lo queremos guardar
		models.Cliente nuevoCliente = new models.Cliente();
		
		// Se asignan los valores de la forma al modelo para después guardarlo
		nuevoCliente.nombre_cte = cliente.nombre_cte;
		nuevoCliente.ap_pat_cte = cliente.ap_pat_cte;
		nuevoCliente.rfc_cte = cliente.rfc_cte;
		
		// Ebean se encarga de guardar el nuevo registro
		Ebean.save(nuevoCliente);
		
		// Una vez creado el registro, redireccionamos el cliente a la accion index
		return redirect(routes.Clientes.index());
	}
}

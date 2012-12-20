package controllers;

import java.util.List;

import models.Cliente;

import com.avaje.ebean.Ebean;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;
import com.avaje.ebean.ExpressionList;

import views.html.*;

public class Clientes extends Controller {
	
	public static Result index() {
		Form<formas.clientes.Filtro> filtroForma = form(formas.clientes.Filtro.class).bindFromRequest();
		List<Cliente> clientes;
		formas.clientes.Filtro cliente = filtroForma.get();
		ExpressionList<Cliente> encontrar = Cliente.find.where();
	    
		if(cliente.nombre_cte != null && !cliente.nombre_cte.isEmpty()) {
			encontrar.like("nomb_cte + ap_pat_cte + ap_mat_cte","%" + cliente.nombre_cte + "%");
		}
		else if (cliente.rfc_cte != null && !cliente.rfc_cte.isEmpty()) {
			encontrar.like("rfc_cte", "%" + cliente.rfc_cte + "%");
		}
		else {
			clientes = Cliente.find.all();
		}
		clientes = encontrar.findList();
		return ok(views.html.clientes.index.render(clientes,filtroForma));
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
		nuevoCliente.nomb_cte = cliente.nombre_cte;
		nuevoCliente.ap_pat_cte = cliente.ap_pat_cte;
		nuevoCliente.rfc_cte = cliente.rfc_cte;
		nuevoCliente.ap_mat_cte = cliente.ap_mat_cte;
		nuevoCliente.calle_cte = cliente.calle_cte;
		nuevoCliente.mun_cte = cliente.mun_cte;
		nuevoCliente.num_calle_cte = cliente.num_calle_cte;
		nuevoCliente.colonia_cte = cliente.colonia_cte;
		nuevoCliente.codp_cte = cliente.codp_cte;
		nuevoCliente.mun_cte = cliente.mun_cte;
		nuevoCliente.est_cte = cliente.est_cte;
		nuevoCliente.tel_cte = cliente.tel_cte;
		nuevoCliente.email_cte = cliente.email_cte;
		
		// Ebean se encarga de guardar el nuevo registro
		Ebean.save(nuevoCliente);
		
		// Una vez creado el registro, redireccionamos el cliente a la accion index
		return redirect(routes.Clientes.index());
	}
	
	 public static Result individual() {
	    return ok(views.html.clientes.individual.render(form(formas.clientes.Individual.class)));
	 }
	
}


   
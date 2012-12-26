package controllers;

import java.util.List;

import models.Producto;

import com.avaje.ebean.Ebean;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;
import com.avaje.ebean.ExpressionList;

import views.html.*;

public class Productos extends Controller {
	
	public static Result index(){
		Form<formas.productos.Filtro> filtroForma = form(formas.productos.Filtro.class).bindFromRequest();
		List<Producto> productos;
		formas.productos.Filtro productoFiltro = filtroForma.get();
		ExpressionList<Producto> encontrar = models.Producto.find.where();
		
		if(productoFiltro.nom_prod != null && !productoFiltro.nom_prod.isEmpty()) {
			encontrar.like("nomb_prod", "%" + productoFiltro.nom_prod + "%");
		} else if(productoFiltro.clav_prod != null && !productoFiltro.clav_prod.isEmpty()) {
			encontrar.eq("clav_prod", productoFiltro.clav_prod);
		}
		
		productos = encontrar.findList();
		
		return ok(views.html.productos.index.render(filtroForma, productos));
	}

}

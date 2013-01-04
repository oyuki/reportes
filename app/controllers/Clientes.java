package controllers;

import java.io.ByteArrayOutputStream;
import java.util.List;

import models.Cliente;

import com.avaje.ebean.Ebean;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;
import com.avaje.ebean.ExpressionList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import views.html.clientes.*;

public class Clientes extends Controller {
	
	public static Result index() throws DocumentException {
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
		if (request().getQueryString("export_to") != null && request().getQueryString("export_to").equals("pdf")) {
			PdfPTable tabla = new PdfPTable(3);
			PdfPCell cell;
			cell = new PdfPCell(new Phrase("Reporte de Clientes"));
			cell.setColspan(3);
			tabla.addCell(cell);
			tabla.addCell("Numero");
			tabla.addCell("Nombre");
			tabla.addCell("RFC");
			for(Cliente tabla_cliente: clientes) {
				tabla.addCell(Long.toString(tabla_cliente.num_cte));
				tabla.addCell(tabla_cliente.nombre());
				tabla.addCell(tabla_cliente.rfc_cte);
			}
			Document resultado_pdf = new Document();
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PdfWriter.getInstance(resultado_pdf, stream);
			resultado_pdf.open();
			resultado_pdf.add(tabla);
			resultado_pdf.close();
			response().setContentType("application/pdf");
			response().setHeader("Content-Disposition", "attachment;filename=clientes.pdf");
			return ok(stream.toByteArray());
		} else {
		    return ok(views.html.clientes.index.render(clientes,filtroForma));
		}
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
		models.Cliente.create(cliente);
		
		// Una vez creado el registro, redireccionamos el cliente a la accion index
		return redirect(routes.Clientes.index());
	}
	
	 public static Result show(Integer id) {
		 Cliente cliente = Ebean.find(Cliente.class, id);
		 return ok(show.render(cliente));
	 }
	
}


   
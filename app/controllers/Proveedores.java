package controllers;

import java.io.ByteArrayOutputStream;
import java.util.List;

import models.Proveedor;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;

import views.html.proveedores.*;

@Security.Authenticated(Acceso.class)
public class Proveedores extends Controller {

	public static Result index(String format) throws DocumentException {
		Form<formas.proveedores.Filtro> filtroForma = form(formas.proveedores.Filtro.class).bindFromRequest();
		List<Proveedor> proveedores;
		formas.proveedores.Filtro proveedorFiltro = filtroForma.get();
		
		ExpressionList<Proveedor> encontrador = models.Proveedor.find.where();
		
		if(proveedorFiltro.clav_proveed != null && ! proveedorFiltro.clav_proveed.isEmpty()) {
			encontrador.eq("clav_proveed", proveedorFiltro.clav_proveed );
		}
		if(proveedorFiltro.compania_proveed != null && !proveedorFiltro.compania_proveed.isEmpty()) {
			encontrador.like("comp_proveed" , "%" + proveedorFiltro.compania_proveed );
		}
		
		if(proveedorFiltro.cont1_proveed != null && !proveedorFiltro.cont1_proveed.isEmpty()) {
			encontrador.eq("cont1_proveed", proveedorFiltro.cont1_proveed);
		}
		
		proveedores = encontrador.findList();
		
		if(format.equals(".pdf") || format == null) {
			PdfPTable tabla = new PdfPTable(3);
			PdfPCell cell;
			cell = new PdfPCell(new Phrase("Reporte de Proveedores"));
			cell.setColspan(4);
			tabla.addCell(cell);
			tabla.addCell("clave");
			tabla.addCell("compañia");
			tabla.addCell("Telelfono");
			for(Proveedor tabla_proveedor: proveedores) {
				tabla.addCell(Long.toString(tabla_proveedor.clav_proveed));
				tabla.addCell(tabla_proveedor.compania_proveed);
				tabla.addCell(tabla_proveedor.cont1_proveed);
			}
			Document resultado_pdf = new Document();
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PdfWriter.getInstance(resultado_pdf, stream);
			resultado_pdf.open();
			resultado_pdf.add(tabla);
			resultado_pdf.close();
			response().setContentType("application/pdf");
			response().setHeader("Content-Disposition", "attachment;filename=proveedores.pdf");
			return ok(stream.toByteArray());

		} else {
	  return ok(views.html.proveedores.index.render(filtroForma, proveedores));
	}
  } 
	

    public static Result show(Integer id) {
    	Proveedor proveedor = Ebean.find(Proveedor.class, id);
	  return ok(show.render(proveedor));
    
    }
}


package controllers;

import java.io.ByteArrayOutputStream;
import java.util.List;

import models.*;

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

import views.html.*;

@Security.Authenticated(Acceso.class)
public class Productos extends Controller {
	
	public static Result index(String format) throws DocumentException {
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
		if(format.equals(".html") || format == null) {
			return ok(views.html.productos.index.render(filtroForma, productos));
		} else {
			PdfPTable tabla = new PdfPTable(3);
			PdfPCell cell;
			cell = new PdfPCell(new Phrase("Reporte de Productos"));
			cell.setColspan(3);
			tabla.addCell(cell);
			tabla.addCell("Numero");
			tabla.addCell("Nombre");
			tabla.addCell("Precio");
			for(Producto tabla_producto: productos) {
				tabla.addCell(Long.toString(tabla_producto.clav_prod));
				tabla.addCell(tabla_producto.nomb_prod);
				tabla.addCell(tabla_producto.prec_prod.toString());
			}
			Document resultado_pdf = new Document();
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PdfWriter.getInstance(resultado_pdf, stream);
			resultado_pdf.open();
			resultado_pdf.add(tabla);
			resultado_pdf.close();
			response().setContentType("application/pdf");
			response().setHeader("Content-Disposition", "attachment;filename=productos.pdf");
			return ok(stream.toByteArray());

		}
	}

}

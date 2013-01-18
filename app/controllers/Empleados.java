package controllers;

import java.io.ByteArrayOutputStream;
import java.util.List;

import models.Empleado;
import models.Producto;

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

import views.html.empleados.*;

@Security.Authenticated(Acceso.class)
public class Empleados extends Controller {
	
	public static Result index(String format) throws DocumentException{
		Form<formas.empleados.Filtro> filtroForma = form(formas.empleados.Filtro.class).bindFromRequest();
		List<Empleado> empleados;
		formas.empleados.Filtro empleadoFiltro = filtroForma.get();
		
		ExpressionList<Empleado> encontrador = models.Empleado.find.where();
		
		if(empleadoFiltro.numero != null && !empleadoFiltro.numero.isEmpty()) {
			encontrador.eq("num_empl", empleadoFiltro.numero);
		}
		if(empleadoFiltro.nombre != null && !empleadoFiltro.nombre.isEmpty()) {
			encontrador.like("nomb_empl + ap_pat_empl + ap_mat_empl", "%" + empleadoFiltro.nombre + "%");
		}
		if(empleadoFiltro.puesto != null && !empleadoFiltro.puesto.isEmpty()) {
			encontrador.eq("puesto_empl", empleadoFiltro.puesto);
		}
		empleados = encontrador.findList();
		
		if(format.equals(".pdf") || format == null) {
			PdfPTable tabla = new PdfPTable(4);
			PdfPCell cell;
			cell = new PdfPCell(new Phrase("Reporte de Empleados"));
			cell.setColspan(4);
			tabla.addCell(cell);
			tabla.addCell("Numero");
			tabla.addCell("Nombre");
			tabla.addCell("Puesto");
			tabla.addCell("Tel Celular");
			for(Empleado tabla_empleado: empleados) {
				tabla.addCell(Long.toString(tabla_empleado.num_empl));
				tabla.addCell(tabla_empleado.nombre());
				tabla.addCell(tabla_empleado.puesto_empl);
				tabla.addCell(tabla_empleado.tel_cel_empl);
			}
			Document resultado_pdf = new Document();
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PdfWriter.getInstance(resultado_pdf, stream);
			resultado_pdf.open();
			resultado_pdf.add(tabla);
			resultado_pdf.close();
			response().setContentType("application/pdf");
			response().setHeader("Content-Disposition", "attachment;filename=empleados.pdf");
			return ok(stream.toByteArray());

		} else {
			return ok(index.render(filtroForma, empleados));
		}
    }
	
	public static Result show(Integer id) {
		Empleado empleado = Ebean.find(Empleado.class, id);
		return ok(show.render(empleado));
	}
}

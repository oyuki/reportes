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

import views.html.ventas.*;

public class Ventas extends Controller {

	public static Result index(String format) throws DocumentException {
		Form<formas.ventas.Filtro> filtroForma = form(formas.ventas.Filtro.class).bindFromRequest();
		formas.ventas.Filtro ventasFiltro = filtroForma.get();
		List<Venta> ventas;
		
		ExpressionList<Venta> encontrador = Venta.find.where();
		
		if(request().getQueryString("mes") != null && !request().getQueryString("mes").isEmpty()) {
			encontrador.eq("DATEPART(\"MONTH\", CONVERT(datetime, fech_coman))", request().getQueryString("mes"));
		}

		if(request().getQueryString("semana") != null && !request().getQueryString("semana").isEmpty()) {
			encontrador.eq("DATEPART(\"WEEK\", CONVERT(datetime, fech_coman))", request().getQueryString("semana"));
		}

		if(ventasFiltro.estado != null && !ventasFiltro.estado.isEmpty()) {
			encontrador.eq("estatus_coman", ventasFiltro.estado);
		}
		
		if(ventasFiltro.num_venta != null && !ventasFiltro.num_venta.isEmpty()) {
			encontrador.eq("num_coman", ventasFiltro.num_venta);
		}
		
		if(ventasFiltro.fecha != null && !ventasFiltro.fecha.isEmpty()) {
			encontrador.eq("fech_coman", ventasFiltro.fecha);
		}
		
		ventas = encontrador.findList();
		
		if(format.equals(".pdf") || format == null) {
			PdfPTable tabla = new PdfPTable(7);
			PdfPCell cell;
			cell = new PdfPCell(new Phrase("Reporte de Ventas"));
			cell.setColspan(7);
			tabla.addCell(cell);
			tabla.addCell("Num. Venta");
			tabla.addCell("Mesa");
			tabla.addCell("Fecha");
			tabla.addCell("Empleado");
			tabla.addCell("Estado");
			tabla.addCell("Turno");
			tabla.addCell("Total");
			for(Venta tabla_venta: ventas) {
				tabla.addCell(Long.toString(tabla_venta.num_coman));
				tabla.addCell(tabla_venta.mesa_coman.toString());
				tabla.addCell(tabla_venta.fech_coman);
				tabla.addCell(tabla_venta.empleado().nombre());
				tabla.addCell(tabla_venta.estatus_coman);
				tabla.addCell(tabla_venta.turno_coman);
				tabla.addCell(Long.toString(tabla_venta.total()));
			}
			Document resultado_pdf = new Document();
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PdfWriter.getInstance(resultado_pdf, stream);
			resultado_pdf.open();
			resultado_pdf.add(tabla);
			resultado_pdf.close();
			response().setContentType("application/pdf");
			response().setHeader("Content-Disposition", "attachment;filename=ventas.pdf");
			return ok(stream.toByteArray());

		} else {
			return ok(index.render(ventas, filtroForma));
		}
	}
	
	public static Result show(Integer id) {
		return ok("show");
//		Venta venta = Ebean.find(Venta.class, id);
//		return ok(show.render(venta));
	}
	
	public static Result semanal(String format) {
		List<models.consultas.Ventas> ventas = models.consultas.Ventas.ventasPorSemana();
		return ok(semanal.render(ventas));
	}
	
	public static Result mensual(String format) {
		List<models.consultas.Ventas> ventas = models.consultas.Ventas.ventasPorMes();
		return ok(mensual.render(ventas));
	}
}

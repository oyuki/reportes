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

	public static Result index(String format) {
		List<Venta> ventas;
		
		ExpressionList<Venta> encontrador = Venta.find.where();
		
		ventas = encontrador.findList();
		
		return ok(index.render(ventas));
	}
	
	public static Result show(Integer id) {
		return ok("show");
//		Venta venta = Ebean.find(Venta.class, id);
//		return ok(show.render(venta));
	}
	
	public static Result semanal(String format) {
		return ok("semanal");
	}
	
	public static Result mensual(String format) {
		return ok("mensual");
	}
}

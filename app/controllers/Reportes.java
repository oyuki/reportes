package controllers;

import play.*;
import play.mvc.*;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

import com.lowagie.text.*;

public class Reportes extends Controller {
	
	public static Result artsMasVend() throws JRException {
		Map reportParams = new HashMap();
	    //jrxml and jasper files should be in app/reports
//		response().setContentType("application/pdf");
//		response().setHeader("Content-Disposition", "attachment;filename=articulos_mas_vendidos.pdf");
	    return ok(reports.BaseJasperReport.generateReport("ArtsMasVend", reportParams));
	}

}

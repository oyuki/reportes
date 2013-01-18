package controllers;

import play.*;
import play.mvc.*;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

import com.lowagie.text.*;

@Security.Authenticated(Acceso.class)
public class Reportes extends Controller {
	
	public static Result artsMasVend() throws JRException {
		Map reportParams = new HashMap();
	    //jrxml and jasper files should be in app/reports
		response().setContentType("application/pdf");
		response().setHeader("Content-Disposition", "attachment;filename=articulos_mas_vendidos.pdf");
	    return ok(reports.BaseJasperReport.generateReport("ArtsMasVend", reportParams));
	}

	public static Result clientesFrecuentes() throws JRException {
		Map reportParams = new HashMap();
		response().setContentType("application/pdf");
		response().setHeader("Content-Disposition", "attachment;filename=clientes_frecuentes.pdf");
		return ok(reports.BaseJasperReport.generateReport("CtesFrec", reportParams));
	}

	public static Result existenciasMinimas() throws JRException {
		Map reportParams = new HashMap();
		response().setContentType("application/pdf");
		response().setHeader("Content-Disposition", "attachment;filename=existencias_minimas.pdf");
		return ok(reports.BaseJasperReport.generateReport("ExisMin", reportParams));
	}
	public static Result historialComprasProveedor() throws JRException {
	
		Map reportParams = new HashMap();
		response().setContentType("application/pdf");
		response().setHeader("Content-Disposition", "attachment;filename=historial_compras_proveedor.pdf");
		return ok(reports.BaseJasperReport.generateReport("HistCompXProv", reportParams));
	}
	
	 public static Result historialFacturacion() throws JRException {
		 
		Map reportParams = new HashMap();
		response().setContentType("application/pdf");
		response().setHeader("Content-Disposition", "attachment;filename=historias_facturacion.pdf");
		return ok(reports.BaseJasperReport.generateReport("HistFact", reportParams));
	}
	
	 public static Result  historialVenta() throws JRException {
		 
			Map reportParams = new HashMap();
			response().setContentType("application/pdf");
			response().setHeader("Content-Disposition", "attachment;filename=historial_venta.pdf");
			return ok(reports.BaseJasperReport.generateReport("HistVentas", reportParams));
		}
	 
	 public static Result  platosMasVendido() throws JRException {
		 
			Map reportParams = new HashMap();
			response().setContentType("application/pdf");
			response().setHeader("Content-Disposition", "attachment;filename=platos_mas_vendido.pdf");
			return ok(reports.BaseJasperReport.generateReport("PlatMasVend", reportParams));
		}

	 public static Result  requisicionesPendiente() throws JRException {
		 
			Map reportParams = new HashMap();
			response().setContentType("application/pdf");
			response().setHeader("Content-Disposition", "attachment;filename=requisiciones_pendiente.pdf");
			return ok(reports.BaseJasperReport.generateReport("ReqPend", reportParams));
		}
	
	 public static Result  requisicionesHistorial() throws JRException {
		 
			Map reportParams = new HashMap();
			response().setContentType("application/pdf");
			response().setHeader("Content-Disposition", "attachment;filename=requisiciones_historial.pdf");
			return ok(reports.BaseJasperReport.generateReport("ReqHist", reportParams));
		}
	 public static Result  historialOrdenesCompras() throws JRException {
		 
			Map reportParams = new HashMap();
			response().setContentType("application/pdf");
			response().setHeader("Content-Disposition", "attachment;filename=historial_ordenes_compras.pdf");
			return ok(reports.BaseJasperReport.generateReport("HistOrdComp", reportParams));
		}

}

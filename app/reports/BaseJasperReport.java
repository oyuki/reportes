package reports;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;

import com.itextpdf.text.DocumentException;

public class BaseJasperReport {
  //here should be jrxml and jasper files, 
  //you can generate them with iReports(I'm using netbeans plugin)
  // http://jasperforge.org/projects/ireport 
  static String REPORT_DEFINITION_PATH = "./app/reports/reportes/";
 
  public static InputStream generateReport(String reportDefFile, Map reportParams) throws JRException {
	reportParams.put("language", "java");
    OutputStream os = new ByteArrayOutputStream();
    try {
      String compiledFile = REPORT_DEFINITION_PATH + reportDefFile + ".jasper";
      JasperCompileManager.compileReportToFile(REPORT_DEFINITION_PATH + reportDefFile + ".jrxml", compiledFile);
      JasperPrint jrprint = JasperFillManager.fillReport(compiledFile, reportParams, play.db.DB.getConnection());
//      JRExporter exporter = new JExcelApiExporter();
      JRExporter exporter = new JRPdfExporter();
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
      exporter.setParameter(JRExporterParameter.JASPER_PRINT, jrprint);
      exporter.exportReport();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ByteArrayInputStream(((ByteArrayOutputStream) os).toByteArray());
  }
}
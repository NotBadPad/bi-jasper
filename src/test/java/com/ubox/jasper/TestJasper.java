package com.ubox.jasper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: guojing
 * Date: 14-11-18
 * Time: 上午10:56
 * To change this template use File | Settings | File Templates.
 */
public class TestJasper {

    @Test
    public void createJasper(){
        String sourceFileName = "E:\\workspace\\java\\bi-jasper\\data\\Invoice.jrxml";
        String disteFileName = "E:\\workspace\\java\\bi-jasper\\data\\Invoice.jasper";
        try {
            JasperCompileManager.compileReportToFile(sourceFileName,disteFileName);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createJrprint() {
        String sourceFileName = "E:\\workspace\\java\\bi-jasper\\data\\Invoice.jasper";
        Map parameters = new HashMap();
        try {
            JasperFillManager.fillReportToFile(sourceFileName, parameters);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void export() {
        String jrprintFileName = "E:\\workspace\\java\\bi-jasper\\data\\Invoice.jrprint";
        String distFileName = "E:\\workspace\\java\\bi-jasper\\data\\Invoice";
        try {
            JasperExportManager.exportReportToHtmlFile(jrprintFileName,distFileName+".html");
//            JasperExportManager.exportReportToPdfFile(jrprintFileName, distFileName + ".pdf");
//
//            JRXlsExporter je = new JRXlsExporter();
//            je.setExporterInput(new SimpleExporterInput(jrprintFileName));
//            je.setExporterOutput(new SimpleOutputStreamExporterOutput(distFileName+".xls"));
        } catch (JRException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}

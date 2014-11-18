package com.ubox.jasper;

import net.sf.jasperreports.engine.JRException;
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
    public void createJrprint() {
        String sourceFileName = "E:\\workspace\\JaspersoftWorkspace\\test1\\Invoice.jasper";
        Map parameters = new HashMap();
        try {
            JasperFillManager.fillReportToFile(sourceFileName, parameters);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void export() {
        String jrprintFileName = "E:\\workspace\\JaspersoftWorkspace\\test1\\Invoice.jrprint";
        String distFileName = "E:\\workspace\\JaspersoftWorkspace\\test1\\Invoice";
        try {
            JasperExportManager.exportReportToHtmlFile(jrprintFileName,distFileName+".html");
            JasperExportManager.exportReportToPdfFile(jrprintFileName, distFileName + ".pdf");

            JRXlsExporter je = new JRXlsExporter();
            je.setExporterInput(new SimpleExporterInput(jrprintFileName));
            je.setExporterOutput(new SimpleOutputStreamExporterOutput(distFileName+".xls"));
        } catch (JRException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}

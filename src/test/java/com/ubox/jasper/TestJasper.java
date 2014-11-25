package com.ubox.jasper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.view.JasperDesignViewer;
import org.junit.Test;

import java.sql.*;
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
            JasperCompileManager.compileReportToFile(sourceFileName, disteFileName);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void viewJasper(){
        String sourceFileName = "E:\\workspace\\java\\bi-jasper\\data\\Invoice.jrxml";
        try {
            JasperDesignViewer jdw = new JasperDesignViewer(sourceFileName,true);
            jdw.setVisible(true);
            Thread.sleep(100000);
        } catch (JRException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Test
    public void createJrprint() {
        String sourceFileName = "E:\\workspace\\java\\bi-jasper\\data\\Invoice.jasper";
        Map parameters = new HashMap();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.8.73:3306/workflow?autocommit=true&charset=utf8","workflow","vRiOQXLdAzDYF65p7Uv8");

            JasperFillManager.fillReportToFile(sourceFileName, parameters,con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void export() {
        String jrprintFileName = "E:\\workspace\\java\\bi-jasper\\data\\Invoice.jrprint";
        String distFileName = "E:\\workspace\\java\\bi-jasper\\data\\Invoice";
        try {
            //导出html
            JasperExportManager.exportReportToHtmlFile(jrprintFileName,distFileName+".html");
            //导出pdf
            JasperExportManager.exportReportToPdfFile(jrprintFileName, distFileName + ".pdf");

            //导出xls
            JRXlsExporter je = new JRXlsExporter();
            je.setExporterInput(new SimpleExporterInput(jrprintFileName));
            je.setExporterOutput(new SimpleOutputStreamExporterOutput(distFileName+".xls"));
            je.exportReport();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}

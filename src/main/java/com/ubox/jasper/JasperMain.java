package com.ubox.jasper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: guojing
 * Date: 14-11-17
 * Time: 下午6:14
 * To change this template use File | Settings | File Templates.
 */
public class JasperMain {
    public static void main(String[] args) {
        String sourceFileName = "E:\\workspace\\JaspersoftWorkspace\\test1\\Invoice.jasper";
        Map parameters = new HashMap();
        try {
            JasperFillManager.fillReportToFile(sourceFileName,parameters);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}

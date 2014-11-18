package com.ubox.jasper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: guojing
 * Date: 14-11-18
 * Time: 上午10:52
 * To change this template use File | Settings | File Templates.
 */
public class JasperOperater {

    /**
     * 生成jrprint文件
     * @param sourceFileName
     */
    public void createJrprint(String sourceFileName,String destFileName){
        Map parameters = new HashMap();
        try {
            JasperFillManager.fillReportToFile(sourceFileName,destFileName, parameters);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}

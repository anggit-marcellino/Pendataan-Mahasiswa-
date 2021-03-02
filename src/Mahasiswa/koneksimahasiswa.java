/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mahasiswa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author MARSHMALLOW
 */
public class koneksimahasiswa{
    public static Connection getConnection() {
        Connection con = null;
        try {
            String jdbcDriver = "com.mysql.jdbc.Driver";
            Class.forName(jdbcDriver);

            String url = "jdbc:mysql://localhost/dbtugasbesar";
            String user = "root";
            String pass = "";

            con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();

            try {
                Map<String, Object> prs = new HashMap<String, Object>();
                JasperReport JRpt = JasperCompileManager.compileReport("reporttugasbesar.jrxml");
                JasperPrint JPrint = JasperFillManager.fillReport(JRpt, prs, con);
                JasperViewer.viewReport(JPrint, false);
            } catch (JRException rptexcpt) {
                System.out.println("Report Can't view because : " + rptexcpt);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;
}
    
}

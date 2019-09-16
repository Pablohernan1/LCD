
package generarremitoslcd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class Cliente {
        String cliente, domicilio, telefono, celular, aparato, modelo, serie,
                falla, observaciones, importe;
          
               
    public void establecerCliente(String cliente){
        this.cliente = cliente;
    }
    public void establecerDomicilio(String domicilio){
        this.domicilio = domicilio;
    } 
    public void establecerTelefono(String telefono){
        this.telefono = telefono;
    } 
    public void establecerCelular(String celular){
        this.celular = celular;
    } 
    public void establecerAparato(String aparato){
        this.aparato = aparato;
    } 
    public void establecerModelo(String modelo){
        this.modelo = modelo;
    } 
    public void establecerSerie(String serie){
        this.serie = serie;
    } 
    public void establecerFalla(String falla){
        this.falla = falla;
    } 
    public void establecerObservaciones(String observaciones){
        this.observaciones = observaciones;
    } 
    public void establecerImporte(String importe){
        this.importe = importe;
    } 
    
     
    public String obtenerCliente(){
        return cliente;
    }
    public String obtenerDomicilio(){
        return domicilio;
    }
    public String obtenerTelefono(){
        return telefono;
    }
    public String obtenerCelular(){
        return celular;
    }
    public String obtenerAparato(){
        return aparato;
    }
    public String obtenerModelo(){
        return modelo;
    }
    public String obtenerSerie(){
        return serie;
    }
    public String obtenerFalla(){
        return falla;
    }
    public String obtenerObservaciones(){
        return observaciones;
    }
    public String obtenerImporte(){
        return importe;
    }

    public  void generarRemito(){
        try {
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/remitos", "root", "");
                   InputStream in = new FileInputStream(new File("C:\\Reportes\\remitos.jrxml"));
                   JasperDesign jd = JRXmlLoader.load(in);
                   String sql = " select * from remitos where orden in (select max(orden) from remitos)";
                   JRDesignQuery newQuery = new JRDesignQuery();
                   newQuery.setText(sql);
                   jd.setQuery(newQuery);
                   JasperReport jr = JasperCompileManager.compileReport(jd);
                   HashMap para = new HashMap();
                   JasperPrint j=JasperFillManager.fillReport(jr,para,con);
                   JasperViewer.viewReport(j, false);
                   OutputStream os = new FileOutputStream(new File("C:\\Reportes"));
                   JasperExportManager.exportReportToPdfStream(j,os);

        } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
        }
    }    
    
    
    
    
    public void baseDeDatos(){
        try {
            //System.out.println("Conectando a Base de datos");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/remitos", "root", "");
            //System.out.println("Conectado");
            
        } catch (Exception e) {
            //System.out.println("Error al conectar.");
        }
    }
    
    public void ejecutarQuery(String sql, String sql2){
          try {
            //System.out.println("Conectando a Base de datos");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/remitos", "root", "");
            //System.out.println("Conectado");
            con.prepareStatement(sql+sql2).execute();
            
        } catch (Exception e) {
            //System.out.println("Error al conectar.");
        }
    }
    
    public void espera(){
        loader Loader = new loader();
        Loader.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(50);
                if (i==100) {
                    Loader.setVisible(false);
                    new home().setVisible(true);
                    }}
                } catch (Exception e) {
            }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //new remitos().setVisible(true);
                    new remitos().setVisible(false);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(remitos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(remitos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}

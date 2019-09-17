
package generarremitoslcd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
            falla, observaciones, importe,localidad, marca;
        
    String cliente1, domicilio1, localidad1, aparato1, marca1,falla1,
            importe1,observaciones1;
    
    int telefono1,cel1,ordenABuscar;
       
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
        public void establecerMarca(String marca){
        this.marca = marca;
    } 
    public void establecerObservaciones(String observaciones){
        this.observaciones = observaciones;
    } 
    public void establecerImporte(String importe){
        this.importe = importe;
    } 
        public void establecerLocalidad(String localidad){
        this.localidad = localidad;
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
    public void establecerOrdenBuscar(int ordenABuscar){

        this.ordenABuscar = ordenABuscar;
                //System.out.println("Se graba la orden a buscar" + this.ordenABuscar+ ordenABuscar);
    }
    public void consultaBaseDeDatos(int ordenPorBuscar){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/remitos", "root", "");
            String sql = " select * from remitos where orden ="+ordenPorBuscar;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                this.cliente1 = rs.getString("cliente");
                this.telefono1 = rs.getInt("telefono");
                this.cel1 = rs.getInt("celular");
                this.domicilio1 = rs.getString("domicilio");
                this.localidad1 = rs.getString("localidad");
                this.aparato1 = rs.getString("aparato");
                this.marca1 = rs.getString("marca");
                this.falla1 = rs.getString("falla");
                this.importe1 = rs.getString("importe");
                this.observaciones1 = rs.getString("observaciones");
            }   
        }   catch (Exception e) {
            System.out.println("");
        } 
    }
    public String obtenerCliente1(){
        return cliente1;
    }
    public int obtenerTelefono1(){
        return telefono1;
    }
    public int obtenerCelular1(){
        return cel1;
    }
    public String obtenerDomicilio1(){
        return domicilio1;
    }
    public String obtenerLocalidad1(){
        return localidad1;
    }
    public String obtenerAparato1(){
        return aparato1;
    }
    public String obtenerMarca1(){
        return marca1;
    }
    public String obtenerFalla1(){
        return falla1;
    }
    public String obtenerImporte1(){
        return importe1;
    }
    public String obtenerObservaciones1(){
        return observaciones1;
    }   
    public void generarRemitoEnConsulta(int ordenPorBuscar){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/remitos", "root", "");
            InputStream in = new FileInputStream(new File("C:\\Reportes\\remitos.jrxml"));
            JasperDesign jd = JRXmlLoader.load(in);
            int orden1 = ordenPorBuscar;
            String sql = " select * from remitos where orden ="+orden1;
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
    public void modificarRemito(int ordenPorBuscar){
              
        try {
            System.out.println("Conectando a Base de datos");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/remitos", "root", "");
            System.out.println("Conectado");

            String sql = "UPDATE remitos SET cliente =?, telefono =?,  celular = ?,domicilio =?, localidad =?, aparato=?, marca=?, falla=?, importe=?, observaciones=? WHERE orden=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, this.cliente);
            System.out.println(this.cliente);    
            statement.setString(2, this.telefono);

            statement.setString(3, this.celular);
            statement.setString(4,this.domicilio);
            statement.setString(5,this.localidad);
            statement.setString(6,this.aparato);
            statement.setString(7,this.marca);
            statement.setString(8,this.falla);
            statement.setString(9, this.importe);
            statement.setString(10,this.observaciones);
            statement.setInt(11,ordenPorBuscar);

            int rowsUpdated = statement.executeUpdate();
            
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
                
            }
                } catch (SQLException e) {
            System.out.println("Error al conectar."+e.getMessage());
        }
        catch(ClassNotFoundException e){
        }
        catch(Exception e){
            System.out.println("Se ha encontrado el siguiente error: "+e.getMessage());
        }
        
        
    } 
}

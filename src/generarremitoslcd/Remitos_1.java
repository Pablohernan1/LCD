/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generarremitoslcd;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author pzanelli
 */
@Entity
@Table(name = "remitos", catalog = "remitos", schema = "")
@NamedQueries({
    @NamedQuery(name = "Remitos_1.findAll", query = "SELECT r FROM Remitos_1 r")
    , @NamedQuery(name = "Remitos_1.findByOrden", query = "SELECT r FROM Remitos_1 r WHERE r.orden = :orden")
    , @NamedQuery(name = "Remitos_1.findByFecha", query = "SELECT r FROM Remitos_1 r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Remitos_1.findByCliente", query = "SELECT r FROM Remitos_1 r WHERE r.cliente = :cliente")
    , @NamedQuery(name = "Remitos_1.findByTelefono", query = "SELECT r FROM Remitos_1 r WHERE r.telefono = :telefono")
    , @NamedQuery(name = "Remitos_1.findByCelular", query = "SELECT r FROM Remitos_1 r WHERE r.celular = :celular")
    , @NamedQuery(name = "Remitos_1.findByDomicilio", query = "SELECT r FROM Remitos_1 r WHERE r.domicilio = :domicilio")
    , @NamedQuery(name = "Remitos_1.findByLocalidad", query = "SELECT r FROM Remitos_1 r WHERE r.localidad = :localidad")
    , @NamedQuery(name = "Remitos_1.findByAparato", query = "SELECT r FROM Remitos_1 r WHERE r.aparato = :aparato")
    , @NamedQuery(name = "Remitos_1.findByMarca", query = "SELECT r FROM Remitos_1 r WHERE r.marca = :marca")
    , @NamedQuery(name = "Remitos_1.findByFalla", query = "SELECT r FROM Remitos_1 r WHERE r.falla = :falla")
    , @NamedQuery(name = "Remitos_1.findByImporte", query = "SELECT r FROM Remitos_1 r WHERE r.importe = :importe")
    , @NamedQuery(name = "Remitos_1.findByRemitoscol", query = "SELECT r FROM Remitos_1 r WHERE r.remitoscol = :remitoscol")})
public class Remitos_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orden")
    private Integer orden;
    @Column(name = "fecha")
    private Integer fecha;
    @Column(name = "cliente")
    private String cliente;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "celular")
    private Integer celular;
    @Column(name = "domicilio")
    private String domicilio;
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "aparato")
    private String aparato;
    @Column(name = "marca")
    private String marca;
    @Column(name = "falla")
    private String falla;
    @Column(name = "importe")
    private String importe;
    @Column(name = "remitoscol")
    private Integer remitoscol;

    public Remitos_1() {
    }

    public Remitos_1(Integer orden) {
        this.orden = orden;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        Integer oldOrden = this.orden;
        this.orden = orden;
        changeSupport.firePropertyChange("orden", oldOrden, orden);
    }

    public Integer getFecha() {
        return fecha;
    }

    public void setFecha(Integer fecha) {
        Integer oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        String oldCliente = this.cliente;
        this.cliente = cliente;
        changeSupport.firePropertyChange("cliente", oldCliente, cliente);
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        Integer oldTelefono = this.telefono;
        this.telefono = telefono;
        changeSupport.firePropertyChange("telefono", oldTelefono, telefono);
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        Integer oldCelular = this.celular;
        this.celular = celular;
        changeSupport.firePropertyChange("celular", oldCelular, celular);
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        String oldDomicilio = this.domicilio;
        this.domicilio = domicilio;
        changeSupport.firePropertyChange("domicilio", oldDomicilio, domicilio);
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        String oldLocalidad = this.localidad;
        this.localidad = localidad;
        changeSupport.firePropertyChange("localidad", oldLocalidad, localidad);
    }

    public String getAparato() {
        return aparato;
    }

    public void setAparato(String aparato) {
        String oldAparato = this.aparato;
        this.aparato = aparato;
        changeSupport.firePropertyChange("aparato", oldAparato, aparato);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        String oldMarca = this.marca;
        this.marca = marca;
        changeSupport.firePropertyChange("marca", oldMarca, marca);
    }

    public String getFalla() {
        return falla;
    }

    public void setFalla(String falla) {
        String oldFalla = this.falla;
        this.falla = falla;
        changeSupport.firePropertyChange("falla", oldFalla, falla);
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        String oldImporte = this.importe;
        this.importe = importe;
        changeSupport.firePropertyChange("importe", oldImporte, importe);
    }

    public Integer getRemitoscol() {
        return remitoscol;
    }

    public void setRemitoscol(Integer remitoscol) {
        Integer oldRemitoscol = this.remitoscol;
        this.remitoscol = remitoscol;
        changeSupport.firePropertyChange("remitoscol", oldRemitoscol, remitoscol);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orden != null ? orden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remitos_1)) {
            return false;
        }
        Remitos_1 other = (Remitos_1) object;
        if ((this.orden == null && other.orden != null) || (this.orden != null && !this.orden.equals(other.orden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "generarremitoslcd.Remitos_1[ orden=" + orden + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

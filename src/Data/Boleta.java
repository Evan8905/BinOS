
package Data;

import java.util.Date;

/**
 *
 * @author eefre
 */
public class Boleta {
    private String Nboleta;
    // Variables del primer bin
    private String Nbin1;
    private String idFinca1;
    private String idLote1;
    private String Cantidad1;
    // Variables del segundo bin
    private String Nbin2;
    private String idFinca2;
    private String idLote2;
    private String Cantidad2;
    
     // Resto de variables
    private String placaCamion;
    private Date date;
    private String horaCarga;
    private String horaDescarga;
    private String idCosecha;
    private String idFruto;
    private String Cuadrilla;
    private String Observaciones;

    public Boleta(String Nboleta, String Nbin1, String idFinca1, String idLote1, String Cantidad1, String Nbin2, String idFinca2, String idLote2, String Cantidad2, String placaCamion, Date date, String horaCarga, String horaDescarga, String idCosecha, String idFruto, String Cuadrilla, String Observaciones) {
        this.Nboleta = Nboleta;
        this.Nbin1 = Nbin1;
        this.idFinca1 = idFinca1;
        this.idLote1 = idLote1;
        this.Cantidad1 = Cantidad1;
        this.Nbin2 = Nbin2;
        this.idFinca2 = idFinca2;
        this.idLote2 = idLote2;
        this.Cantidad2 = Cantidad2;
        this.placaCamion = placaCamion;
        this.date = date;
        this.horaCarga = horaCarga;
        this.horaDescarga = horaDescarga;
        this.idCosecha = idCosecha;
        this.idFruto = idFruto;
        this.Cuadrilla = Cuadrilla;
        this.Observaciones = Observaciones;
    }

    public String getNboleta() {
        return Nboleta;
    }

    public void setNboleta(String Nboleta) {
        this.Nboleta = Nboleta;
    }

    public String getNbin1() {
        return Nbin1;
    }

    public void setNbin1(String Nbin1) {
        this.Nbin1 = Nbin1;
    }

    public String getIdFinca1() {
        return idFinca1;
    }

    public void setIdFinca1(String idFinca1) {
        this.idFinca1 = idFinca1;
    }

    public String getIdLote1() {
        return idLote1;
    }

    public void setIdLote1(String idLote1) {
        this.idLote1 = idLote1;
    }

    public String getCantidad1() {
        return Cantidad1;
    }

    public void setCantidad1(String Cantidad1) {
        this.Cantidad1 = Cantidad1;
    }

    public String getNbin2() {
        return Nbin2;
    }

    public void setNbin2(String Nbin2) {
        this.Nbin2 = Nbin2;
    }

    public String getIdFinca2() {
        return idFinca2;
    }

    public void setIdFinca2(String idFinca2) {
        this.idFinca2 = idFinca2;
    }

    public String getIdLote2() {
        return idLote2;
    }

    public void setIdLote2(String idLote2) {
        this.idLote2 = idLote2;
    }

    public String getCantidad2() {
        return Cantidad2;
    }

    public void setCantidad2(String Cantidad2) {
        this.Cantidad2 = Cantidad2;
    }

    public String getPlacaCamion() {
        return placaCamion;
    }

    public void setPlacaCamion(String placaCamion) {
        this.placaCamion = placaCamion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHoraCarga() {
        return horaCarga;
    }

    public void setHoraCarga(String horaCarga) {
        this.horaCarga = horaCarga;
    }

    public String getHoraDescarga() {
        return horaDescarga;
    }

    public void setHoraDescarga(String horaDescarga) {
        this.horaDescarga = horaDescarga;
    }

    public String getIdCosecha() {
        return idCosecha;
    }

    public void setIdCosecha(String idCosecha) {
        this.idCosecha = idCosecha;
    }

    public String getIdFruto() {
        return idFruto;
    }

    public void setIdFruto(String idFruto) {
        this.idFruto = idFruto;
    }

    public String getCuadrilla() {
        return Cuadrilla;
    }

    public void setCuadrilla(String Cuadrilla) {
        this.Cuadrilla = Cuadrilla;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    

    
}

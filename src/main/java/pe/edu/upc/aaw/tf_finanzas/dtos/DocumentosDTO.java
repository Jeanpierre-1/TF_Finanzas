package pe.edu.upc.aaw.tf_finanzas.dtos;

import pe.edu.upc.aaw.tf_finanzas.entities.Deudores;

import java.time.LocalDate;

public class DocumentosDTO {
    private int id;
    private CarteraDTO cartera;
    private Deudores deudor;
    private String tipo;
    private String numero_documento;
    private double valor_nominal;
    private LocalDate fecha_emision;
    private LocalDate fecha_vencimiento;
    private String moneda;
    private double valor_tasa;
    private String tipo_tasa;
    private String dias_tasa;
    private String periodo_capitalizacion;
    private double tasa_efectiva_calculada;
    private String tipo_tasa_efectiva;
    private double portes;
    private double comision_estudios;
    private double comision_desembolso;
    private double comision_cobranza;
    private double igv;
    private int dias_descuento;
    private double tasa_descuento;
    private double valor_neto;
    private double intereses_calculados;
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarteraDTO getCartera() {
        return cartera;
    }

    public void setCartera(CarteraDTO cartera) {
        this.cartera = cartera;
    }

    public Deudores getDeudor() {
        return deudor;
    }

    public void setDeudor(Deudores deudor) {
        this.deudor = deudor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public double getValor_nominal() {
        return valor_nominal;
    }

    public void setValor_nominal(double valor_nominal) {
        this.valor_nominal = valor_nominal;
    }

    public LocalDate getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(LocalDate fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public LocalDate getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(LocalDate fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getValor_tasa() {
        return valor_tasa;
    }

    public void setValor_tasa(double valor_tasa) {
        this.valor_tasa = valor_tasa;
    }

    public String getTipo_tasa() {
        return tipo_tasa;
    }

    public void setTipo_tasa(String tipo_tasa) {
        this.tipo_tasa = tipo_tasa;
    }

    public String getDias_tasa() {
        return dias_tasa;
    }

    public void setDias_tasa(String dias_tasa) {
        this.dias_tasa = dias_tasa;
    }

    public String getPeriodo_capitalizacion() {
        return periodo_capitalizacion;
    }

    public void setPeriodo_capitalizacion(String periodo_capitalizacion) {
        this.periodo_capitalizacion = periodo_capitalizacion;
    }

    public double getTasa_efectiva_calculada() {
        return tasa_efectiva_calculada;
    }

    public void setTasa_efectiva_calculada(double tasa_efectiva_calculada) {
        this.tasa_efectiva_calculada = tasa_efectiva_calculada;
    }

    public String getTipo_tasa_efectiva() {
        return tipo_tasa_efectiva;
    }

    public void setTipo_tasa_efectiva(String tipo_tasa_efectiva) {
        this.tipo_tasa_efectiva = tipo_tasa_efectiva;
    }

    public double getPortes() {
        return portes;
    }

    public void setPortes(double portes) {
        this.portes = portes;
    }

    public double getComision_estudios() {
        return comision_estudios;
    }

    public void setComision_estudios(double comision_estudios) {
        this.comision_estudios = comision_estudios;
    }

    public double getComision_desembolso() {
        return comision_desembolso;
    }

    public void setComision_desembolso(double comision_desembolso) {
        this.comision_desembolso = comision_desembolso;
    }

    public double getComision_cobranza() {
        return comision_cobranza;
    }

    public void setComision_cobranza(double comision_cobranza) {
        this.comision_cobranza = comision_cobranza;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public int getDias_descuento() {
        return dias_descuento;
    }

    public void setDias_descuento(int dias_descuento) {
        this.dias_descuento = dias_descuento;
    }

    public double getTasa_descuento() {
        return tasa_descuento;
    }

    public void setTasa_descuento(double tasa_descuento) {
        this.tasa_descuento = tasa_descuento;
    }

    public double getValor_neto() {
        return valor_neto;
    }

    public void setValor_neto(double valor_neto) {
        this.valor_neto = valor_neto;
    }

    public double getIntereses_calculados() {
        return intereses_calculados;
    }

    public void setIntereses_calculados(double intereses_calculados) {
        this.intereses_calculados = intereses_calculados;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

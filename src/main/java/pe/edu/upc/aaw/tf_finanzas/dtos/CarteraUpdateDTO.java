package pe.edu.upc.aaw.tf_finanzas.dtos;

import pe.edu.upc.aaw.tf_finanzas.entities.Bancos;

import java.time.LocalDate;

public class CarteraUpdateDTO {
    private int id;
    private Bancos bancos;
    private LocalDate fecha_descuento;
    private String moneda;
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bancos getBancos() {
        return bancos;
    }

    public void setBancos(Bancos bancos) {
        this.bancos = bancos;
    }

    public LocalDate getFecha_descuento() {
        return fecha_descuento;
    }

    public void setFecha_descuento(LocalDate fecha_descuento) {
        this.fecha_descuento = fecha_descuento;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

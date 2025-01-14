package pe.edu.upc.aaw.tf_finanzas.dtos;

import pe.edu.upc.aaw.tf_finanzas.entities.Bancos;

import java.time.LocalDate;

public class CarteraDTO {
    private int id;
    private UserDTO usuarios;
    private Bancos bancos;
    private LocalDate fecha_descuento;
    private String moneda;
    private double total_valor_nominal;
    private double total_valor_neto;
    private double tcea;
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDTO getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(UserDTO usuarios) {
        this.usuarios = usuarios;
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

    public double getTotal_valor_nominal() {
        return total_valor_nominal;
    }

    public void setTotal_valor_nominal(double total_valor_nominal) {
        this.total_valor_nominal = total_valor_nominal;
    }

    public double getTotal_valor_neto() {
        return total_valor_neto;
    }

    public void setTotal_valor_neto(double total_valor_neto) {
        this.total_valor_neto = total_valor_neto;
    }

    public double getTcea() {
        return tcea;
    }

    public void setTcea(double tcea) {
        this.tcea = tcea;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

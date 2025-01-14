package pe.edu.upc.aaw.tf_finanzas.dtos;

import java.time.LocalDate;

public class ValorDolarDTO {
    private int id;
    private double valor_dolar;
    private LocalDate fecha_registro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor_dolar() {
        return valor_dolar;
    }

    public void setValor_dolar(double valor_dolar) {
        this.valor_dolar = valor_dolar;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}

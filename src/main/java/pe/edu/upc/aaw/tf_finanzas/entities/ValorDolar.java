package pe.edu.upc.aaw.tf_finanzas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "valorDolar")
public class ValorDolar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "valor_dolar")
    private double valor_dolar;
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fecha_registro;

    public ValorDolar() {
    }

    public ValorDolar(int id, double valor_dolar, LocalDate fecha_registro) {
        this.id = id;
        this.valor_dolar = valor_dolar;
        this.fecha_registro = fecha_registro;
    }

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

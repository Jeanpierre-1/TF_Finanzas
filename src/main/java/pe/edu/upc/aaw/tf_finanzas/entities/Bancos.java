package pe.edu.upc.aaw.tf_finanzas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Bancos")
public class Bancos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre ;
    @Column(name = "codigo", length = 200, nullable = false)
    private String codigo ;
    @Column(name = "ruc", length = 200, nullable = false)
    private String ruc ;

    public Bancos() {
    }

    public Bancos(int id, String nombre, String codigo, String ruc) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.ruc = ruc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
}

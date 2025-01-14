package pe.edu.upc.aaw.tf_finanzas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Deudores")
public class Deudores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ruc", length = 20, nullable = false)
    private String ruc;
    @Column(name = "razon_social", length = 200, nullable = false)
    private String razon_social;
    @Column(name = "direccion", length = 200, nullable = false)
    private String direccion;
    @Column(name = "telefono", length = 20, nullable = false)
    private String telefono;
    @Column(name = "email", length = 200, nullable = false)
    private String email;


    public Deudores() {
    }

    public Deudores(int id, String ruc, String razon_social, String direccion, String telefono, String email) {
        this.id = id;
        this.ruc = ruc;
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

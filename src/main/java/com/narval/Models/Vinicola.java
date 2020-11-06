package com.narval.Models;

import java.security.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class Vinicola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy="vinicola")
    private Set<Servicio> servicio;

    @Column(name="nombre", length=50, nullable=false, unique=false)
    private String nombre;

    @Column(name="direccion", length=50, nullable=false, unique=false)
    private String direccion;

    @Column(name="codigoPost", length=10, nullable=false, unique=false)
    private int codigoPost;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoPost() {
        return this.codigoPost;
    }

    public void setCodigoPost(int codigoPost) {
        this.codigoPost = codigoPost;
    }
//fin
    
}

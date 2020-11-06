package com.narval.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PuntoTuristico", schema = "wineplan")
public class PuntoTuristico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nombre", length = 50, nullable = false)
    private String nombre;
    
    @Column(name="direccion", length = 100, nullable = false)
    private String direccion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Vinicola_idVinicola", referencedColumnName = "id")
    private Vinicola vinicola;

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

    public Vinicola getVinicola() {
        return this.vinicola;
    }

    public void setVinicola(Vinicola vinicola) {
        this.vinicola = vinicola;
    }

}

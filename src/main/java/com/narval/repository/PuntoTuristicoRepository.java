package com.narval.repository;

import java.util.List;

import com.narval.Models.PuntoTuristico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PuntoTuristicoRepository extends JpaRepository<PuntoTuristico, Long>{
    @Query("Select pt from Punto_Turistico pt where nombre = ?1")
    List<PuntoTuristico> findByName(String name);

    @Query("Select pt from Punto_Turistico pt")
    List<PuntoTuristico> findAll();
}

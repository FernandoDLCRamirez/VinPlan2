package com.narval.repository;

import java.util.List;

import com.narval.Models.PuntoTuristico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PuntoTuristicoRepository extends JpaRepository<PuntoTuristico, Long>{
    @Query("Select * from Punto_Turistico where nombre = ?1")
    List<PuntoTuristico> findByName(String name);

    @Query("Select * from Punto_Turistico")
    List<PuntoTuristico> findAll();
}

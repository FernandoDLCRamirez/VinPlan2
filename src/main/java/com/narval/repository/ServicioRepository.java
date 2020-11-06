package com.narval.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.narval.Models.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Long>{
    @Query("select * from servicio where name = ?1 join usuario")
    List<Servicio> findByName(String name);
    
    @Query("select * from servicio")
    List<Servicio> findAll();
}
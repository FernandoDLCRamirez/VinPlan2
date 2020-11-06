package com.narval.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.narval.Models.ReservacionEspecifica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservacionEspecificaRepository extends JpaRepository<ReservacionEspecifica, Long> {
    @Query("select rs from reservacionespecifica rs where id= ?1")
    List<ReservacionEspecifica> findById(int id);
    
    @Query("select rs from reservacionespecifica rs")
    List<ReservacionEspecifica> findAll();
}

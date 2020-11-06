package com.narval.repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservacionGeneral extends JpaRepository<ReservacionGeneral, Long>{
    @Autowired

    @Query("select * from ReservacionGeneral where id= ?1")
    List<ReservacionGeneral> findById(int id);
    
    @Query("select * from ReservacionGeneral")
    List<ReservacionGeneral> findAll();
}

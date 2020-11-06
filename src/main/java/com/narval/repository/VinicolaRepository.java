package com.narval.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.narval.Models.Vinicola;

@Repository
public class VinicolaRepository {
    @Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Optional<Vinicola> findByName(String nombre) {
		String query = "SELECT * FROM vinicola WHERE nombre = ?";
				
        return jdbcTemplate.queryForObject(query, new Object[]{nombre},
            (rs, rowNum) -> {
                Vinicola vinicola = new Vinicola();

                vinicola.setId(rs.getInt("id"));
                vinicola.setNombre(rs.getString("nombre"));
                vinicola.setDireccion(rs.getString("direccion"));
                vinicola.setCodigoPost(rs.getInt("codigoPost"));

                return Optional.of(vinicola);
            }
        );
	}
	

	public List<Vinicola> findAll() {
		
		List<Vinicola> vinicolas = new ArrayList<Vinicola>();
						
		String query = "SELECT * FROM Vinicola";
		
		jdbcTemplate.query(query, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Vinicola vinicola = new Vinicola();
				vinicola.setId(rs.getInt("id"));
				vinicola.setNombre(rs.getString("nombre"));
                vinicola.setDireccion(rs.getString("direccion"));
                vinicola.setCodigoPost(rs.getInt("codigoPost"));
						
		        vinicolas.add(vinicola);
			}
		});
		
		
		return vinicolas;
    }
    
    public int save(Vinicola vinicola) {
    	
    	String query = "INSERT INTO Vinicola (nombre, direccion, direccion, codigoPost) VALUES (?,?,?,?)";
    	
        return jdbcTemplate.update(query, vinicola.getId(), vinicola.getNombre());
    }
    
}

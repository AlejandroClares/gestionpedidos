package com.pgrsoft.gestionpedidos.backend.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pgrsoft.gestionpedidos.backend.business.model.Camarero;

public class CamareroRowMapper implements RowMapper<Camarero> {

	@Override
	public Camarero mapRow(ResultSet rs, int rowNum) throws SQLException {
		Camarero camarero = new Camarero();
		camarero.setId((long)rs.getInt("id"));
		camarero.setNombre(rs.getString("nombre"));
		return camarero;
	}

}

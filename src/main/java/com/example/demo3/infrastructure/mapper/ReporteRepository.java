package com.example.demo3.infrastructure.mapper;

import com.example.demo3.application.DTO.ParametrosDTO;
import com.example.demo3.application.DTO.ReporteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class ReporteRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    List<ReporteDTO> listar(ParametrosDTO caso) {

        boolean insertoPrimero = false;
        StringBuilder sql = new StringBuilder();
        sql.append("select l. from libro l where ");

        if (caso.getNombre() != null) {
            if (insertoPrimero) {
                sql.append(" and ");
            }
            insertoPrimero = true;
            sql.append(" like '%" + caso.getNombre() + "%'");
        }

        if (caso.getAutor() != null) {
            if (insertoPrimero) {
                sql.append(" and ");
            }
            insertoPrimero = true;
            sql.append(" = " + caso.getAutor());
        }

        if (caso.getCategoria() != null) {
            if (insertoPrimero) {
                sql.append(" and ");
            }
            insertoPrimero = true;
            sql.append(" = " + caso.getCategoria());
        }

        if (caso.getFechaInicio() != null && caso.getFechaFin() != null) {
            if (insertoPrimero) {
                sql.append(" and ");
            }
            insertoPrimero = true;
            sql.append(" BETWEEN '" + caso.getFechaInicio() + "' and '" + caso.getFechaFin() + "'");
        }

        sql.append(" ORDER BY  ");

        return (List<ReporteDTO>) jdbcTemplate.query(sql.toString(), new ReportesMapper());
    }

    private static final class ReportesMapper implements RowMapper<ReporteDTO> {

        @Override
        public ReporteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

            ReporteDTO t = new ReporteDTO();
            t.setId(rs.getInt(""));
            t.setNombre(rs.getString(""));
            t.setAutor(rs.getString(""));
            t.setCategoria(rs.getString(""));
            t.setEditorial(rs.getString(""));
            t.setPaginas(rs.getInt(""));
            t.setFecha(rs.getDate("").toLocalDate());
            t.setDescripcion(rs.getString(""));

            return t;
        }
    }


}

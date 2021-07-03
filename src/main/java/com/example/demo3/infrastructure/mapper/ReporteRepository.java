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

    public List<ReporteDTO> listar(ParametrosDTO caso) {

        boolean insertoPrimero = false;
        StringBuilder sql = new StringBuilder();
        sql.append("select l.nombre, l.libro_id, l.descripcion, l.paginas, l.fecha, a.nombre as autor, c.nombre as categoria, e.nombre as editorial " +
                "from libro l left join autor a on l.autor_id = a.autor_id left join categoria c on c.categoria_id = l.categoria_id " +
                "left join editorial e on e.editorial_id = l.editorial_id ");

        if (caso.getNombre() != null) {
            if (insertoPrimero) {
                sql.append(" and ");
            }else{
                sql.append(" where ");
            }
            insertoPrimero = true;
            sql.append("l.nombre like '%" + caso.getNombre() + "%'");
        }

        if (caso.getAutor() != null) {
            if (insertoPrimero) {
                sql.append(" and ");
            }else{
                sql.append(" where ");
            }
            insertoPrimero = true;
            sql.append("a.nombre = " + caso.getAutor());
        }

        if (caso.getCategoria() != null) {
            if (insertoPrimero) {
                sql.append(" and ");
            }else{
                sql.append(" where ");
            }
            insertoPrimero = true;
            sql.append("c.categoria_id = " + caso.getCategoria());
        }

        if (caso.getFechaInicio() != null && caso.getFechaFin() != null) {
            if (insertoPrimero) {
                sql.append(" and ");
            }else{
                sql.append(" where ");
            }
            insertoPrimero = true;
            sql.append("l.fecha BETWEEN '" + caso.getFechaInicio() + "' and '" + caso.getFechaFin() + "'");
        }

        sql.append(" ORDER BY  l.libro_id");

        return (List<ReporteDTO>) jdbcTemplate.query(sql.toString(), new ReportesMapper());
    }

    private static final class ReportesMapper implements RowMapper<ReporteDTO> {

        @Override
        public ReporteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

            ReporteDTO t = new ReporteDTO();
            t.setId(rs.getInt("libro_id"));
            t.setNombre(rs.getString("nombre"));
            t.setAutor(rs.getString("autor"));
            t.setCategoria(rs.getString("categoria"));
            t.setEditorial(rs.getString("editorial"));
            t.setPaginas(rs.getString("paginas"));
            if(rs.getDate("fecha") != null){
                t.setFecha(rs.getDate("fecha").toLocalDate());
            }
            t.setDescripcion(rs.getString("descripcion"));

            return t;
        }
    }


}

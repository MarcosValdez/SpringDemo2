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
        sql.append("select v.venta_id, co.nombre, co.apellido, l.nombre as libro, a.nombre as autor, c.nombre as categoria, " +
                " e.nombre as editorial, v.fecha, co.dni, l.descripcion, l.paginas, l.anio, l.precio, from ventas v " +
                " left join libro l on v.libro_id = l.libro_id left join autor a on l.autor_id = a.autor_id " +
                " left join categoria c on l.categoria_id = c.categoria_id left join editorial e on l.editorial_id = e.editorial_id " +
                " left join comprador co on v.comprador_id = co.comprador_id ");

        if (caso.getNombre() != null && caso.getNombre().length() > 0) {

            sql.append(" where ");

            sql.append(" l.nombre like '%" + caso.getNombre() + "%' ");
        }

        if (caso.getAutor() != null && caso.getAutor().length() > 0) {
            if (insertoPrimero) {
                sql.append(" and ");
            } else {
                sql.append(" where ");
            }
            insertoPrimero = true;
            sql.append(" a.nombre like '%" + caso.getAutor() + "%' ");
        }

        if (caso.getCategoria() != null) {
            if (insertoPrimero) {
                sql.append(" and ");
            } else {
                sql.append(" where ");
            }
            insertoPrimero = true;
            sql.append(" c.categoria_id = " + caso.getCategoria());
        }

        if (caso.getFechaInicio() != null && caso.getFechaFin() != null) {
            if (insertoPrimero) {
                sql.append(" and ");
            } else {
                sql.append(" where ");
            }
            sql.append(" v.fecha BETWEEN '" + caso.getFechaInicio() + "' and '" + caso.getFechaFin() + "' ");
        }

        sql.append(" ORDER BY l.libro_id");
        System.out.println(sql.toString());

        return jdbcTemplate.query(sql.toString(), new ReportesMapper());
    }

    private static final class ReportesMapper implements RowMapper<ReporteDTO> {

        @Override
        public ReporteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

            ReporteDTO t = new ReporteDTO();
            t.setId(rs.getInt("venta_id"));
            t.setComprador(rs.getString("nombre") + " " + rs.getString("apellido"));
            t.setNombrelibro(rs.getString("libro"));
            t.setAutor(rs.getString("autor"));
            t.setCategoria(rs.getString("categoria"));
            t.setEditorial(rs.getString("editorial"));
            t.setDni(rs.getString("dni"));
            t.setDescripcion(rs.getString("descripcion"));
            t.setPaginas(rs.getInt("paginas"));
            t.setAnio(rs.getInt("anio"));
            t.setPrecio(rs.getString("precio"));
            /*if (rs.getDate("fecha") != null) {
                t.setFecha(rs.getDate("fecha").toLocalDate());
            }*/

            return t;
        }
    }


}

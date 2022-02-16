package com.ceiba.pagos.administracion.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pagos.administracion.modelo.dto.DtoTotalPagadoPagosAdministracion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoTotalPagadoPagosAdministracion implements RowMapper<DtoTotalPagadoPagosAdministracion>, MapperResult {

    @Override
    public DtoTotalPagadoPagosAdministracion mapRow(ResultSet rs, int rowNum) throws SQLException {

        String codigoInmueble = rs.getString("codigo_inmueble");
        Integer totalPagado = rs.getInt("total");

        return new DtoTotalPagadoPagosAdministracion(codigoInmueble, totalPagado);
    }
}

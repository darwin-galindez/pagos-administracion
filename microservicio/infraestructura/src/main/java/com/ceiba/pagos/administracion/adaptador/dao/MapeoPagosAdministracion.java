package com.ceiba.pagos.administracion.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pagos.administracion.modelo.dto.DtoPagosAdministracion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoPagosAdministracion implements RowMapper<DtoPagosAdministracion>, MapperResult {

    @Override
    public DtoPagosAdministracion mapRow(ResultSet resultSet, int numRow) throws SQLException {

        Long id = resultSet.getLong("id");
        String codigoInmueble = resultSet.getString("codigo_inmueble");
        Integer numeroIdentificacionPersona = resultSet.getInt("numero_identificacion_persona");
        Integer valorPagado = resultSet.getInt("valor_pagado");
        Integer porcentajeInteres = resultSet.getInt("porcentaje_interes");
        Integer valorPagadoInteres = resultSet.getInt("valor_pagado_interes");
        Boolean pagoTotal = resultSet.getBoolean("pago_total");
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new DtoPagosAdministracion(
                id,
                codigoInmueble,
                numeroIdentificacionPersona,
                valorPagado,
                porcentajeInteres,
                valorPagadoInteres,
                pagoTotal,
                fechaCreacion
        );
    }
}

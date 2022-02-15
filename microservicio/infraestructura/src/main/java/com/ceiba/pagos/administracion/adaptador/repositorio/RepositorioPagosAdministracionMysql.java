package com.ceiba.pagos.administracion.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pagos.administracion.modelo.entidad.PagosAdministracion;
import com.ceiba.pagos.administracion.puerto.repositorio.RepositorioPagosAdministracion;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPagosAdministracionMysql implements RepositorioPagosAdministracion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioPagosAdministracionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace="pagos-administracion", value="crear")
    private static String sqlCrear;

    @Override
    public Long crear(PagosAdministracion pagosAdministracion) {
        return this.customNamedParameterJdbcTemplate.crear(pagosAdministracion, sqlCrear);
    }
}

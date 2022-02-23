package com.ceiba.pagos.administracion.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pagos.administracion.adaptador.dao.MapeoTotalPagadoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoConsultarSaldoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoTotalPagadoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.entidad.PagosAdministracion;
import com.ceiba.pagos.administracion.puerto.repositorio.RepositorioPagosAdministracion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPagosAdministracionMysql implements RepositorioPagosAdministracion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioPagosAdministracionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace="pagosadministracion", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="pagosadministracion", value="totalpagado")
    private static String sqlTotalPagado;

    @Override
    public Long crear(PagosAdministracion pagosAdministracion) {
        return this.customNamedParameterJdbcTemplate.crear(pagosAdministracion, sqlCrear);
    }

    @Override
    public DtoTotalPagadoPagosAdministracion consultarTotalPagado(DtoConsultarSaldoPagosAdministracion dtoConsultarSaldoPagosAdministracion) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("codigoInmueble", dtoConsultarSaldoPagosAdministracion.getCodigoInmueble());
        paramSource.addValue("mes", dtoConsultarSaldoPagosAdministracion.getMes());

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlTotalPagado, paramSource, new MapeoTotalPagadoPagosAdministracion());
    }
}

package com.ceiba.pagos.administracion.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pagos.administracion.modelo.dto.DtoPagosAdministracion;
import com.ceiba.pagos.administracion.puerto.dao.DaoPagosAdministracion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPagosAdministracionMysql implements DaoPagosAdministracion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "pagosadministracion", value = "listar")
    private static String sqlListar;

    public DaoPagosAdministracionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPagosAdministracion> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPagosAdministracion());
    }
}

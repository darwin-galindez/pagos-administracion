package com.ceiba.pagos.administracion.puerto.dao;

import com.ceiba.pagos.administracion.modelo.dto.DtoPagosAdministracion;

import java.util.List;

public interface DaoPagosAdministracion {

    /**
     * Permite listar los pagos de administracion realizados
     * @return los pagos
     */
    List<DtoPagosAdministracion> listar();
}

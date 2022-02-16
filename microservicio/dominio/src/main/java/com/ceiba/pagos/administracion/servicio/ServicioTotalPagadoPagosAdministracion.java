package com.ceiba.pagos.administracion.servicio;

import com.ceiba.pagos.administracion.modelo.dto.DtoConsultarSaldoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoTotalPagadoPagosAdministracion;
import com.ceiba.pagos.administracion.puerto.repositorio.RepositorioPagosAdministracion;

public class ServicioTotalPagadoPagosAdministracion {

    private final RepositorioPagosAdministracion repositorioPagosAdministracion;

    public ServicioTotalPagadoPagosAdministracion(RepositorioPagosAdministracion repositorioPagosAdministracion) {
        this.repositorioPagosAdministracion = repositorioPagosAdministracion;
    }

    public DtoTotalPagadoPagosAdministracion ejecutar(DtoConsultarSaldoPagosAdministracion consultarSaldoPagosAdministracion) {
        return this.repositorioPagosAdministracion.consultarTotalPagado(consultarSaldoPagosAdministracion);
    }
}

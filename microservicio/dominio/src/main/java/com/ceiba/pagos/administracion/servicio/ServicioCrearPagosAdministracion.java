package com.ceiba.pagos.administracion.servicio;

import com.ceiba.pagos.administracion.modelo.entidad.PagosAdministracion;
import com.ceiba.pagos.administracion.puerto.repositorio.RepositorioPagosAdministracion;

public class ServicioCrearPagosAdministracion {

    private final RepositorioPagosAdministracion repositorioPagosAdministracion;

    public ServicioCrearPagosAdministracion(RepositorioPagosAdministracion repositorioPagosAdministracion) {
        this.repositorioPagosAdministracion = repositorioPagosAdministracion;
    }

    public Long ejecutar(PagosAdministracion pagosAdministracion) {
        return this.repositorioPagosAdministracion.crear(pagosAdministracion);
    }
}

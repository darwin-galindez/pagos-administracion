package com.ceiba.pagos.administracion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pagos.administracion.modelo.entidad.PagosAdministracion;
import com.ceiba.pagos.administracion.puerto.repositorio.RepositorioPagosAdministracion;
import com.ceiba.usuario.modelo.entidad.Usuario;

public class ServicioCrearPagosAdministracion {

    private static final String EL_PAGO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

    private final RepositorioPagosAdministracion repositorioPagosAdministracion;

    public ServicioCrearPagosAdministracion(RepositorioPagosAdministracion repositorioPagosAdministracion) {
        this.repositorioPagosAdministracion = repositorioPagosAdministracion;
    }

    public Long ejecutar(PagosAdministracion pagosAdministracion) {
        return this.repositorioPagosAdministracion.crear(pagosAdministracion);
    }
}

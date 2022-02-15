package com.ceiba.pagos.administracion.comando.fabrica;

import com.ceiba.pagos.administracion.comando.ComandoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.entidad.PagosAdministracion;

public class FabricaPagosAdministracion {

    public PagosAdministracion crear(ComandoPagosAdministracion comandoPagosAdministracion) {

        return new PagosAdministracion(
                comandoPagosAdministracion.getId(),
                comandoPagosAdministracion.getCodigoInmueble(),
                comandoPagosAdministracion.getNumeroIdentificacionPersona(),
                comandoPagosAdministracion.getValorPagado(),
                comandoPagosAdministracion.getPorcentajeInteres(),
                comandoPagosAdministracion.getValorPagadoInteres(),
                comandoPagosAdministracion.getPagoTotal(),
                comandoPagosAdministracion.getFechaCreacion()
        );
    }
}

package com.ceiba.pagos.administracion.servicio;

import com.ceiba.pagos.administracion.modelo.dto.DtoConsultarSaldoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoSaldoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoTotalPagadoPagosAdministracion;
import com.ceiba.pagos.administracion.puerto.repositorio.RepositorioPagosAdministracion;

import java.util.logging.Logger;

public class ServicioTotalPagadoPagosAdministracion {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private static final Integer VALOR_ADMINISTRACION = 300000;
    private final RepositorioPagosAdministracion repositorioPagosAdministracion;

    public ServicioTotalPagadoPagosAdministracion(RepositorioPagosAdministracion repositorioPagosAdministracion) {
        this.repositorioPagosAdministracion = repositorioPagosAdministracion;
    }

    public DtoSaldoPagosAdministracion ejecutar(DtoConsultarSaldoPagosAdministracion consultarSaldoPagosAdministracion) {

        int totalPagado = 0;

        try {

            DtoTotalPagadoPagosAdministracion totalPagadoPagosAdministracion = this.repositorioPagosAdministracion.consultarTotalPagado(consultarSaldoPagosAdministracion);
            totalPagado = totalPagadoPagosAdministracion.getTotalPagado();

        } catch (Exception exception) {
            logger.warning(exception.toString());
        }

        int saldo = VALOR_ADMINISTRACION - totalPagado;

        return new DtoSaldoPagosAdministracion(consultarSaldoPagosAdministracion.getCodigoInmueble(), saldo);
    }
}

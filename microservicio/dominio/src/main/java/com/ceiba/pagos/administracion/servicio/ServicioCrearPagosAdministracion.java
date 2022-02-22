package com.ceiba.pagos.administracion.servicio;

import com.ceiba.pagos.administracion.modelo.dto.DtoConsultarSaldoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoTotalPagadoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.entidad.PagosAdministracion;
import com.ceiba.pagos.administracion.puerto.repositorio.RepositorioPagosAdministracion;

import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

public class ServicioCrearPagosAdministracion {

    private static final String NO_PUEDE_EXCEDER_VALOR_MAXIMO_MENSUAL = "No puede pagar mas de 300.000 de administración al mes. Su saldo actual es: ";

    private final RepositorioPagosAdministracion repositorioPagosAdministracion;

    public ServicioCrearPagosAdministracion(RepositorioPagosAdministracion repositorioPagosAdministracion) {
        this.repositorioPagosAdministracion = repositorioPagosAdministracion;
    }

    public Long ejecutar(PagosAdministracion pagosAdministracion) {
        validarPagoMaximoPorMes(pagosAdministracion);
        return this.repositorioPagosAdministracion.crear(pagosAdministracion);
    }

    public void validarPagoMaximoPorMes(PagosAdministracion pagosAdministracion) {
        Integer mes = 2;

        DtoTotalPagadoPagosAdministracion totalPagadoPagosAdministracion;

        try {
            totalPagadoPagosAdministracion = this.repositorioPagosAdministracion.consultarTotalPagado(new DtoConsultarSaldoPagosAdministracion(pagosAdministracion.getCodigoInmueble(), mes));
        } catch (Exception exception) {
            totalPagadoPagosAdministracion = null;
        }

        int saldo = (totalPagadoPagosAdministracion == null) ? 300000 : 300000 - totalPagadoPagosAdministracion.getTotalPagado();
        boolean valorValido = pagosAdministracion.getValorPagado() <= saldo;

        validarPositivo(valorValido, NO_PUEDE_EXCEDER_VALOR_MAXIMO_MENSUAL + saldo);
    }
}

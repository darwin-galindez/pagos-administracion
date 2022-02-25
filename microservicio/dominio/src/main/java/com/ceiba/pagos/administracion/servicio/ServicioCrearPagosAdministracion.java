package com.ceiba.pagos.administracion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.pagos.administracion.modelo.dto.DtoConsultarSaldoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoTotalPagadoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.entidad.PagosAdministracion;
import com.ceiba.pagos.administracion.puerto.repositorio.RepositorioPagosAdministracion;

public class ServicioCrearPagosAdministracion {

    private static final Integer VALOR_ADMINISTRACION = 300000;
    private static final String NO_PUEDE_EXCEDER_VALOR_MAXIMO_MENSUAL = "No puede pagar mas de 300.000 de administración al mes.";

    private final RepositorioPagosAdministracion repositorioPagosAdministracion;

    public ServicioCrearPagosAdministracion(RepositorioPagosAdministracion repositorioPagosAdministracion) {
        this.repositorioPagosAdministracion = repositorioPagosAdministracion;
    }

    public Long ejecutar(PagosAdministracion pagosAdministracion) {
        validarPagoMaximoPorMes(pagosAdministracion);
        return this.repositorioPagosAdministracion.crear(pagosAdministracion);
    }

    private void validarPagoMaximoPorMes(PagosAdministracion pagosAdministracion) {

        int mes = pagosAdministracion.getFechaCreacion().getMonthValue();
        DtoTotalPagadoPagosAdministracion totalPagadoPagosAdministracion = consultarTotalPagado(pagosAdministracion, mes);

        int saldo = VALOR_ADMINISTRACION - totalPagadoPagosAdministracion.getTotalPagado();
        boolean valorValido = pagosAdministracion.getValorPagado() <= saldo;

        if (Boolean.FALSE.equals(valorValido)) {
            throw new ExcepcionValorInvalido(NO_PUEDE_EXCEDER_VALOR_MAXIMO_MENSUAL);
        }
    }

    public DtoTotalPagadoPagosAdministracion consultarTotalPagado(PagosAdministracion pagosAdministracion ,Integer mes) {

        DtoConsultarSaldoPagosAdministracion dtoConsultarSaldoPagosAdministracion = new DtoConsultarSaldoPagosAdministracion(pagosAdministracion.getCodigoInmueble(), mes);

        if (this.repositorioPagosAdministracion.existePorCodigoMes(dtoConsultarSaldoPagosAdministracion)) {
            return this.repositorioPagosAdministracion.consultarTotalPagado(dtoConsultarSaldoPagosAdministracion);
        }

        return new DtoTotalPagadoPagosAdministracion(pagosAdministracion.getCodigoInmueble(), 0);
    }
}

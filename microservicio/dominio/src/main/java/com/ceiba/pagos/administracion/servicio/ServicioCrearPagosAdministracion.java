package com.ceiba.pagos.administracion.servicio;

import com.ceiba.pagos.administracion.modelo.dto.DtoConsultarSaldoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoTotalPagadoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.entidad.PagosAdministracion;
import com.ceiba.pagos.administracion.puerto.repositorio.RepositorioPagosAdministracion;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

public class ServicioCrearPagosAdministracion {

    private static final Integer VALOR_ADMINISTRACION = 300000;
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

        int mes = pagosAdministracion.getFechaCreacion().getMonthValue();
        int saldo = VALOR_ADMINISTRACION;

        DtoTotalPagadoPagosAdministracion totalPagadoPagosAdministracion = consultarTotalPagado(pagosAdministracion, mes);

        if (totalPagadoPagosAdministracion != null) {
            saldo = VALOR_ADMINISTRACION - totalPagadoPagosAdministracion.getTotalPagado();
        }

        boolean valorValido = pagosAdministracion.getValorPagado() <= saldo;
        validarPositivo(valorValido, NO_PUEDE_EXCEDER_VALOR_MAXIMO_MENSUAL + saldo);
    }

    public DtoTotalPagadoPagosAdministracion consultarTotalPagado(PagosAdministracion pagosAdministracion ,Integer mes) {

        DtoTotalPagadoPagosAdministracion totalPagadoPagosAdministracion;

        try {
            DtoConsultarSaldoPagosAdministracion dtoConsultarSaldoPagosAdministracion = new DtoConsultarSaldoPagosAdministracion(pagosAdministracion.getCodigoInmueble(), mes);
            totalPagadoPagosAdministracion = this.repositorioPagosAdministracion.consultarTotalPagado(dtoConsultarSaldoPagosAdministracion);
        } catch (Exception e) {
            totalPagadoPagosAdministracion = null;
        }

        return totalPagadoPagosAdministracion;
    }
}

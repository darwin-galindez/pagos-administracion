package com.ceiba.pagos.administracion.servicio.testdatabuilder;

import com.ceiba.pagos.administracion.modelo.entidad.PagosAdministracion;

import java.time.LocalDateTime;

public class PagosAdministracionTestDataBuilder {

    private Long id;
    private String codigoInmueble;
    private Integer numeroIdentificacionPersona;
    private Integer valorPagado;
    private Integer porcentajeInteres;
    private Integer valorPagadoInteres;
    private Boolean pagoTotal;
    private LocalDateTime fechaCreacion;

    public PagosAdministracionTestDataBuilder() {
        codigoInmueble = "AQ17";
        numeroIdentificacionPersona = 123456;
        valorPagado = 300000;
        porcentajeInteres = 0;
        valorPagadoInteres = 0;
        pagoTotal = true;
        fechaCreacion = LocalDateTime.now();
    }

    public PagosAdministracionTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public PagosAdministracionTestDataBuilder conCodigoInmueble(String codigoInmueble) {
        this.codigoInmueble = codigoInmueble;
        return this;
    }

    public PagosAdministracionTestDataBuilder conNumeroIdentificacionPersona(Integer numeroIdentificacionPersona) {
        this.numeroIdentificacionPersona = numeroIdentificacionPersona;
        return this;
    }

    public PagosAdministracionTestDataBuilder conValorPagado(Integer valorPagado) {
        this.valorPagado = valorPagado;
        return this;
    }

    public PagosAdministracionTestDataBuilder conPorcentajeInteres(Integer porcentajeInteres) {
        this.porcentajeInteres = porcentajeInteres;
        return this;
    }

    public PagosAdministracionTestDataBuilder conValorPagadoInteres(Integer valorPagadoInteres) {
        this.valorPagadoInteres = valorPagadoInteres;
        return this;
    }

    public PagosAdministracionTestDataBuilder conPagoTotal(Boolean pagoTotal) {
        this.pagoTotal = pagoTotal;
        return this;
    }

    public PagosAdministracionTestDataBuilder conFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public PagosAdministracion build() {
        return new PagosAdministracion (
                id,
                codigoInmueble,
                numeroIdentificacionPersona,
                valorPagado,
                porcentajeInteres,
                valorPagadoInteres,
                pagoTotal,
                fechaCreacion
        );
    }
}

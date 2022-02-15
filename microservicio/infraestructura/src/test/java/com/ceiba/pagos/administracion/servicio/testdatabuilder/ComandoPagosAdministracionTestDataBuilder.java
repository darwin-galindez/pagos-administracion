package com.ceiba.pagos.administracion.servicio.testdatabuilder;

import com.ceiba.pagos.administracion.comando.ComandoPagosAdministracion;

import java.time.LocalDateTime;

public class ComandoPagosAdministracionTestDataBuilder {

    private Long id;
    private String codigoInmueble;
    private Integer numeroIdentificacionPersona;
    private Integer valorPagado;
    private Integer porcentajeInteres;
    private Integer valorPagadoInteres;
    private Boolean pagoTotal;
    private LocalDateTime fechaCreacion;

    public ComandoPagosAdministracionTestDataBuilder() {

        codigoInmueble = "QA16";
        numeroIdentificacionPersona = 1234567890;
        valorPagado = 300000;
        porcentajeInteres = 0;
        valorPagadoInteres = 0;
        pagoTotal = true;
        fechaCreacion = LocalDateTime.now();
    }

    public ComandoPagosAdministracionTestDataBuilder conCodigoInmueble(String codigoInmueble) {
        this.codigoInmueble = codigoInmueble;
        return this;
    }

    public ComandoPagosAdministracion build() {

        return new ComandoPagosAdministracion(
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

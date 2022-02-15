package com.ceiba.pagos.administracion.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class PagosAdministracion {

    private static final String SE_DEBE_INGRESAR_CODIGO_INMUEBLE = "Se debe ingresar el código del inmueble";
    private static final String SE_DEBE_INGRESAR_NUMERO_IDENTIFICACION_PERSONA = "Se debe ingresar el número de identificación de la persona";
    private static final String SE_DEBE_INGRESAR_VALOR_PAGADO = "Se debe ingresar el valor a pagar";

    private Long id;
    private String codigoInmueble;
    private Integer numeroIdentificacionPersona;
    private Integer valorPagado;
    private Integer porcentajeInteres;
    private Integer valorPagadoInteres;
    private Boolean pagoTotal;
    private LocalDateTime fechaCreacion;

    public PagosAdministracion(
            Long id,
            String codigoInmueble,
            Integer numeroIdentificacionPersona,
            Integer valorPagado,
            Integer porcentajeInteres,
            Integer valorPagadoInteres,
            Boolean pagoTotal,
            LocalDateTime fechaCreacion
    ) {

        validarObligatorio(codigoInmueble, SE_DEBE_INGRESAR_CODIGO_INMUEBLE);
        validarObligatorio(numeroIdentificacionPersona, SE_DEBE_INGRESAR_NUMERO_IDENTIFICACION_PERSONA);
        validarObligatorio(valorPagado, SE_DEBE_INGRESAR_VALOR_PAGADO);

        this.id = id;
        this.codigoInmueble = codigoInmueble;
        this.numeroIdentificacionPersona = numeroIdentificacionPersona;
        this.valorPagado = valorPagado;
        this.porcentajeInteres = porcentajeInteres;
        this.valorPagadoInteres = valorPagadoInteres;
        this.pagoTotal = pagoTotal;
        this.fechaCreacion = fechaCreacion;
    }
}

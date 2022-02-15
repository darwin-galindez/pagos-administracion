package com.ceiba.pagos.administracion.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoPagosAdministracion {

    private Long id;
    private String codigoInmueble;
    private Integer numeroIdentificacionPersona;
    private Integer valorPagado;
    private Integer porcentajeInteres;
    private Integer valorPagadoInteres;
    private Boolean pagoTotal;
    private LocalDateTime fechaCreacion;
}

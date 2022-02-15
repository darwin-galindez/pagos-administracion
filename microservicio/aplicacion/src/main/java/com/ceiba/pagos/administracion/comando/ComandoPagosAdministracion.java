package com.ceiba.pagos.administracion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPagosAdministracion {

    private Long id;
    private String codigoInmueble;
    private Integer numeroIdentificacionPersona;
    private Integer valorPagado;
    private Integer porcentajeInteres;
    private Integer valorPagadoInteres;
    private Boolean pagoTotal;
    private LocalDateTime fechaCreacion;
}

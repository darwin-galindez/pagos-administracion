package com.ceiba.pagos.administracion.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoTotalPagadoPagosAdministracion {

    private String codigoInmueble;
    private Integer totalPagado;
}

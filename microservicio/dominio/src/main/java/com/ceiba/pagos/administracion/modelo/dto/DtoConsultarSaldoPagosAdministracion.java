package com.ceiba.pagos.administracion.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoConsultarSaldoPagosAdministracion {

    private String codigoInmueble;
    private Integer mes;
}

package com.ceiba.pagos.administracion.servicio.testdatabuilder;

import com.ceiba.pagos.administracion.modelo.dto.DtoConsultarSaldoPagosAdministracion;

public class ConsultarEstadoPagosAdministracionTestDataBuilder {

    private String codigoInmueble;
    private Integer mes;

    public ConsultarEstadoPagosAdministracionTestDataBuilder() {
        codigoInmueble = "AQ18";
        mes = 2;
    }

    public ConsultarEstadoPagosAdministracionTestDataBuilder conCodigoInmueble(String codigoInmueble) {
        this.codigoInmueble = codigoInmueble;
        return this;
    }

    public ConsultarEstadoPagosAdministracionTestDataBuilder conMes(Integer mes) {
        this.mes = mes;
        return this;
    }

    public DtoConsultarSaldoPagosAdministracion build() {
        return new DtoConsultarSaldoPagosAdministracion(codigoInmueble, mes);
    }
}

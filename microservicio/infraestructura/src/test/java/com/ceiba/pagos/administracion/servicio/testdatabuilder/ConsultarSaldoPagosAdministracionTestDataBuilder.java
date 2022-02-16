package com.ceiba.pagos.administracion.servicio.testdatabuilder;

import com.ceiba.pagos.administracion.comando.ComandoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoConsultarSaldoPagosAdministracion;

public class ConsultarSaldoPagosAdministracionTestDataBuilder {

    private String codigoInmueble;
    private Integer mes;

    public ConsultarSaldoPagosAdministracionTestDataBuilder() {
        codigoInmueble = "QA18";
        mes = 2;
    }

    public ConsultarSaldoPagosAdministracionTestDataBuilder conCodigoInmueble(String codigoInmueble) {
        this.codigoInmueble = codigoInmueble;
        return this;
    }

    public ConsultarSaldoPagosAdministracionTestDataBuilder conMes(Integer mes) {
        this.mes = mes;
        return this;
    }

    public DtoConsultarSaldoPagosAdministracion build() {

        return new DtoConsultarSaldoPagosAdministracion(
                codigoInmueble,
                mes
        );
    }
}

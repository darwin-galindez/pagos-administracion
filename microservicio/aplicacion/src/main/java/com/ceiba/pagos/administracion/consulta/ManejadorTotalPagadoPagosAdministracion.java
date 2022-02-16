package com.ceiba.pagos.administracion.consulta;

import com.ceiba.pagos.administracion.modelo.dto.DtoConsultarSaldoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoTotalPagadoPagosAdministracion;
import com.ceiba.pagos.administracion.servicio.ServicioTotalPagadoPagosAdministracion;
import org.springframework.stereotype.Component;

@Component
public class ManejadorTotalPagadoPagosAdministracion {

    private final ServicioTotalPagadoPagosAdministracion servicioTotalPagadoPagosAdministracion;

    public ManejadorTotalPagadoPagosAdministracion(ServicioTotalPagadoPagosAdministracion servicioTotalPagadoPagosAdministracion) {
        this.servicioTotalPagadoPagosAdministracion = servicioTotalPagadoPagosAdministracion;
    }

    public DtoTotalPagadoPagosAdministracion ejecutar(DtoConsultarSaldoPagosAdministracion consultarSaldoPagosAdministracion) {
        return this.servicioTotalPagadoPagosAdministracion.ejecutar(consultarSaldoPagosAdministracion);
    }
}

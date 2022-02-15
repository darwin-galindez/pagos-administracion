package com.ceiba.pagos.administracion.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pagos.administracion.comando.ComandoPagosAdministracion;
import com.ceiba.pagos.administracion.comando.fabrica.FabricaPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.entidad.PagosAdministracion;
import com.ceiba.pagos.administracion.servicio.ServicioCrearPagosAdministracion;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPagosAdministracion implements ManejadorComandoRespuesta<ComandoPagosAdministracion, ComandoRespuesta<Long>> {

    private final FabricaPagosAdministracion fabricaPagosAdministracion;
    private final ServicioCrearPagosAdministracion servicioCrearPagosAdministracion;

    public ManejadorCrearPagosAdministracion(FabricaPagosAdministracion fabricaPagosAdministracion, ServicioCrearPagosAdministracion servicioCrearPagosAdministracion) {
        this.fabricaPagosAdministracion = fabricaPagosAdministracion;
        this.servicioCrearPagosAdministracion = servicioCrearPagosAdministracion;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoPagosAdministracion comandoPagosAdministracion) {

        PagosAdministracion pagosAdministracion = this.fabricaPagosAdministracion.crear(comandoPagosAdministracion);

        return new ComandoRespuesta<>(this.servicioCrearPagosAdministracion.ejecutar(pagosAdministracion));
    }
}

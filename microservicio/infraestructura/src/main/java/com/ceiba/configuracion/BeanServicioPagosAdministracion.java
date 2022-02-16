package com.ceiba.configuracion;

import com.ceiba.pagos.administracion.puerto.repositorio.RepositorioPagosAdministracion;
import com.ceiba.pagos.administracion.servicio.ServicioCrearPagosAdministracion;
import com.ceiba.pagos.administracion.servicio.ServicioTotalPagadoPagosAdministracion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioPagosAdministracion {

    @Bean
    public ServicioCrearPagosAdministracion servicioCrearPagosAdministracion(RepositorioPagosAdministracion repositorioPagosAdministracion) {
        return new ServicioCrearPagosAdministracion(repositorioPagosAdministracion);
    }

    @Bean
    public ServicioTotalPagadoPagosAdministracion servicioTotalPagadoPagosAdministracion(RepositorioPagosAdministracion repositorioPagosAdministracion) {
        return new ServicioTotalPagadoPagosAdministracion(repositorioPagosAdministracion);
    }
}

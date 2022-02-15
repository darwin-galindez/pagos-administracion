package com.ceiba.configuracion;

import com.ceiba.pagos.administracion.puerto.repositorio.RepositorioPagosAdministracion;
import com.ceiba.pagos.administracion.servicio.ServicioCrearPagosAdministracion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioPagosAdministracion {

    @Bean
    public ServicioCrearPagosAdministracion servicioCrearPagosAdministracion(RepositorioPagosAdministracion repositorioPagosAdministracion) {
        return new ServicioCrearPagosAdministracion(repositorioPagosAdministracion);
    }
}

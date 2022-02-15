package com.ceiba.pagos.administracion.servicio.testdatabuilder;

import com.ceiba.pagos.administracion.modelo.entidad.PagosAdministracion;
import com.ceiba.pagos.administracion.puerto.repositorio.RepositorioPagosAdministracion;
import com.ceiba.pagos.administracion.servicio.ServicioCrearPagosAdministracion;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearPagosAdministracionTest {

    @Test
    @DisplayName("Deberia Crear el pago de manera correcta")
    void deberiaCrearElUsuarioDeManeraCorrecta() {
        // arrange
        PagosAdministracion pagosAdministracion = new PagosAdministracionTestDataBuilder().build();
        RepositorioPagosAdministracion repositorioPagosAdministracion = Mockito.mock(RepositorioPagosAdministracion.class);
        Mockito.when(repositorioPagosAdministracion.crear(pagosAdministracion)).thenReturn(10L);
        ServicioCrearPagosAdministracion servicioCrearPagosAdministracion = new ServicioCrearPagosAdministracion(repositorioPagosAdministracion);
        // act
        Long idPagosAdministracion = servicioCrearPagosAdministracion.ejecutar(pagosAdministracion);
        //- assert
        assertEquals(10L,idPagosAdministracion);
        Mockito.verify(repositorioPagosAdministracion, Mockito.times(1)).crear(pagosAdministracion);
    }
}

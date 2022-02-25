package com.ceiba.pagos.administracion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.pagos.administracion.modelo.dto.DtoConsultarSaldoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoTotalPagadoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.entidad.PagosAdministracion;
import com.ceiba.pagos.administracion.puerto.repositorio.RepositorioPagosAdministracion;
import com.ceiba.pagos.administracion.servicio.testdatabuilder.PagosAdministracionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearPagosAdministracionTest {

    private static final String NO_PUEDE_EXCEDER_VALOR_MAXIMO_MENSUAL = "No puede pagar mas de 300.000 de administración al mes.";

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

    @Test
    @DisplayName("Deberia fallar por superar el valor maximo")
    void deberiaFallarPorSuperarElValorMaximo() {
        // arrange
        DtoTotalPagadoPagosAdministracion dtoTotalPagadoPagosAdministracion = new DtoTotalPagadoPagosAdministracion("AQ17", 300000);
        PagosAdministracion pagosAdministracion = new PagosAdministracionTestDataBuilder()
                .conValorPagado(100000)
                .build();

        RepositorioPagosAdministracion repositorioPagosAdministracion = Mockito.mock(RepositorioPagosAdministracion.class);

        Mockito.when(repositorioPagosAdministracion.existePorCodigoMes(Mockito.any(DtoConsultarSaldoPagosAdministracion.class))).thenReturn(true);
        Mockito.when(repositorioPagosAdministracion.consultarTotalPagado(Mockito.any(DtoConsultarSaldoPagosAdministracion.class))).thenReturn(dtoTotalPagadoPagosAdministracion);

        ServicioCrearPagosAdministracion servicioCrearPagosAdministracion = new ServicioCrearPagosAdministracion(repositorioPagosAdministracion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPagosAdministracion.ejecutar(pagosAdministracion), ExcepcionValorInvalido.class, NO_PUEDE_EXCEDER_VALOR_MAXIMO_MENSUAL);
    }
}

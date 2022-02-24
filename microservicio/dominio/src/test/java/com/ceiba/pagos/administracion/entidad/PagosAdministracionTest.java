package com.ceiba.pagos.administracion.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pagos.administracion.modelo.entidad.PagosAdministracion;
import com.ceiba.pagos.administracion.servicio.testdatabuilder.PagosAdministracionTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagosAdministracionTest {

    @Test
    @DisplayName("Deberia crear correctamente el pago de administración")
    void deberiaCrearCorrectamenteElUsusuario() {
        // arrange
        LocalDateTime fechaCreacion = LocalDateTime.now();
        //act
        PagosAdministracion pagosAdministracion = new PagosAdministracionTestDataBuilder().conFechaCreacion(fechaCreacion).conId(1L).build();
        //assert
        assertEquals(1, pagosAdministracion.getId());
        assertEquals("AQ17", pagosAdministracion.getCodigoInmueble());
        assertEquals(1324549876, pagosAdministracion.getNumeroIdentificacionPersona());
        assertEquals(300000, pagosAdministracion.getValorPagado());
        assertEquals(0, pagosAdministracion.getPorcentajeInteres());
        assertEquals(0, pagosAdministracion.getValorPagadoInteres());
        assertEquals(true, pagosAdministracion.getPagoTotal());
        assertEquals(fechaCreacion, pagosAdministracion.getFechaCreacion());
    }

    @Test
    void deberiaFallarSinCodigoInmueble() {

        //Arrange
        PagosAdministracionTestDataBuilder pagosAdministracionTestDataBuilder = new PagosAdministracionTestDataBuilder().conCodigoInmueble(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    pagosAdministracionTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el código del inmueble");
    }

    @Test
    void deberiaFallarSinNumeroIdentificacionPersona() {

        //Arrange
        PagosAdministracionTestDataBuilder pagosAdministracionTestDataBuilder = new PagosAdministracionTestDataBuilder().conNumeroIdentificacionPersona(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    pagosAdministracionTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el número de identificación de la persona");
    }

    @Test
    void deberiaFallarSinValorPagado() {

        //Arrange
        PagosAdministracionTestDataBuilder pagosAdministracionTestDataBuilder = new PagosAdministracionTestDataBuilder().conValorPagado(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    pagosAdministracionTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el valor a pagar");
    }

    @Test
    void deberiaFallarSinPagoTotal() {

        //Arrange
        PagosAdministracionTestDataBuilder pagosAdministracionTestDataBuilder = new PagosAdministracionTestDataBuilder().conPagoTotal(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    pagosAdministracionTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar si es un pago total o parcial.");
    }
}

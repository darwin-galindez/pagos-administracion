package com.ceiba.pagos.administracion.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pagos.administracion.modelo.entidad.PagosAdministracion;
import com.ceiba.pagos.administracion.servicio.testdatabuilder.PagosAdministracionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagosAdministracionTest {

    private static final String SE_DEBE_INGRESAR_CODIGO_INMUEBLE = "Se debe ingresar el código del inmueble";
    private static final String SE_DEBE_INGRESAR_NUMERO_IDENTIFICACION_PERSONA = "Se debe ingresar el número de identificación de la persona";
    private static final String SE_DEBE_INGRESAR_VALOR_PAGADO = "Se debe ingresar el valor a pagar";
    private static final String RANGO_VALOR_PAGADO_MINIMO_MAXIMO = "Debe ingresar un valor entre 50.000 y 300.000";

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
    @DisplayName("Deberia fallar sin codigo inmueble")
    void deberiaFallarSinCodigoInmueble() {

        //Arrange
        PagosAdministracionTestDataBuilder pagosAdministracionTestDataBuilder = new PagosAdministracionTestDataBuilder().conCodigoInmueble(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    pagosAdministracionTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_CODIGO_INMUEBLE);
    }

    @Test
    @DisplayName("Deberia fallar sin sin número de identificación")
    void deberiaFallarSinNumeroIdentificacionPersona() {

        //Arrange
        PagosAdministracionTestDataBuilder pagosAdministracionTestDataBuilder = new PagosAdministracionTestDataBuilder().conNumeroIdentificacionPersona(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    pagosAdministracionTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_NUMERO_IDENTIFICACION_PERSONA);
    }

    @Test
    @DisplayName("Deberia fallar sin sin valor pagado")
    void deberiaFallarSinValorPagado() {

        //Arrange
        PagosAdministracionTestDataBuilder pagosAdministracionTestDataBuilder = new PagosAdministracionTestDataBuilder().conValorPagado(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    pagosAdministracionTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_VALOR_PAGADO);
    }

    @Test
    @DisplayName("Deberia fallar con un valor inferior a 50.000")
    void deberiaFallarConValorPagadoInferiorAlMinimo() {

        //Arrange
        PagosAdministracionTestDataBuilder pagosAdministracionTestDataBuilder = new PagosAdministracionTestDataBuilder()
                .conValorPagado(20000)
                .conId(1L);

        //act-assert
        BasePrueba.assertThrows(() -> {
                    pagosAdministracionTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, RANGO_VALOR_PAGADO_MINIMO_MAXIMO);
    }

    @Test
    @DisplayName("Deberia fallar con un valor superior a 300.000")
    void deberiaFallarConValorPagadoSuperiorAlMaximo() {

        //Arrange
        PagosAdministracionTestDataBuilder pagosAdministracionTestDataBuilder = new PagosAdministracionTestDataBuilder()
                .conValorPagado(350000)
                .conId(1L);

        //act-assert
        BasePrueba.assertThrows(() -> {
                    pagosAdministracionTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, RANGO_VALOR_PAGADO_MINIMO_MAXIMO);
    }
}

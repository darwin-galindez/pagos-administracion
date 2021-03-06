package com.ceiba.pagos.administracion.servicio;

import com.ceiba.pagos.administracion.modelo.dto.DtoConsultarSaldoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoSaldoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoTotalPagadoPagosAdministracion;
import com.ceiba.pagos.administracion.puerto.repositorio.RepositorioPagosAdministracion;
import com.ceiba.pagos.administracion.servicio.testdatabuilder.ConsultarEstadoPagosAdministracionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioTotalPagadoPagosAdministracionTest {

    @Test
    @DisplayName("Deberia consultar de manera correcta el saldo del inmueble AQ18")
    void deberiaConsultarCorrectamenteElSaldoDelInmueble() {

        DtoConsultarSaldoPagosAdministracion dataBuilder = new ConsultarEstadoPagosAdministracionTestDataBuilder().build();

        RepositorioPagosAdministracion repositorioPagosAdministracion = Mockito.mock(RepositorioPagosAdministracion.class);
        Mockito.when(repositorioPagosAdministracion.consultarTotalPagado(dataBuilder)).thenReturn(new DtoTotalPagadoPagosAdministracion("AQ18", 300000));

        ServicioTotalPagadoPagosAdministracion servicioTotalPagadoPagosAdministracion = new ServicioTotalPagadoPagosAdministracion(repositorioPagosAdministracion);
        DtoSaldoPagosAdministracion totalPagadoPagosAdministracion = servicioTotalPagadoPagosAdministracion.ejecutar(dataBuilder);

        assertEquals("AQ18",totalPagadoPagosAdministracion.getCodigoInmueble());
    }
}

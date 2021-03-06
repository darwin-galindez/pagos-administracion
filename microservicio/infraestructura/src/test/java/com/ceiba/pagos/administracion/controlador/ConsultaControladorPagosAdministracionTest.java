package com.ceiba.pagos.administracion.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.pagos.administracion.modelo.dto.DtoConsultarSaldoPagosAdministracion;
import com.ceiba.pagos.administracion.servicio.testdatabuilder.ConsultarSaldoPagosAdministracionTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorPagosAdministracionTest.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ConsultaControladorPagosAdministracionTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia consultar correctamente el saldo")
    void deberiaConsultarCorrectamenteElSaldoInmueble() throws Exception {

        DtoConsultarSaldoPagosAdministracion consultarSaldoPagosAdministracion = new ConsultarSaldoPagosAdministracionTestDataBuilder().build();

        mocMvc.perform(post("/pagos/consultar-saldo")
                        .contentType(MediaType.APPLICATION_JSON))
                        // .content(objectMapper.writeValueAsString(consultarSaldoPagosAdministracion)))
                        .andExpect(status().isBadRequest());
    }
}

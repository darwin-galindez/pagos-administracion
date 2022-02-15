package com.ceiba.pagos.administracion.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.pagos.administracion.comando.ComandoPagosAdministracion;
import com.ceiba.pagos.administracion.servicio.testdatabuilder.ComandoPagosAdministracionTestDataBuilder;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorPagosAdministracionTest.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorPagosAdministracionTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un pago de administracion")
    void deberiaCrearPagoAdministracion() throws Exception {

        ComandoPagosAdministracion comandoPagosAdministracion = new ComandoPagosAdministracionTestDataBuilder().build();

        mocMvc.perform(post("/pagos-administracion")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoPagosAdministracion)))
                .andExpect(status().isOk());
    }
}

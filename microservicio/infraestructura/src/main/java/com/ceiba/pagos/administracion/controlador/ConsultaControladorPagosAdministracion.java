package com.ceiba.pagos.administracion.controlador;

import com.ceiba.pagos.administracion.consulta.ManejadorTotalPagadoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoConsultarSaldoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoSaldoPagosAdministracion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagos")
@Api(tags = {"Controlador para consultas pagos administracion"})
public class ConsultaControladorPagosAdministracion {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ManejadorTotalPagadoPagosAdministracion manejadorTotalPagadoPagosAdministracion;

    @Autowired
    public ConsultaControladorPagosAdministracion(ManejadorTotalPagadoPagosAdministracion manejadorTotalPagadoPagosAdministracion) {
        this.manejadorTotalPagadoPagosAdministracion = manejadorTotalPagadoPagosAdministracion;
    }

    @PostMapping("/consultar-saldo")
    @ApiOperation("Consultar el saldo de un inmueble por codigo y mes")
    public DtoSaldoPagosAdministracion consultarSaldo(@RequestBody DtoConsultarSaldoPagosAdministracion consultarSaldoPagosAdministracion) {
        return manejadorTotalPagadoPagosAdministracion.ejecutar(consultarSaldoPagosAdministracion);
    }
}

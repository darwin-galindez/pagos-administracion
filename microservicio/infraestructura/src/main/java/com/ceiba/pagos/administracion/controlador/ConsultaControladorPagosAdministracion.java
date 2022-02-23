package com.ceiba.pagos.administracion.controlador;

import com.ceiba.pagos.administracion.consulta.ManejadorListarPagosAdministracion;
import com.ceiba.pagos.administracion.consulta.ManejadorTotalPagadoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoConsultarSaldoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoSaldoPagosAdministracion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@Api(tags = {"Controlador para consultas pagos administracion"})
public class ConsultaControladorPagosAdministracion {

    private final ManejadorListarPagosAdministracion manejadorListarPagosAdministracion;
    private final ManejadorTotalPagadoPagosAdministracion manejadorTotalPagadoPagosAdministracion;

    @Autowired
    public ConsultaControladorPagosAdministracion(ManejadorTotalPagadoPagosAdministracion manejadorTotalPagadoPagosAdministracion, ManejadorListarPagosAdministracion manejadorListarPagosAdministracion) {
        this.manejadorTotalPagadoPagosAdministracion = manejadorTotalPagadoPagosAdministracion;
        this.manejadorListarPagosAdministracion = manejadorListarPagosAdministracion;
    }

    @PostMapping("/consultar-saldo")
    @ApiOperation("Consultar el saldo de un inmueble por codigo y mes")
    public DtoSaldoPagosAdministracion consultarSaldo(@RequestBody DtoConsultarSaldoPagosAdministracion consultarSaldoPagosAdministracion) {
        return manejadorTotalPagadoPagosAdministracion.ejecutar(consultarSaldoPagosAdministracion);
    }

    @GetMapping("/listar")
    @ApiOperation("Listar todos los pagos realizados")
    public List<DtoPagosAdministracion> listar() {
        return manejadorListarPagosAdministracion.ejecutar();
    }
}

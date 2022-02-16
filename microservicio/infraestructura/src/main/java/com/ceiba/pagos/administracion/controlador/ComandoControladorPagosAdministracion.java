package com.ceiba.pagos.administracion.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pagos.administracion.comando.ComandoPagosAdministracion;
import com.ceiba.pagos.administracion.comando.manejador.ManejadorCrearPagosAdministracion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/pagos")
@Api(tags = {"Controlador comando pagos administracion"})
public class ComandoControladorPagosAdministracion {

    private final ManejadorCrearPagosAdministracion manejadorCrearPagosAdministracion;

    @Autowired
    public ComandoControladorPagosAdministracion(ManejadorCrearPagosAdministracion manejadorCrearPagosAdministracion) {
        this.manejadorCrearPagosAdministracion = manejadorCrearPagosAdministracion;
    }

    @PostMapping
    @ApiOperation("Crear pago administracion")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPagosAdministracion comandoPagosAdministracion) {
        comandoPagosAdministracion.setFechaCreacion(LocalDateTime.now());
        return manejadorCrearPagosAdministracion.ejecutar(comandoPagosAdministracion);
    }
}

package com.ceiba.pagos.administracion.consulta;

import com.ceiba.pagos.administracion.modelo.dto.DtoPagosAdministracion;
import com.ceiba.pagos.administracion.puerto.dao.DaoPagosAdministracion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPagosAdministracion {

    private final DaoPagosAdministracion daoPagosAdministracion;

    public ManejadorListarPagosAdministracion(DaoPagosAdministracion daoPagosAdministracion) {
        this.daoPagosAdministracion = daoPagosAdministracion;
    }

    public List<DtoPagosAdministracion> ejecutar() {
        return this.daoPagosAdministracion.listar();
    }
}

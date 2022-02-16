package com.ceiba.pagos.administracion.puerto.repositorio;

import com.ceiba.pagos.administracion.modelo.dto.DtoConsultarSaldoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.dto.DtoTotalPagadoPagosAdministracion;
import com.ceiba.pagos.administracion.modelo.entidad.PagosAdministracion;

public interface RepositorioPagosAdministracion {

    /**
     * Permite crear un pago de administracion
     * @param pagosAdministracion
     * @return el id generado
     */
    Long crear(PagosAdministracion pagosAdministracion);

    /**
     * Permite obtener el total pagado de un inmueble en un mes
     * @return totalPagado
     */
    DtoTotalPagadoPagosAdministracion consultarTotalPagado(DtoConsultarSaldoPagosAdministracion dtoConsultarSaldoPagosAdministracion);
}

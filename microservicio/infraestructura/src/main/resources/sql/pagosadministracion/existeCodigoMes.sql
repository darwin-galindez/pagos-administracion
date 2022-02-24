select count(1) from pagos_administracion
    where codigo_inmueble = :codigoInmueble
    and month(fecha_creacion) = :mes
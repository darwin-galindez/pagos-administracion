select count(1) from usuario
    where codigo_inmueble = :codigoInmueble
    and month(fecha_creacion) = :mes
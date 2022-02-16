select codigo_inmueble, SUM(valor_pagado) AS total
    from pagos_administracion
    where codigo_inmueble = :codigoInmueble
    and month(fecha_creacion) = :mes
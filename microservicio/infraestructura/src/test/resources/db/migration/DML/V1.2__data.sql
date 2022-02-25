insert into pagos_administracion(
    codigo_inmueble,
    numero_identificacion_persona,
    valor_pagado,
    porcentaje_interes,
    valor_pagado_interes,
    pago_total,
    fecha_creacion
) values(
    'QA17',
    123456,
    300000,
    0,
    0,
    true,
    now()
)
create table pagos_administracion (
 id int(11) not null auto_increment,
 codigo_inmueble varchar(100) not null,
 numero_identificacion_persona int(10) not null,
 valor_pagado int(11) not null,
 porcentaje_interes int(2) null,
 valor_pagado_interes int(11) null,
 pago_total boolean not null default 0,
 fecha_creacion datetime null,
 primary key (id)
);
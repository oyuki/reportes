# Clientes

# --- !Ups

create table clientes {
  num_cte bigint(20) not null auto_increment,
  nombre_cte varchar(255),
  ap_pat_cte varcha(255),
  ap_mat_cte varchar(255),
  rfc_cte varchar(20),
  calle_cte varchar(255),
  num_calle_cte varchar(10),
  colonia_cte varchar(20),
  codp_cte integer,
  mun_cte varchar(255),
  est_cte varchar(255),
  tel_cte varchar(40),
  email_cte varchar(100)
}


# --- !Downs

drop table clientes
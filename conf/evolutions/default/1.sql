# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cliente (
  id                        bigint not null,
  nombre_cte                varchar(255),
  ap_pat_cte                varchar(255),
  rfc_cte                   varchar(255),
  ap_mat_cte                varchar(255),
  constraint pk_cliente primary key (id))
;

create sequence cliente_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists cliente;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists cliente_seq;


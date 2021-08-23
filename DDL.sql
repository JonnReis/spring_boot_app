create schema vehicle;

use vehicle;

create user 'teste'@'localhost' identified by 'teste123';

grant select, insert, delete, update on anotacao.* to user@'localhost';

create table car_car (
  car_id bigint unsigned not null auto_increment,
  car_model varchar(50) not null,
  car_color varchar(20) not null,
  primary key (car_id),
  unique key uni_car_model (car_model)
);

create table bra_brand (
  bra_id bigint unsigned not null auto_increment,
  bra_name varchar(50) not null,
  primary key (bra_id),
  unique key uni_bra_name (bra_name)
);

create table car_brand (
  car_id bigint unsigned not null,
  bra_id bigint unsigned not null,
  primary key (car_id, bra_id),
  foreign key cbc_car_fk (car_id) references car_car (car_id) on delete restrict on update cascade,
  foreign key cbc_brand_fk (bra_id) references bra_brand (bra_id) on delete restrict on update cascade
);

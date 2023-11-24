create table tb_farm
(
    id      uuid not null primary key,
    address varchar(255),
    city    varchar(255),
    name    varchar(255),
    state   varchar(255)
);
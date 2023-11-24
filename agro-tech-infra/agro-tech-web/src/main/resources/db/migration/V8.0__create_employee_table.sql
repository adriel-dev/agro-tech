create table tb_employee
(
    id         uuid not null primary key,
    birth_date date,
    last_name  varchar(255),
    name       varchar(255),
    role       varchar(255),
    salary     double precision,
    farm_id    uuid constraint fk1acrvi5grtna2pt01uo61bikw references tb_farm
);
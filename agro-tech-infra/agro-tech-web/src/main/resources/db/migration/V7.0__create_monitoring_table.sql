create table tb_monitoring
(
    id              uuid not null primary key,
    dewormed        boolean,
    height          double precision,
    monitoring_date timestamp(6) with time zone,
    weight          double precision,
    animal_id       uuid constraint fkmayvqprgf9q6b50orfs99mxn references tb_animal
);
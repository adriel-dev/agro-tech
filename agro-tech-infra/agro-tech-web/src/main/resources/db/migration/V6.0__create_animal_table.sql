create table tb_animal
(
    id                uuid not null primary key,
    acquisition_date  date,
    acquisition_value double precision,
    name              varchar(255),
    sale_date         date,
    sale_value        double precision,
    sex               smallint constraint animal_sex_check check ((sex >= 0) AND (sex <= 1)),
    breed_id          uuid constraint fk_animal_breed_id references tb_breed,
    farm_id           uuid constraint fk_animal_farm_id references tb_farm
);
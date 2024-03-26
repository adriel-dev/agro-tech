create table tb_breed
(
    id         uuid not null primary key,
    name       varchar(255),
    species_id uuid constraint fk_breed_species_id references tb_species
);
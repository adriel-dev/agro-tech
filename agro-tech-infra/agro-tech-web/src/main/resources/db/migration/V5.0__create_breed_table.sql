create table tb_breed
(
    id         uuid not null primary key,
    name       varchar(255),
    species_id uuid  constraint uk_91mrq28cuf2vhsryfjb2vnk3j unique constraint fk562cbno8t7070q0m0po1fki2n references tb_species
);
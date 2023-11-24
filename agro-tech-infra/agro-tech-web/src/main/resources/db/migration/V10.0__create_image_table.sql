create table tb_image
(
    id uuid not null primary key,
    type varchar(255),
    file_path varchar(255),
    file_extension varchar(255),
    animal_id uuid
        constraint uk_image_animal_id unique
        constraint fk_image_animal_id references tb_animal
)
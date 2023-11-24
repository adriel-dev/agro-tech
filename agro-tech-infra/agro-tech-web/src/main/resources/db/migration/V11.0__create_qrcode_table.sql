create table tb_qrcode
(
    id uuid not null primary key,
    data oid,
    animal_id uuid
        constraint uk_qrcode_animal_id unique
        constraint fk_qrcode_animal_id references tb_animal
)
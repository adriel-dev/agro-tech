create table tb_user
(
    id       uuid not null primary key,
    password varchar(255) not null,
    username varchar(255) not null constraint uk_fbej4mti5199eja95x8ibr9sx unique,
    email    varchar(255),
    farm_id  uuid constraint fkhvigwwq1tlw4hjrikamr3wtjl references tb_farm
);
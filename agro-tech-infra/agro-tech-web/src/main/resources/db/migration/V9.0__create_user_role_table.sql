create table tb_user_role
(
    user_id uuid not null  constraint fk8ph9sd9n0ju4t70dfuuialneu references tb_user,
    role_id uuid not null  constraint fkrwe45fedljgn462ik6l5tv0d6 references tb_role,
    primary key (user_id, role_id)
);
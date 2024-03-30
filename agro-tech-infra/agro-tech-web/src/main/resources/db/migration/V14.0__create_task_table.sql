CREATE TABLE tb_task
(
    id uuid primary key,
    title varchar(255),
    description text,
    status smallint constraint task_status_check check (status >= 0 and status <= 2),
    employee_id uuid constraint fk_task_employee_id references tb_employee,
    start_date timestamp,
    started_at timestamp,
    finish_until timestamp,
    finished_at timestamp,
    created_date date,
    created_by varchar(255),
    last_modified_by varchar(255),
    last_modified_date date,
    is_deleted boolean
);
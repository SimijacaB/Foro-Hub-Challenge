create table topics (
    id serial primary key,
    message varchar(1000) not null,
    created_at timestamp not null default current_timestamp,
    course varchar(255) not null,
    status  varchar(50) not null
);
create table users
(
    id    bigint       not null auto_increment,
    user_name varchar(100) not null unique,
    password varchar(300) not null,
    primary key (id)
);
create table replies (
                        id serial primary key,
                        title varchar(200) not null,
                        message varchar(1000) not null,
                        created_at timestamp not null default current_timestamp,
                        status  varchar(50) not null,
                        topic_id integer not null,
                        foreign key (topic_id) references topics(id)
);
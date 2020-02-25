create table news(
id serial primary key,
news_name varchar(50) unique not null,
contant varchar(200) not null,
date_of_publication timestamp
);
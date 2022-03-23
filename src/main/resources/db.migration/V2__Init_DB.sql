--drop table if exists migrations.flyway_schema_history;
drop table if exists migrations.tags;
drop table if exists migrations.articles;
drop table if exists migrations.authors;
drop table if exists migrations.categorys;

create table authors(
id serial primary key,
first_name varchar(20) not null ,
last_name varchar(20) not null
);

create table categorys (
id serial primary key,
category_name varchar(20) not null
);

create table articles (
id serial primary key,
article_name varchar(80) not null ,
summary text,
content  text,
author_id int references authors("id"),
category_id int references categorys("id"),
publication_date timestamp
);

create table tags (
id serial primary key,
tag_name varchar(120) not null,
article_id int references articles("id")
);

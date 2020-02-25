create table bus(
id serial primary key,
way_id integer references busWay(id) not null
);

create table driver(
id serial primary key,
driver_name varchar(50) not null,
bus_id integer references bus(id) not null
);

create table busWay(
id serial primary key,
start_at varchar(50) not null,
end_at varchar(50) not null
);

create table bus_logs(
id serial primary key,
driver_id integer references driver(id) not null,
bus_id integer references bus(id) not null,
time_on_way timestamp not null
);

insert into busWay(start_at, end_at) values ('Shop','Bulding');
insert into busWay(start_at, end_at) values ('Building','Street');
insert into busWay(start_at, end_at) values ('Street','Road');
insert into busWay(start_at, end_at) values ('Road','Village');

insert into bus (way_id) values (1);
insert into bus (way_id) values (2);
insert into bus (way_id) values (3);
insert into bus (way_id) values (4);

insert into driver(driver_name, bus_id) values ('A',1 );
insert into driver(driver_name, bus_id) values ('B',2 );
insert into driver(driver_name, bus_id) values ('C',3 );
insert into driver(driver_name, bus_id) values ('D',4 );

insert into bus_logs(driver_id,bus_id, time_on_way) values (1,1, '2020-01-15 10:23:54');
insert into bus_logs(driver_id,bus_id, time_on_way) values (2,2, '2020-01-16 10:23:54');
insert into bus_logs(driver_id,bus_id, time_on_way) values (3,3, '2020-02-14 10:23:54');
insert into bus_logs(driver_id,bus_id, time_on_way) values (4,4, '2020-02-17 10:20:54');
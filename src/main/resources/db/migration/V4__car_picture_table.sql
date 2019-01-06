create table car_picture
(
	picture_id bigserial not null
		constraint car_picture_pk
			primary key,
	name varchar(20) not null,
	subname varchar(20) not null,
	type varchar(10) not null,
	color varchar(10) not null
);

alter table car_picture owner to postgres;

alter table car drop column picture;
alter table car add picture_id bigint not null;

alter table car ADD CONSTRAINT car_picture_car_picture_id_fk FOREIGN KEY (picture_id) REFERENCES car_picture (picture_id) on update cascade on delete cascade;
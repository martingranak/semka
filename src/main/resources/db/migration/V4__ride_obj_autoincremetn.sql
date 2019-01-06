create sequence ride_obj_ride_id_seq;

alter table ride_obj alter column ride_id set default nextval('public.ride_obj_ride_id_seq');

alter sequence ride_obj_ride_id_seq owned by ride_obj.ride_id;
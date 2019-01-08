create index ride_obj_datetime_from_index
	on ride_obj (datetime_from);

create index person_course_course_id_date_to_index
	on person_course (course_id, date_to);

create index payment_description_index
	on payment (description);

create index payment_ride_id_index
	on payment (ride_id);
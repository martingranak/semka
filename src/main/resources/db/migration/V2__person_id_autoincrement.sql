create sequence person_identity_number_seq;

alter table person alter column identity_number set default nextval('public.person_identity_number_seq');

alter sequence person_identity_number_seq owned by person.identity_number;

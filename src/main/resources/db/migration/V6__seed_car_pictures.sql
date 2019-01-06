create or replace function seed_car_pictures(p_path text, p_result out boolean)
language plpgsql as $$
declare
  pictures cursor for select * from car_picture;
begin
  p_result := false;
  for pic in pictures
  loop
    UPDATE car_picture SET picture = picture_import(p_path || pic.name || '\' || pic.type || '\' || pic.subname || '-' || pic.color || '.jpg') WHERE picture_id = pic.picture_id;
  end loop;
  p_result := true;
end;$$;

commit;

select seed_car_pictures('D:\obr\');
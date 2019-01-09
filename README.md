
Requirements:
- PostgreSQL 10.6.5
- Angular 7
- nodejs @latest
- IntelliJ IDEA


how to run BE (using idea)
1. build and run application to create database
2. import ddata from file (person.csv to table person, car_picture.csv to table car_picture) using import file into table
3. extract imges from obr.rar into your pc (save path for later)
4. in SQL console run command select 'seed_car_pictures("YOUR_PATH_TO_PICTURE_OLDER");' for example 'select seed_car_pictures('D:\obr\');'
5. open http://localhost:8080/seeder/seed to seed all other data to database
6. wait till seeder finish and from time to time check db if tables are filled with data

how to run FE
1. install angular 
2. run 'npm install' in console in folder ./webapp
3. run angular application 'ng serve -o' 



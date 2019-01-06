package sk.pds.semestralka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.pds.semestralka.model.*;
import sk.pds.semestralka.service.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping("/seeder")
public class SeedController {
    @Autowired
    private CarService carService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PersonService personService;

    @Autowired
    private RideService rideService;

    @RequestMapping(value = "/seed", method = RequestMethod.GET)
    public void removePerson() {
        List<Person> persons = this.personService.findAll();
        List<Course> courses = this.courseService.findAll();
        for (Person person : persons) {
            int courseNum = ThreadLocalRandom.current().nextInt(1, courses.size());
            int[] cisla = new int[courseNum];
            for (int i = 0; i < courseNum; i++) {
                int index;
                while (true) {
                    index = ThreadLocalRandom.current().nextInt(0, courseNum);
                    boolean obsahuje = false;
                    for (int indexes : cisla) {
                        if (indexes == index + 1) {
                            obsahuje = true;
                        }
                    }
                    if (!obsahuje) {
                        Course course = courses.get(index);
                        int yearFrom = 2019 - ThreadLocalRandom.current().nextInt(0, 10);
                        int month = ThreadLocalRandom.current().nextInt(1, 13);
                        if (month < 10) {
                            this.personService.addCourseToPerson(person, course, yearFrom + "-0" + month + "-01", yearFrom + 2 + "-0" + month + "-01");
                        } else {
                            this.personService.addCourseToPerson(person, course, yearFrom + "-" + month + "-01", yearFrom + 2 + "-" + month + "-01");
                        }
                        cisla[i] = index + 1;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < 5000; i ++) {
            int car = ThreadLocalRandom.current().nextInt(1, 61);
            CarPicture carPicture = this.carService.findCarPictureById(car);
            int fuelType = ThreadLocalRandom.current().nextInt(1, 5);
            String fuel = "";
            double consumption = 0;
            switch (fuelType) {
                case 1:
                    fuel = "95";
                    consumption = ThreadLocalRandom.current().nextDouble(5, 7);
                    break;
                case 2:
                    fuel = "100";
                    consumption = ThreadLocalRandom.current().nextDouble(5, 7);
                    break;
                case 3:
                    fuel = "D";
                    consumption = ThreadLocalRandom.current().nextDouble(4.5, 6);
                    break;
                case 4:
                    fuel = "LPG";
                    consumption = ThreadLocalRandom.current().nextDouble(6, 8.5);
                    break;
            }
            this.carService.addCar(carPicture.getName() + " " + carPicture.getSubName(), carPicture.getType(), fuel, consumption, carPicture.getPictureId());
        }

        List<Car> cars = this.carService.findAllCarsWithoutPictures();
        int index = ThreadLocalRandom.current().nextInt(0, 11);
        int carIndex = 0;
        while (index <= 30000 && carIndex < cars.size()) {
            Car car = cars.get(carIndex);
            int rideNum = ThreadLocalRandom.current().nextInt(0, 5);
            for (int i = 0; i < rideNum; i++) {
                if (index>29999) {
                    break;
                }
                Person person = persons.get(index);
                index += ThreadLocalRandom.current().nextInt(0, 5);
                int year = 2018 + ThreadLocalRandom.current().nextInt(0, 2);
                int month = ThreadLocalRandom.current().nextInt(1, 13);
                int day = ThreadLocalRandom.current().nextInt(1, 29);
                int hour = ThreadLocalRandom.current().nextInt(6, 16);
                int duration = ThreadLocalRandom.current().nextInt(5, 51);
                int hourTo = (hour + duration) % 24;
                int dayPlus = (hour + duration) / 24;
                if (hourTo > 19) {
                    hourTo = 6;
                    dayPlus++;
                } else if (hourTo < 6) {
                    hourTo = 6;
                }
                LocalDate dateFrom;
                if (month < 10) {
                    if (day < 10) {
                        dateFrom = LocalDate.parse(year + "-0" + month + "-0" + day);
                    } else {
                        dateFrom = LocalDate.parse(year + "-0" + month + "-" + day);
                    }
                } else {
                    if (day < 10) {
                        dateFrom = LocalDate.parse(year + "-" + month + "-0" + day);
                    } else {
                        dateFrom = LocalDate.parse(year + "-" + month + "-" + day);
                    }
                }
                LocalDate dateTo = dateFrom;
                dateTo = dateTo.plusDays(dayPlus);
                LocalTime timeFrom;
                if (hour < 10) {
                    timeFrom = LocalTime.parse("0" + hour + ":00:00");
                } else {
                    timeFrom = LocalTime.parse(hour + ":00:00");
                }
                LocalTime timeTo;
                if (hourTo < 10) {
                    timeTo = LocalTime.parse("0" + hourTo + ":00:00");
                } else {
                    timeTo = LocalTime.parse(hourTo + ":00:00");
                }
                dateTo.plusDays(dayPlus);
                this.rideService.addRide(car.getId(), person.getIdentityNumber(), dateFrom.toString(), timeFrom.toString(), dateTo.toString(), timeTo.toString());
            }
            index += ThreadLocalRandom.current().nextInt(1, 11);
            carIndex++;
        }
        List<Ride> rides = this.rideService.findAllRides();
        int index2 = ThreadLocalRandom.current().nextInt(0, 3);
        while (index2 < rides.size()) {
            Ride ride = rides.get(index2);
            int paymentNum = ThreadLocalRandom.current().nextInt(1, 4);
            for (int i = 0; i < paymentNum; i++) {
                int paymentDesc = ThreadLocalRandom.current().nextInt(0, 3);
                String desc = "";
                double value = 0;
                switch (paymentDesc) {
                    case 0:
                        desc = "pohonne latky";
                        value = ThreadLocalRandom.current().nextInt(2, 11)*5;
                        break;
                    case 1:
                        desc = "pokuta";
                        value = ThreadLocalRandom.current().nextInt(1, 25)*10;
                        break;
                    case 2:
                        desc = "ostatne";
                        value = ThreadLocalRandom.current().nextDouble(10, 50);
                        break;
                }

                this.paymentService.addPayment(ride.getId(), value, desc);
            }
            index2 += ThreadLocalRandom.current().nextInt(0, 5);
        }

        for (Ride ride : rides) {
            LocalDateTime rideTime = ride.getDatetimeFrom();
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime locationTime = rideTime.plusMinutes(3);
            double latitude = 49.202076;
            double longitude = 18.761506;
            while (locationTime.isBefore(now) && locationTime.isBefore(ride.getDatetimeTo())) {
                double value = ThreadLocalRandom.current().nextDouble(0.0, 0.3);
                boolean more = ThreadLocalRandom.current().nextBoolean();
                if (more) {
                    latitude += value;
                } else  {
                    latitude -= value;
                }
                more = ThreadLocalRandom.current().nextBoolean();
                if (more) {
                    longitude += 0.3-value;
                } else  {
                    longitude -= 0.3-value;
                }
                this.locationService.addLocation(ride.getId(), latitude, longitude, locationTime.toString());
                locationTime = locationTime.plusMinutes(1);
            }
        }
    }
}

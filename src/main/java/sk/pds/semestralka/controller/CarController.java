package sk.pds.semestralka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.pds.semestralka.model.Car;
import sk.pds.semestralka.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping(value = "/one", method = RequestMethod.POST)
    public Car findOne(@RequestBody long carId) {
        return this.carService.findById(carId);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Car> findAllCars() {
        return this.carService.findAllCars();
    }

    @RequestMapping(value = "/name/{carName}", method = RequestMethod.GET)
    public List<Car> findByName(@RequestParam("carName") String carName) {
        return this.carService.findByName(carName);
    }

    @RequestMapping(value = "/type/{carType}", method = RequestMethod.GET)
    public List<Car> findByType(@RequestParam("carType") String carType) {
        return this.carService.findByType(carType);
    }

    @RequestMapping(value = "/fuel/{carFuelType}", method = RequestMethod.GET)
    public List<Car> findByFuelType(@RequestParam("carFuelType") String carFuelType) {
        return this.carService.findByFuelType(carFuelType);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody String carName, @RequestBody String carType, @RequestBody String carFuelType, @RequestBody float carConsumption) {
        this.carService.addCar(carName, carType, carFuelType, carConsumption);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody long carId, @RequestBody Car car) {
        this.carService.updateCar(carId, car);
    }
}

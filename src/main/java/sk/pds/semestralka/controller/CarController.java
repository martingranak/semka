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

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Car> findAllCars() {
        return this.carService.findAllCars();
    }

    @RequestMapping(value = "/one", method = RequestMethod.POST)
    public Car findOne(@RequestParam("carId") long carId) {
        return this.carService.findById(carId);
    }

    @RequestMapping(value = "/name/{carName}", method = RequestMethod.GET)
    public List<Car> findByName(@PathVariable("carName") String carName) {
        return this.carService.findByName(carName);
    }

    @RequestMapping(value = "/type/{carType}", method = RequestMethod.GET)
    public List<Car> findByType(@PathVariable("carType") String carType) {
        return this.carService.findByType(carType);
    }

    @RequestMapping(value = "/fuel/{carFuelType}", method = RequestMethod.GET)
    public List<Car> findByFuelType(@PathVariable("carFuelType") String carFuelType) {
        return this.carService.findByFuelType(carFuelType);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Car add(@RequestParam("carName") String carName, @RequestParam("carType") String carType,
                   @RequestParam("carFuelType") String carFuelType, @RequestParam("carConsumption") float carConsumption) {
        return this.carService.addCar(carName, carType, carFuelType, carConsumption);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody Car car) {
        this.carService.updateCar(car);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@RequestParam("carId") long carId) {
        this.carService.removeCar(carId);
    }
}

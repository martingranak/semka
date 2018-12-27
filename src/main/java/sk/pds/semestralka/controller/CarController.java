package sk.pds.semestralka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.pds.semestralka.model.Car;
import sk.pds.semestralka.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Car> findAllCars() {
        return this.carService.findAllCars();
    }
}

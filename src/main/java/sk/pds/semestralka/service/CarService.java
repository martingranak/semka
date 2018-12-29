package sk.pds.semestralka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.pds.semestralka.mapper.CarMapper;
import sk.pds.semestralka.model.Car;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarMapper carMapper;

    public List<Car> findAllCars() {
        return this.carMapper.findAll();
    }

    public Car findById(long id) {
        return this.carMapper.findById(id);
    }

    public List<Car> findByName(String name) {
        return this.carMapper.findByName(name);
    }

    public List<Car> findByType(String carType) {
        return this.carMapper.findByType(carType);
    }

    public List<Car> findByFuelType(String carFuelType) {
        return this.carMapper.findByFuelType(carFuelType);
    }

    public void addCar(String carName, String carType, String carFuelType, float carConsumption) {
        this.carMapper.insertCar(new Car(carName, carType, carFuelType, carConsumption));
    }

    public void updateCar(long carId, Car car) {
        this.carMapper.updateCar(carId, car);
    }
}

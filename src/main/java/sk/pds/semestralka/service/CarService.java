package sk.pds.semestralka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.pds.semestralka.mapper.CarMapper;
import sk.pds.semestralka.model.Car;

import javax.transaction.Transactional;
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

    @Transactional
    public Car addCar(String carName, String carType, String carFuelType, float carConsumption, String picture) {
        Car car = new Car(carName, carType, carFuelType, carConsumption, picture.getBytes());
        this.carMapper.insertCar(car);
        return car;
    }

    @Transactional
    public void updateCar(Car car) {
        this.carMapper.updateCar(car);
    }

    @Transactional
    public void removeCar(long carId) {
        this.carMapper.deleteCar(carId);
    }
}

package sk.pds.semestralka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.pds.semestralka.mapper.CarMapper;
import sk.pds.semestralka.model.Car;
import sk.pds.semestralka.model.CarPicture;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarMapper carMapper;

    public List<Car> findAllCars() {
        return this.carMapper.findAll();
    }

    public List<Car> findAllCarsByPage(int page, int count) {
        return this.carMapper.findAllPage(count, (page - 1) * count);
    }

    public List<Car> findAllCarsPageByName(int page, int count) {
        return this.carMapper.findAllPageByName(count, (page - 1) * count);
    }

    public List<Car> findAllCarsPageByType(int page, int count) {
        return this.carMapper.findAllPageByType(count, (page - 1) * count);
    }

    public List<Car> findAllCarsPageByFuelType(int page, int count) {
        return this.carMapper.findAllPageByFuelType(count, (page - 1) * count);
    }

    public List<Car> findAllCarsWithoutPictures() {
        return this.carMapper.findAllWithoutPictures();
    }

    public List<CarPicture> findAllCarPictures() {
        return this.carMapper.findAllCarPictures();
    }

    public Car findById(long carId) {
        return this.carMapper.findById(carId);
    }

    public CarPicture findCarPictureById(long pictureId) {
        return this.carMapper.findPictureById(pictureId);
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
    public Car addCar(String carName, String carType, String carFuelType, double carConsumption, String pictureId) {
        Car car = new Car(carName, carType, carFuelType, carConsumption, pictureId);
        this.carMapper.insertCar(car);
        return car;
    }

    /*@Transactional
    public Car addCar(String carName, String carType, String carFuelType, float carConsumption, String picture) {
        Car car = new Car(carName, carType, carFuelType, carConsumption, picture.getBytes());
        this.carMapper.insertCar(car);
        return car;
    }*/

    @Transactional
    public void updateCar(Car car) {
        this.carMapper.updateCar(car);
    }

    @Transactional
    public void removeCar(long carId) {
        this.carMapper.deleteCar(carId);
    }
}

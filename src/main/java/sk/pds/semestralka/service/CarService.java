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
}

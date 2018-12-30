package sk.pds.semestralka.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sk.pds.semestralka.model.Car;

import java.util.List;

@Mapper
public interface CarMapper {
    List<Car> findAll();
    Car findById(@Param("carId") long id);
    List<Car> findByName(@Param("carName") String carName);
    List<Car> findByType(@Param("carType") String carType);
    List<Car> findByFuelType(@Param("carFuelType") String carFuelType);
    void insertCar(@Param("car") Car car);
    void updateCar(@Param("car") Car car);
    void deleteCar(@Param("carId") long carId);
}

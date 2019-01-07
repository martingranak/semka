package sk.pds.semestralka.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sk.pds.semestralka.model.Car;
import sk.pds.semestralka.model.CarPicture;

import java.util.List;

@Mapper
public interface CarMapper {
    List<Car> findAll();
    List<Car> findAllWithoutPictures();
    List<Car> findAllPage(@Param("limit") int limit, @Param("offset") int offset);
    List<Car> findAllPageByName(@Param("limit") int limit, @Param("offset") int offset);
    List<Car> findAllPageByType(@Param("limit") int limit, @Param("offset") int offset);
    List<Car> findAllPageByFuelType(@Param("limit") int limit, @Param("offset") int offset);
    List<CarPicture> findAllCarPictures();
    Car findById(@Param("carId") long carId);
    CarPicture findPictureById(@Param("pictureId") long pictureId);
    List<Car> findByName(@Param("carName") String carName);
    List<Car> findByType(@Param("carType") String carType);
    List<Car> findByFuelType(@Param("carFuelType") String carFuelType);
    void insertCar(@Param("car") Car car);
    void updateCar(@Param("car") Car car);
    void deleteCar(@Param("carId") long carId);
}

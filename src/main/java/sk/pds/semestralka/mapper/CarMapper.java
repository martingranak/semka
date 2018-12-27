package sk.pds.semestralka.mapper;

import org.apache.ibatis.annotations.Mapper;
import sk.pds.semestralka.model.Car;

import java.util.List;

@Mapper
public interface CarMapper {
    List<Car> findAll();
}

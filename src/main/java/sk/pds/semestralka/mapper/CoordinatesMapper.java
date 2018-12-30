package sk.pds.semestralka.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sk.pds.semestralka.model.Coordinates;

import java.util.List;

@Mapper
public interface CoordinatesMapper {
    List<Coordinates> findAll();
    Coordinates findById(@Param("coordinatesId") long coordinatesId);
    List<Coordinates> findByRide(@Param("rideId") long rideId);
    void insertCoordinates(@Param("coordinates") Coordinates coordinates);
    void updateCoordinates(@Param("coordinates") Coordinates coordinates);
    void deleteCoordinates(@Param("coordinatesId") long coordinatesId);
}

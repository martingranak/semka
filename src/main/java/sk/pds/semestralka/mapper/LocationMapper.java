package sk.pds.semestralka.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sk.pds.semestralka.model.Location;

import java.util.List;

@Mapper
public interface LocationMapper {
    List<Location> findAll();
    Location findById(@Param("coordinatesId") long coordinatesId);
    List<Location> findByRide(@Param("rideId") long rideId);
    void insertLocation(@Param("location") Location location);
    void updateLocation(@Param("location") Location location);
    void deleteLocation(@Param("coordinatesId") long coordinatesId);
}

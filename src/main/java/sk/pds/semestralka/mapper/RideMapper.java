package sk.pds.semestralka.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sk.pds.semestralka.model.Ride;

import java.util.List;

@Mapper
public interface RideMapper {
    List<Ride> findAll();
    Ride findById(@Param("rideId") long id);
    List<Ride> findByDriver(@Param("driverId") long driverId);
    List<Ride> findByCar(@Param("carId") long carId);
    void insertRide(@Param("ride") Ride ride);
    void updateRide(@Param("ride") Ride ride);
    void deleteRide(@Param("rideId") long rideId);
}

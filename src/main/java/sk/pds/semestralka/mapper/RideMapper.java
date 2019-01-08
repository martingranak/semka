package sk.pds.semestralka.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sk.pds.semestralka.model.Reservation;
import sk.pds.semestralka.model.Ride;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RideMapper {
    List<Ride> findAll();
    List<Ride> findAllByPageById(@Param("limit") int limit, @Param("offset") int offset);
    List<Ride> findAllByPageByIdentityNumber(@Param("limit") int limit, @Param("offset") int offset);
    List<Ride> findAllByPageByCarId(@Param("limit") int limit, @Param("offset") int offset);
    List<Ride> findAllByPageByDateFrom(@Param("limit") int limit, @Param("offset") int offset);
    List<Ride> findAllByPageByDateTo(@Param("limit") int limit, @Param("offset") int offset);
    Ride findById(@Param("rideId") long id);
    List<Ride> findByPerson(@Param("identityNumber") long identityNumber);
    List<Ride> findByCar(@Param("carId") long carId);
    void insertRide(@Param("ride") Ride ride);
    void updateRide(@Param("ride") Ride ride);
    void deleteRide(@Param("rideId") long rideId);

    List<Reservation> findAllReservations();

    List<Reservation> findAllPageReservations(@Param("limit") int limit, @Param("offset") int offset);
}

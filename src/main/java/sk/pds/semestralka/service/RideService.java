package sk.pds.semestralka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.pds.semestralka.mapper.RideMapper;
import sk.pds.semestralka.model.Ride;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class RideService {

    @Autowired
    private RideMapper rideMapper;

    public List<Ride> findAllRides() {
        return this.rideMapper.findAll();
    }

    public Ride findById(long rideId) {
        return this.rideMapper.findById(rideId);
    }

    public List<Ride> findByDriver(long driverId) {
        return this.rideMapper.findByDriver(driverId);
    }

    public List<Ride> findByCar(long carId) {
        return this.rideMapper.findByCar(carId);
    }

    @Transactional
    public Ride addRide(long carId, long identityNumber, String dateFrom, String timeFrom, String dateTo, String timeTo) {
        LocalDate localDateFrom = LocalDate.parse(dateFrom);
        LocalDate localDateTo = LocalDate.parse(dateTo);
        LocalTime localTimeFrom = LocalTime.parse(timeFrom);
        LocalTime localTimeTo = LocalTime.parse(timeTo);
        LocalDateTime localDateTimeFrom = LocalDateTime.of(localDateFrom, localTimeFrom);
        LocalDateTime localDateTimeTo = LocalDateTime.of(localDateTo, localTimeTo);
        Ride ride = new Ride(carId, identityNumber, localDateTimeFrom, localDateTimeTo);
        this.rideMapper.insertRide(ride);
        return ride;
    }

    @Transactional
    public void updateRide(Ride ride) {
        this.rideMapper.updateRide(ride);
    }

    @Transactional
    public void removeRide(long rideId) {
        this.rideMapper.deleteRide(rideId);
    }
}

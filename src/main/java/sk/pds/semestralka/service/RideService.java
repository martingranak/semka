package sk.pds.semestralka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.pds.semestralka.mapper.RideMapper;
import sk.pds.semestralka.model.Reservation;
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

    public List<Ride> findAllRidesByPageById(int page, int count) {
        return this.rideMapper.findAllByPageById(count, (page - 1) * count);
    }

    public List<Ride> findAllRidesByIdentityNumber(int page, int count) {
        return this.rideMapper.findAllByPageByIdentityNumber(count, (page - 1) * count);
    }

    public List<Ride> findAllRidesByCarId(int page, int count) {
        return this.rideMapper.findAllByPageByCarId(count, (page - 1) * count);
    }

    public List<Ride> findAllRidesByDateFrom(int page, int count) {
        return this.rideMapper.findAllByPageByDateFrom(count, (page - 1) * count);
    }

    public List<Ride> findAllRidesByDateTo(int page, int count) {
        return this.rideMapper.findAllByPageByDateTo(count, (page - 1) * count);
    }

    public Ride findById(long rideId) {
        return this.rideMapper.findById(rideId);
    }

    public List<Ride> findByDriver(long identityNumber) {
        return this.rideMapper.findByPerson(identityNumber);
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

    public List<Reservation> findAllReservations() {
        return this.rideMapper.findAllReservations();
    }

    public List<Reservation> findAllPageReservations(int page, int count) {
        return this.rideMapper.findAllPageReservations(count, (page - 1) * count);
    }
}

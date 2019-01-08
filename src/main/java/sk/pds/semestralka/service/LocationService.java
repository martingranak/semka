package sk.pds.semestralka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.pds.semestralka.mapper.LocationMapper;
import sk.pds.semestralka.model.Location;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationMapper locationMapper;

    public List<Location> findAll() {
        return this.locationMapper.findAll();
    }

    public Location findById(long locationId) {
        return this.locationMapper.findById(locationId);
    }

    public List<Location> findByRide(long rideId) {
        return this.locationMapper.findByRide(rideId);
    }

    @Transactional
    public Location addLocation(long rideId, double latitude, double longtitude, String date) {
        LocalDateTime dateTime = LocalDateTime.parse(date);
        Location location = new Location(rideId, latitude, longtitude, dateTime);
        this.locationMapper.insertLocation(location);
        return location;
    }

    @Transactional
    public void updateLocation(Location location) {
        this.locationMapper.updateLocation(location);
    }

    @Transactional
    public void removeLocation(long locationId) {
        this.locationMapper.deleteLocation(locationId);
    }
}

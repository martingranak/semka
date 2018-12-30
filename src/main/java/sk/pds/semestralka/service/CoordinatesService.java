package sk.pds.semestralka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.pds.semestralka.mapper.CoordinatesMapper;
import sk.pds.semestralka.model.Coordinates;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CoordinatesService {
    @Autowired
    private CoordinatesMapper coordinatesMapper;

    public List<Coordinates> findAll() {
        return this.coordinatesMapper.findAll();
    }

    public Coordinates findById(long coordinatesId) {
        return this.coordinatesMapper.findById(coordinatesId);
    }

    public List<Coordinates> findByRide(long rideId) {
        return this.coordinatesMapper.findByRide(rideId);
    }

    @Transactional
    public Coordinates addCoordinates(long rideId, float latitude, float longtitude, float height, String date) {
        LocalDateTime dateTime = LocalDateTime.parse(date);
        Coordinates coordinates = new Coordinates(rideId, latitude, longtitude, height, dateTime);
        this.coordinatesMapper.insertCoordinates(coordinates);
        return coordinates;
    }

    @Transactional
    public void updateCoordinates(Coordinates coordinates) {
        this.coordinatesMapper.updateCoordinates(coordinates);
    }

    @Transactional
    public void removeCoordinates(long coordinatesId) {
        this.coordinatesMapper.deleteCoordinates(coordinatesId);
    }
}

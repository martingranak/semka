package sk.pds.semestralka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.pds.semestralka.model.Coordinates;
import sk.pds.semestralka.service.CoordinatesService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/coordinates")
public class CoordinatesController {
    @Autowired
    private CoordinatesService coordinatesService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Coordinates> findAll() {
        return this.coordinatesService.findAll();
    }

    @RequestMapping(value = "/one", method = RequestMethod.POST)
    public Coordinates findById(@RequestParam("coordinatesId") long coordinatesId) {
        return this.coordinatesService.findById(coordinatesId);
    }

    @RequestMapping(value = "/ride", method = RequestMethod.POST)
    public List<Coordinates> findByRide(@RequestParam("rideId") long rideId) {
        return this.coordinatesService.findByRide(rideId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Coordinates addCoordinates(@RequestParam("rideId") long rideId, @RequestParam("latitude") float latitude,
                                      @RequestParam("longtitude") float longtitude, @RequestParam("height") float height, @RequestParam("date") String date) {
        return this.coordinatesService.addCoordinates(rideId, latitude, longtitude, height, date);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateCoordinates(@RequestBody Coordinates coordinates) {
        this.coordinatesService.updateCoordinates(coordinates);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void removeCoordinates(@RequestParam("coordinatesId") long coordinatesId) {
        this.coordinatesService.removeCoordinates(coordinatesId);
    }
}

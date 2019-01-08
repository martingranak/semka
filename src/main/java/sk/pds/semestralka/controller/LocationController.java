package sk.pds.semestralka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.pds.semestralka.model.Location;
import sk.pds.semestralka.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "http://localhost:4200")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Location> findAll() {
        return this.locationService.findAll();
    }

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public Location findById(@RequestParam("locationId") long locationId) {
        return this.locationService.findById(locationId);
    }

    @RequestMapping(value = "/ride", method = RequestMethod.POST)
    public List<Location> findByRide(@RequestParam("rideId") long rideId) {
        return this.locationService.findByRide(rideId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Location addLocation(@RequestParam("rideId") long rideId, @RequestParam("latitude") float latitude,
                                   @RequestParam("longitude") float longitude, @RequestParam("date") String date) {
        return this.locationService.addLocation(rideId, latitude, longitude, date);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateLocation(@RequestBody Location location) {
        this.locationService.updateLocation(location);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void removeLocation(@RequestParam("locationId") long locationId) {
        this.locationService.removeLocation(locationId);
    }
}

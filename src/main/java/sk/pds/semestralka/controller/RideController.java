package sk.pds.semestralka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.pds.semestralka.model.Ride;
import sk.pds.semestralka.service.RideService;

import java.util.List;

@RestController
@RequestMapping("/ride")
@CrossOrigin(origins = "http://localhost:4200")
public class RideController {
    @Autowired
    private RideService rideService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Ride> findAllRides() {
        return this.rideService.findAllRides();
    }

    @RequestMapping(value = "/one", method = RequestMethod.POST)
    public Ride findOne(@RequestParam("rideId") long rideId) {
        return this.rideService.findById(rideId);
    }

    @RequestMapping(value = "/driver", method = RequestMethod.POST)
    public List<Ride> findByDriver(@RequestParam("driverId") long driverId) {
        return this.rideService.findByDriver(driverId);
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public List<Ride> findByCar(@RequestParam("carId") long carId) {
        return this.rideService.findByCar(carId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Ride add(@RequestParam("identityNumber") String identityNumber, @RequestParam("carId") long carId,
                    @RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo) {
        return this.rideService.addRide(carId, identityNumber, dateFrom, dateTo);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody Ride ride) {
        this.rideService.updateRide(ride);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void remove(@RequestParam("rideId") long rideId) {
        this.rideService.removeRide(rideId);
    }
}

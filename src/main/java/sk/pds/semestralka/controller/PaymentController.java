package sk.pds.semestralka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.pds.semestralka.model.Payment;
import sk.pds.semestralka.model.PaymentReport;
import sk.pds.semestralka.service.PaymentService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Payment> findAll() {
        return this.paymentService.findAll();
    }

    @RequestMapping(value = "/one", method = RequestMethod.POST)
    public Payment findById(@RequestParam("paymentId") long paymentId) {
        return this.paymentService.findById(paymentId);
    }

    @RequestMapping(value = "/ride", method = RequestMethod.POST)
    public List<Payment> findByRide(@RequestParam("rideId") long rideId) {
        return this.paymentService.findByRide(rideId);
    }

    @RequestMapping(value = "/sum/ride", method = RequestMethod.POST)
    public List<PaymentReport> findSumByRide(@RequestParam("rideId") long rideId) {
        return this.paymentService.findSumByRide(rideId);
    }

    @RequestMapping(value = "/sum/ride-detail", method = RequestMethod.POST)
    public List<PaymentReport> findSumByRideDetail(@RequestParam("rideId") long rideId) {
        return this.paymentService.findSumByRideDetail(rideId);
    }

    @RequestMapping(value = "/description/{description}", method = RequestMethod.GET)
    public List<Payment> findByDescription(@PathVariable("description") String description) {
        return this.paymentService.findByDescription(description);
    }

    @RequestMapping(value = "/sum/description/{description}", method = RequestMethod.GET)
    public List<PaymentReport> findSumByDescription(@PathVariable("description") String description) {
        return this.paymentService.findSumByDescription(description);
    }

    @RequestMapping(value = "/sum/description-detail/{description}", method = RequestMethod.GET)
    public List<PaymentReport> findSumByDescriptionDetail(@PathVariable("description") String description) {
        return this.paymentService.findSumByDescriptionDetail(description);
    }

    @RequestMapping(value = "/report/month/{date}", method = RequestMethod.GET)
    public String findPaymentsOfMonthByDay(@PathVariable("date") String date) {
        return this.paymentService.findPaymentsOfMonthByDay(date);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Payment addPayment(@RequestParam("rideId") long rideId, @RequestParam("value") double value, @RequestParam("description") String description) {
        return this.paymentService.addPayment(rideId, value, description);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updatePayment(@RequestBody Payment payment) {
        this.paymentService.updatePayment(payment);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void removePayment(@RequestParam("paymentId") long paymentId) {
        this.paymentService.removePayment(paymentId);
    }
}

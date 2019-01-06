package sk.pds.semestralka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.pds.semestralka.model.Payment;
import sk.pds.semestralka.service.PaymentService;

import java.util.List;

@RestController
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

    @RequestMapping(value = "/decsription/{description}", method = RequestMethod.GET)
    public List<Payment> findByDescription(@PathVariable("description") String description) {
        return this.paymentService.findByDescription(description);
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

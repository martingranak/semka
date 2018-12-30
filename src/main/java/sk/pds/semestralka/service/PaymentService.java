package sk.pds.semestralka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.pds.semestralka.mapper.PaymentMapper;
import sk.pds.semestralka.model.Payment;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    public List<Payment> findAll() {
        return this.paymentMapper.findAll();
    }

    public Payment findById(long paymentId) {
        return this.paymentMapper.findById(paymentId);
    }

    public List<Payment> findByRide(long rideId) {
        return this.paymentMapper.findByRide(rideId);
    }

    @Transactional
    public Payment addPayment(long rideId,float value, String description) {
        Payment payment = new Payment(rideId, value, description);
        this.paymentMapper.insertPayment(payment);
        return payment;
    }

    @Transactional
    public void updatePayment(Payment payment) {
        this.paymentMapper.updatePayment(payment);
    }

    @Transactional
    public void removePayment(long paymentId) {
        this.paymentMapper.deletePayment(paymentId);
    }
}

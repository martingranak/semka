package sk.pds.semestralka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.pds.semestralka.mapper.PaymentMapper;
import sk.pds.semestralka.model.Payment;
import sk.pds.semestralka.model.PaymentReport;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

    public List<Payment> findByDescription(String description) {
        return this.paymentMapper.findByDescription(description);
    }

    public List<PaymentReport> findSumByRide(long rideId) {
        return this.paymentMapper.findSumByRide(rideId);
    }

    public List<PaymentReport> findSumByRideDetail(long rideId) {
        return this.paymentMapper.findSumByRideDetail(rideId);
    }

    public List<PaymentReport> findSumByDescription(String description) {
        return this.paymentMapper.findSumByDescription(description);
    }

    public List<PaymentReport> findSumByDescriptionDetail(String description) {
        return this.paymentMapper.findSumByDescriptionDetail(description);
    }

    public String findPaymentsOfMonthByDay(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return this.paymentMapper.findPaymentsOfMonthByDay(date);
    }

    @Transactional
    public Payment addPayment(long rideId, double value, String description) {
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

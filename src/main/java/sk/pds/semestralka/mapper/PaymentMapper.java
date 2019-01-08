package sk.pds.semestralka.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sk.pds.semestralka.model.Payment;
import sk.pds.semestralka.model.PaymentReport;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface PaymentMapper {
    List<Payment> findAll();
    Payment findById(@Param("paymentId") long paymentId);
    List<Payment> findByRide(@Param("rideId") long rideId);
    List<PaymentReport> findSumByRide(@Param("rideId") long rideId);
    List<PaymentReport> findSumByDescription(@Param("description") String description);
    List<PaymentReport> findSumByRideDetail(@Param("rideId") long rideId);
    List<PaymentReport> findSumByDescriptionDetail(@Param("description") String description);
    List<Payment> findByDescription(@Param("description") String description);

    String findPaymentsOfMonthByDay(@Param("date") String date);

    void insertPayment(@Param("payment") Payment payment);
    void updatePayment(@Param("payment") Payment payment);
    void deletePayment(@Param("paymentId") long paymentId);
}

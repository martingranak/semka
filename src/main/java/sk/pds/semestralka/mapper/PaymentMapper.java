package sk.pds.semestralka.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sk.pds.semestralka.model.Payment;

import java.util.List;

@Mapper
public interface PaymentMapper {
    List<Payment> findAll();
    Payment findById(@Param("paymentId") long paymentId);
    List<Payment> findByRide(@Param("rideId") long rideId);
    List<Payment> findByDescription(@Param("description") String description);
    void insertPayment(@Param("payment") Payment payment);
    void updatePayment(@Param("payment") Payment payment);
    void deletePayment(@Param("paymentId") long paymentId);
}

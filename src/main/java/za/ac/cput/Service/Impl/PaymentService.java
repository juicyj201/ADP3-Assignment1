package za.ac.cput.Service.Impl;

import za.ac.cput.Domain.Entity.Payment;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Optional;

/**
 * Joshua Julies
 * 220102473
 * The payment service interface
 */

public interface PaymentService extends IService<Payment, String> {
    public Payment save(Payment payment);
    public Optional<Payment> read(String paymentID);
    public List<Payment> readAll();
    public Payment update(Payment payment);
    public void delete(Payment payment);
}

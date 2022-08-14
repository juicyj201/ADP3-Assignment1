package za.ac.cput.Service.Impl;

import za.ac.cput.Domain.Entity.Payment;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Optional;

public interface PaymentService extends IService<Payment, String> {
    public Payment save(Payment payment);
    public Optional<Payment> read(Payment payment);
    public Payment update(Payment payment);
    public void delete(Payment payment);
}

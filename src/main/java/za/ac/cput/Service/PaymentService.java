package za.ac.cput.Service;

import za.ac.cput.Domain.Entity.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService extends IService<Payment, String>{
    public Payment save(Payment payment);
    public Optional<Payment> read(Payment payment);
    public void delete(Payment payment);
    public List<Payment> readAll();
}

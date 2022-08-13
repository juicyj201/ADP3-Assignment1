package za.ac.cput.Service.Impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Entity.Payment;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    private static PaymentService service;

    public static PaymentService getService(){
        if(service == null){
            service = new PaymentServiceImpl();
        }

        return service;
    }

    @Override
    public Payment save(Payment payment) {
        return null;
    }

    @Override
    public Optional<Payment> read(Payment payment) {
        return Optional.empty();
    }

    @Override
    public void delete(Payment payment) {

    }

    @Override
    public List<Payment> readAll() {
        return null;
    }
}

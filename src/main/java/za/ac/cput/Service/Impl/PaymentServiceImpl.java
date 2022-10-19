package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Entity.Payment;
import za.ac.cput.Repository.PaymentRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repo;

    @Autowired
    public PaymentServiceImpl(PaymentRepository repo){
        this.repo = repo;
    }

    @Override
    public Payment save(Payment payment) {
        if(!payment.equals(null)) {
            repo.save(payment);
            System.out.println("Payment saved: ");
            return payment;
        }else{
            System.out.println("Error: Payment not found");
            return null;
        }
    }

    @Override
    public Optional<Payment> read(Long paymentID) {
        if(paymentID == 0) {
            System.out.println("Payment found: ");
            Optional<Payment> readPayment = repo.findById(paymentID.toString());
            return readPayment;
        }else{
            System.out.println("Error: Payment not found.");
            return null;
        }
    }

    @Override
    public Optional<Payment> read(String ID) {
        return Optional.empty();
    }

    @Override
    public List<Payment> readAll() {
        if(repo.count() != 0) {
            List<Payment> pList = repo.findAll();
            System.out.println("Payment list is found");
            return pList;
        }else{
            System.out.println("Payment list not found");
            return null;
        }
    }

    @Override
    public Payment update(Payment payment) {
        if(Collections.emptyList() != repo) {
            List<Payment> pList = repo.findAll();
            Payment paymentUpdate = pList.stream().findAny().get();
            if(paymentUpdate.getPaymentID() == payment.getPaymentID()){
                paymentUpdate.setStudentAccountID(payment.getStudentAccountID());
                paymentUpdate.setPaymentDate(payment.getPaymentDate());
                paymentUpdate.setPaymentAmount(payment.getPaymentAmount());
                repo.save(paymentUpdate);
                System.out.println("Payment updated: ");
                //side note - not necessary to delete the original value in the db,
                //since using put will update the value automatically
            }
            return paymentUpdate;
        }else{
            System.out.println("Error: Payment not found.");
            return null;
        }
    }

    @Override
    public void delete(Payment payment) {
        if(!payment.equals(null)) {
            repo.delete(payment);
            System.out.println("Payment deleted. ");
        }else{
            System.out.println("Error: Payment not found.");
        }
    }
}

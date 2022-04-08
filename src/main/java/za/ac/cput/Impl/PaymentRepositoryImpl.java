package za.ac.cput.Impl;

import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Domain.Entity.Payment;
import za.ac.cput.Repository.IPaymentRepository;
import za.ac.cput.Repository.IRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Joshua Julies
 * 220102473
 * The payment repository implmentation
 */

public class PaymentRepositoryImpl implements IPaymentRepository {
    private static PaymentRepositoryImpl repo = null;
    private Map<String, Payment> paymentDB = null;

    public PaymentRepositoryImpl(){
        paymentDB = new HashMap<String, Payment>();
    }

    public static PaymentRepositoryImpl getRepo(){
        if(repo == null){
            repo = new PaymentRepositoryImpl();
            return repo;
        }else{
            return null;
        }
    }

    @Override
    public Payment create(String id, Payment object) {
        //where id = paymentID & object = payment
        paymentDB.put(id, object);
        if(paymentDB.containsKey(id)){
            return object;
        }
        return null;
    }

    @Override
    public Payment read(String id) {
        for(Payment p : paymentDB.values()){
            if(p.getPaymentID().equals(id)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void update(String id, Payment object) {
        for(Payment p : paymentDB.values()){
            if(p.getPaymentID().equals(id)){
                paymentDB.replace(id, p, object);
            }
        }
    }

    @Override
    public void delete(String id, Payment object) {
        for(Payment p : paymentDB.values()){
            if(p.getPaymentID().equals(id)){
                paymentDB.remove(id, object);
            }
        }
    }

    @Override
    public Map<String, Payment> getAll() {
        return paymentDB;
    }
}

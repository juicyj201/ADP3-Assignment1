package cput.ac.za.Repository;

import cput.ac.za.Domain.Entity.Admin;
import cput.ac.za.Domain.Entity.Payment;

import java.util.Map;

public interface IPaymentRepository extends IRepository<Payment>{
    public Map<String, Payment> getAll();

    @Override
    public Payment create(String id, Payment object);

    @Override
    public Payment read(String id);

    @Override
    public void update(String id, Payment object);

    @Override
    public void delete(String id, Payment object);
}

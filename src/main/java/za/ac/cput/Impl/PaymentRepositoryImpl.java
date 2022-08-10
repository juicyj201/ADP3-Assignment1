package za.ac.cput.Impl;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import za.ac.cput.Domain.Entity.Payment;

public interface PaymentRepositoryImpl extends JpaRepositoryImplementation<Payment, String> {
}
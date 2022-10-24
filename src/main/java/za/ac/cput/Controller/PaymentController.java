package za.ac.cput.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Entity.Payment;
import za.ac.cput.Service.Impl.PaymentServiceImpl;
import za.ac.cput.Service.Impl.PaymentService;
import java.util.List;
import java.util.Optional;

/**
 * Joshua Julies
 * 220102473
 * The payment controller
 */

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService service;
    protected final static Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    public PaymentController(PaymentServiceImpl paymentService){
        this.service = paymentService;
        //side note - controller uses dependency injection for the service object,
        //similarly in the service implementations for the repository objects.
    }

    @PostMapping("/payment")
    public Payment savePayment(@RequestBody Payment payment){
        logger.info("Request has initiated...");
        Payment savedPayment = service.save(payment);
        logger.info("Payment has been saved to the database");
        return savedPayment;
    }

    @GetMapping("/payment/{paymentID}")
    public Optional<Payment> getPaymentByID(@PathVariable Long paymentID){
        logger.info("Service has begun reading payment requested...");
        return service.read(paymentID);
    }

    @GetMapping("/payment")
    public List<Payment> getAllPayment() {
        logger.info("Service has begun reading the payment list requested...");
        return service.readAll();
    }

    @PutMapping("/payment")
    public Payment updatePayment(Payment payment){
        logger.info("Service has begun updating the payment request...");
        Payment updatedPayment = service.update(payment);
        logger.info("Payment "+updatedPayment.getPaymentID()+", has been updated.");
        return updatedPayment;
    }

    @DeleteMapping("/payment")
    public void deletePayment(Payment payment){
        logger.info("Service has begun deletion of payment...");
        service.delete(payment);
        logger.info("Payment "+payment.getPaymentID()+", has been deleted.");
    }

}

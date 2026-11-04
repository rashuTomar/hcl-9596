package org.example;

import org.example.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class `OrderService {

//    @Autowired // field injection (not recommended)
    private PaymentService paymentService;

    @Autowired // Constructor injection(recommended)
    public OrderService(PaymentService paymentService){
        this.paymentService= paymentService;
    }

//    @Autowired // setter injection
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void placeOrder(){

        paymentService.pay();

        System.out.println("order Placed");
    }
}

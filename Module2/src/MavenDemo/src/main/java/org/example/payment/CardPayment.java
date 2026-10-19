package org.example.payment;

import org.springframework.stereotype.Component;

@Component
public class CardPayment implements PaymentService{

    @Override
    public void pay(){
        System.out.println("Paid via Card");
    }
}

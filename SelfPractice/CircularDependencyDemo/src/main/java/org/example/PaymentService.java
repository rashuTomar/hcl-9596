package org.example;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {


    OrderService orderService;
    public PaymentService(OrderService orderService){
        this.orderService= orderService;
    }

    public void pay(){
        System.out.println("payment done");

        orderService.getOrderDetails();
    }
}

package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton") //bydefault scope is always singleton
@Scope("prototype")
public class OrderService {

    public OrderService(){
        System.out.println("OrderService created");
    }

    public void placeOrder(){

        System.out.println("order placed successfully");
    }
}

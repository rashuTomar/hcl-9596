package org.example.setterdi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee emp= ctx.getBean(Employee.class);
        emp.displayAddress();
        ctx.close();
    }
}

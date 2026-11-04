package org.example.constructordi;

public class SingleEmployee {
    int age;

    static  final SingleEmployee obj = new SingleEmployee();   // rule 2 : instance is created during class initialization



    private SingleEmployee() {   // rule 1 : create privte constructor
        System.out.println("single constructor called");

    }
    public  static SingleEmployee getinstance(){   // rule 3 : make instance caller method to acces private constructor

        return obj;
    }

    public void greetMsg(){

        System.out.println("greemsg Fun called");
    }



}

class Singleton{
    private static Singleton obj = new Singleton();

    private Singleton(){
        System.out.println("i am created inside singleton class");
    }
    public static Singleton getInstance(){
        return obj;
    }
}

public class Demo {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1.equals(s2));
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student>{
    String name;
    int marks;

    public Student(String name, int marks){
        this.name= name;
        this.marks= marks;
    }

    @Override 
    public int compareTo(Student other){
        return this.marks- other.marks;
    }

    // @Override
    public String toString() {
        return name + " " + marks;
    }
}

public class ComparableInterface {
    public static void main(String[] args) {
        List<Student> list= new ArrayList<>();
        list.add(new Student("vivek", 99));
        list.add(new Student("shubham", 33));
        list.add(new Student("yash", 99));

        Collections.sort(list);
        System.out.println(list);

    }
}

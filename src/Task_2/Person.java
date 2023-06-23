package Task_2;

public class Person {
    private static String name;
    private static int age;

    public Person( String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }
}

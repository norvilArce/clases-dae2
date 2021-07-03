package pe.isil;

public class App {
    public static void main(String[] args) {

        /*Student student = new Student();
        student.sayHello();

        Teacher teacher = new Teacher();
        teacher.sayHello();*/

        IPerson person = new Teacher();
        person.sayGoodBye();
    }
}

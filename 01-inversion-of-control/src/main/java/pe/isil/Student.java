package pe.isil;

public class Student implements IPerson {
    public void sayHello(){
        System.out.println("Hola, soy un estudiante!");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("Babaiiii");
    }
}

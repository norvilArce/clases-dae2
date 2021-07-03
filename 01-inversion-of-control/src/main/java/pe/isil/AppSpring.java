package pe.isil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = applicationContext.getBean("student", Student.class);
        student.sayHello();

        Teacher teacher = applicationContext.getBean("teacher", Teacher.class);
        teacher.sayHello();

        student.sayGoodBye();
        teacher.sayGoodBye();
    }
}

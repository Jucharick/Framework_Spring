import config.ProjectConfig;
import domain.Car;
import domain.DiselEngin;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Car p = context.getBean(Car.class);
        p.go();
        System.out.println("----------------------");
        DiselEngin dEng = context.getBean(DiselEngin.class);
    }
}

package be.odisee.ti2.groep4.quatraplanning.domain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ProductkeuzeRunner {

    // Autowired is niet mogelijk met static
    public static Productkeuze productkeuze1, productkeuze2;


    @SuppressWarnings("unused")
    private static AnnotationConfigApplicationContext applicationContext;

    /*
    @Autowired
    public ProductkeuzeRunner(Productkeuze productkeuze1, Productkeuze productkeuze2){

        ProductkeuzeRunner.productkeuze1 = productkeuze1;
        ProductkeuzeRunner.productkeuze2 = productkeuze2;
    }



    public static void main(String[] args) {

        applicationContext = new AnnotationConfigApplicationContext(ProductkeuzeConfig.class);


        System.out.println("productkeuze1=" + productkeuze1.getProductkeuze());
        System.out.println("productkeuze2=" + productkeuze2.getProductkeuze());

    }
     */
}

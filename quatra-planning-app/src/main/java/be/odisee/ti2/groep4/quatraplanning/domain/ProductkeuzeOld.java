package be.odisee.ti2.groep4.quatraplanning.domain;

import java.util.Scanner;

// Oude klasse ter demonstratie van het sequentiediagram opdracht 1 (nutteloos)
public class ProductkeuzeOld {
    String keuze;
    Integer aantal;

    public ProductkeuzeOld() {


    }

    public void keuzeProduct(){

        String switchCase;

        Scanner keuze = new Scanner(System.in);

        System.out.println("Gelieve te kiezen tussen: a. Ophalen b. leveren c. Ophalen/leveren ");

        switchCase = keuze.nextLine();

        switch (switchCase){
            case "a": System.out.println("U hebt voor Ophalen gekozen");
                break;
            case "b": System.out.println("U hebt voor leveren gekozen");
                break;
            case "c": System.out.println("U hebt voor beiden gekozen");
                break;
        }

    }


    public void voegProductKeuzeToe() {

    }

    public void veranderAantal() {
    }

    public void verwijderProductKeuze() {
    }

}

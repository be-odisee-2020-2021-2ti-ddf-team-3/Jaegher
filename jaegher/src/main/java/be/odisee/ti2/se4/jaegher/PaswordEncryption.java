package be.odisee.ti2.se4.jaegher;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PaswordEncryption {

    //Deze klassen uitvoeren om in de consolle de encrypted wachtwoorden te krijgen
    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static void main(String[] args) {

        String[] passwords = {"imkeww", "tessaww", "testww","hansww"};

        for (String pwd : passwords ) {
            System.out.printf("%s is {bcrypt}%s%n", pwd, hash(pwd));
        }
    }
}

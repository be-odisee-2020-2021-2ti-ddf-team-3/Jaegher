package be.odisee.ti2.se4.jaegher.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

//Deze klasse steld een entity voor in de DB de variabelen zijn tabelen
@Entity
@Table(name = "KLANT")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Klant {

    @Id
    private final int id;

    private final String naam;

}




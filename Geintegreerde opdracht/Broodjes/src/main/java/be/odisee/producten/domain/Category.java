package be.odisee.producten.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORIEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final long id;

    private String naam;

    public Category(int id, String naam) {
        this.id = id;
        this.naam = naam;
    }
}

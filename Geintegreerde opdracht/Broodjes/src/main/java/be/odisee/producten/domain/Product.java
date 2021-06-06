package be.odisee.producten.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "BROODJES")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final long id;

    @NotEmpty(message="naam van het product is verplicht")
    private String naam;

    private String description;

    @Min(value = 0, message = "Een prijs moet groter dan of gelijk aan 0 zijn")
    private Double prijs;

    private String fotolink;

    @ManyToOne
    private Category category;

}

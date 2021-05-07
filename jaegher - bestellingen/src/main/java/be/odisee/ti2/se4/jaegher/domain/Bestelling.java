package be.odisee.ti2.se4.jaegher.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "BESTELLINGEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Bestelling {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private final long id;
    @NotEmpty(message="verplicht")
    private String naam;
    @NotEmpty(message="verplicht")
    private String aanMaakDatum;
    private Boolean goedgekeurd;

    @Min(value = 1)
    private long klantId;


}

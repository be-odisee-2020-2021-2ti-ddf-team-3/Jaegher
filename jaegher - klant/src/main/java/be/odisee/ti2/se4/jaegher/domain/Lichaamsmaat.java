package be.odisee.ti2.se4.jaegher.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "LICHAAMSMAATEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Lichaamsmaat {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private final long id;

    private Double linkerBeen;

    private Double rechterBeen;

    private Double bekkenkanteling;

    private Double gewicht;

    @Max(value = 220, message = "Maximum groote is 220cm")
    private Double groote;

    private Double linkerArm;

    private Double rechterArm;

}

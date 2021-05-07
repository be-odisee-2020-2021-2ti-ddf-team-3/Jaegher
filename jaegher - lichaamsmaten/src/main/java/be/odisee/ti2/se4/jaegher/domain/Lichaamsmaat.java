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
    private final long Id;
    @Min(value = 0, message = "min 0")
    private Double linkerBeen;
    @Min(value = 0, message = "min 0")
    private Double rechterBeen;
    @Min(value = 0, message = "min 0")
    private Double bekkenkanteling;
    @Min(value = 0, message = "min 0")
    private Double gewicht;
    @Min(value = 0, message = "min 0")
    private Double groote;
    @Min(value = 0, message = "min 0")
    private Double linkerArm;
    @Min(value = 0, message = "min 0")
    private Double rechterArm;



}

package be.odisee.ti2.se4.jaegher.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

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

}

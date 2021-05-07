package be.odisee.ti2.se4.jaegher.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FIETSSAMENSTELLINGEN")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Fietssamenstelling {
    @Id
    private final long id;

    private String status;

    private String casette;

    private String frame;

    private String pedalen;

    private String shifters;

    private String stuur;

}

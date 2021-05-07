package be.odisee.ti2.se4.jaegher.formdata;

import lombok.Data;

import javax.validation.constraints.Max;

@Data
public class EntryDataLichaamsmaat {
    private long Id = 0;

    private Double linkerBeen;

    private Double rechterBeen;

    private Double bekkenkanteling;

    private Double gewicht;

    private Double groote;

    private Double linkerArm;

    private Double rechterArm;
}

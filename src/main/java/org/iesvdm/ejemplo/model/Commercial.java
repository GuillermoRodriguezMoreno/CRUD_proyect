package org.iesvdm.ejemplo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commercial {

    // Attributes
    private int id;
    private String name;
    private String lastname1;
    private String lastname2;
    private BigDecimal commission;
}

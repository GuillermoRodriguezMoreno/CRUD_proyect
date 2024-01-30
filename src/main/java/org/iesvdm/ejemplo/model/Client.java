package org.iesvdm.ejemplo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    // Attributes
    private int id;
    private String name;
    private String lastName1;
    private String lastName2;
    private String city;
    private int category;
    private String email;
}

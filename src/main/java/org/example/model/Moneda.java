package org.example.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Moneda {
    //Especificación de que moneda es
    String nombre;
    //Valor de la moneda
    Double valor;
}

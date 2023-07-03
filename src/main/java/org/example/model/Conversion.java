package org.example.model;

import lombok.Builder;
import lombok.Getter;
import org.example.Main;

@Builder
@Getter
public class Conversion {
    String tipoConversion;
    Moneda valorConversion;

}

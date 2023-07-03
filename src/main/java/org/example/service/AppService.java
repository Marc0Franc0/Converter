package org.example.service;

import org.example.model.Conversion;
import org.example.model.Moneda;

public interface AppService {
    public String mostrarMenuPrincipal();
    public Moneda mostrarEntradaDeValor(String monedaConvertir);
    public String mostrarOpcionesDeConversion(String monedaConvertir);
    public void convertir(Conversion conversion);
    public void mostrarConversion(String resultado, String moneda);


}

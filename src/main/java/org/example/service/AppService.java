package org.example.service;

import org.example.model.Conversion;
import org.example.model.Moneda;

public interface AppService {
    public String mostrarMenuPrincipal();
    public Moneda mostrarEntradaDeValor(String monedaConvertir);
    public int mostrarOpcionesDeConversion(String monedaConvertir);
    public void convertir(Conversion conversion);
    public void mostrarConversion(String resultado, String moneda);
    public int consultarNuevaEjecucion();
    public void finalizarEjecucion();



}

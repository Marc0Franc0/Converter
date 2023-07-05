package org.example.service;

import org.example.model.Conversion;

public interface AppService {
    public String mostrarMenuPrincipal();
    public Double mostrarEntradaDeValor();
    public int mostrarOpcionesDeConversionMonedas();
    public int mostrarOpcionesDeConversionTemperaturas();
    public void convertirMoneda(Conversion conversion);
    public void convertirTemperatura(Conversion conversion);
    public void mostrarConversion(String resultado, String infoUnidadMoneda);
    public int consultarNuevaEjecucion();
    public void finalizarEjecucion();
    public void mostrarMensajeDeError();



}

package org.example.service;

public interface TemperatureConverterService {
    public Double calcularCelcius(double valor,char unidadBase);
    public Double calcularFahrenheit(double valor,char unidadBase);
    public Double calcularKelvin(double valor,char unidadBase);
    public Double convertir(double valor,char unidadBase, char unidadAConvertir);

}

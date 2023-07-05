package org.example.service;

import java.util.HashMap;
import java.util.Map;

public class TemperatureConverterServiceImpl implements TemperatureConverterService {
    private Double resultadoCalculos = 0.0;

    @Override
    public Double calcularCelcius(double valor, char unidadBase) {
        switch (unidadBase) {
            case 'F' -> {
                //ºC = (ºF-32) ÷ 1.8
                resultadoCalculos = (valor - 32) / 1.8;

            }
            case 'K' -> {
                //ºC = K – 273.15
                resultadoCalculos = valor - 273.15;
            }
        }
        return resultadoCalculos;

    }

    @Override
    public Double calcularFahrenheit(double valor, char unidadBase) {
        switch (unidadBase) {
            case 'C' -> {
                //ºF = ºC x 1.8 + 32
                resultadoCalculos = valor * 1.8 +32;
            }
            case 'K' -> {
                //ºF = 1.8(K – 273.15) + 32
                resultadoCalculos = 1.8*(valor-273.15)+32;
            }

        }
        return resultadoCalculos;
    }

    @Override
    public Double calcularKelvin(double valor, char unidadBase) {
        switch (unidadBase) {
            case 'C' -> {
                // K = ºC + 273.15
                resultadoCalculos = valor + 273.15;
            }
            case 'F' -> {
                // K = 5/9 (ºF – 32) + 273.15
                resultadoCalculos = (5/9*(valor-32))+273.15;
            }

        }
        return resultadoCalculos;
    }

    @Override
    public Double convertir(double valor, char unidadBase, char unidadAConvertir) {
        Double resultado = 0.0;
        switch (unidadAConvertir) {
            case 'C' -> resultado = calcularCelcius(valor, unidadBase);
            case 'F' -> resultado = calcularFahrenheit(valor, unidadBase);
            case 'K' -> resultado = calcularKelvin(valor, unidadBase);

        }
        return resultado;
    }
}

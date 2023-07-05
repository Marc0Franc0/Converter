package org.example.service;

import org.example.model.Moneda;

public class CurrencyConverterServiceImpl implements CurrencyConverterService {
    //Valores de la moneda teniendo en cuenta 1 peso argentino
    double valorPesoADolar = 0.0039;
    double valorPesoAEuro = 0.0036;
    double valorPesoALibras =0.003;
    double valorPesoAYen = 0.56;
    double valorPesoAWon = 5.06;
    //Valores de la moneda teniendo el valor de otra moneda a la del peso argentino
    double valorDolarAPeso= 257.98;
    double valorEuroAPeso = 281.54;
    double valorLibrasAPeso =327.53;
    double valorYenAPeso = 1.78;
    double valorWonAPeso = 0.20;

    @Override
    public Double convertirPesoADolar(Double valor) {
        double resultado = valor* valorPesoADolar;
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirPesoAEuro(Double valor) {
        double resultado = valor* valorPesoAEuro;
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirPesoAlibras(Double valor) {

        double resultado = valor * valorPesoALibras;
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirPesoAYen(Double valor) {
        double resultado = valor* valorPesoAYen;
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirPesoAWonCoreano(Double valor) {
        double resultado = valor* valorPesoAWon;
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirDolarAPeso(Double valor) {
        double resultado = valor* valorDolarAPeso;
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirEuroAPeso(Double valor) {
        double resultado = valor* valorEuroAPeso;
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirlibrasAPeso(Double valor) {
        double resultado = valor* valorLibrasAPeso;
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirYenAPeso(Double valor) {
        double resultado = valor* valorYenAPeso;
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirWonCoreanoAPeso(Double valor) {
        double resultado = valor* valorWonAPeso;
        return (double)Math.round(resultado) ;
    }
}

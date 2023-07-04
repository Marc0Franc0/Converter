package org.example.service;

import org.example.model.Moneda;

public class CurrencyConverterServiceImpl implements CurrencyConverterService {
    //Valores de la moneda teniendo en cuenta 1 peso argentino
    double valorPesoADolar = 0.0039;
    double valorPesoAEuro = 0.0036;
    double valorPesoALibras =0.0031;
    double valorPesoAYen = 0.56;
    double valorPesoAWon = 5.06;
    //Valores de la moneda teniendo el valor de otra moneda a la del peso argentino
    double valorDolarAPeso= 257.98;
    double valorEuroAPeso = 281.54;
    double valorLibrasAPeso =327.53;
    double valorYenAPeso = 1.78;
    double valorWonAPeso = 0.20;
    //Se utiliza para la conversion de pesos a otra moneda
    Moneda[] valoresAOtrasMonedas = {
            Moneda.builder().nombre("Dólar").valor(valorPesoADolar).build(),
            Moneda.builder().nombre("Euro").valor(valorPesoAEuro).build(),
            Moneda.builder().nombre("Libra").valor(valorPesoALibras).build(),
            Moneda.builder().nombre("Yen").valor(valorPesoAYen).build(),
            Moneda.builder().nombre("Won Coreano").valor(valorPesoAWon).build()
    };
    //Se utiliza para la conversion de otra moneda a pesos
    Moneda[] valoresAPesoArgentino = {
            Moneda.builder().nombre("Dólar").valor(valorDolarAPeso).build(),
            Moneda.builder().nombre("Euro").valor(valorEuroAPeso).build(),
            Moneda.builder().nombre("Libra").valor(valorLibrasAPeso).build(),
            Moneda.builder().nombre("Yen").valor(valorYenAPeso).build(),
            Moneda.builder().nombre("Won Coreano").valor(valorWonAPeso).build()
    };
    @Override
    public Double convertirPesoADolar(Double valor) {
        return valor* valoresAOtrasMonedas[0].getValor();
    }

    @Override
    public Double convertirPesoAEuro(Double valor) {
        double resultado = valor* valoresAOtrasMonedas[1].getValor();
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirPesoAlibras(Double valor) {

        double resultado =  valoresAOtrasMonedas[2].getValor();
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirPesoAYen(Double valor) {
        double resultado = valor* valoresAOtrasMonedas[3].getValor();
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirPesoAWonCoreano(Double valor) {
        double resultado = valor* valoresAOtrasMonedas[4].getValor();
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirDolarAPeso(Double valor) {
        double resultado = valor* valoresAPesoArgentino[0].getValor();
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirEuroAPeso(Double valor) {
        double resultado = valor* valoresAPesoArgentino[1].getValor();
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirlibrasAPeso(Double valor) {
        double resultado = valor* valoresAPesoArgentino[2].getValor();
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirYenAPeso(Double valor) {
        double resultado = valor* valoresAPesoArgentino[3].getValor();
        return (double)Math.round(resultado) ;
    }

    @Override
    public Double convertirWonCoreanoAPeso(Double valor) {
        double resultado = valor* valoresAPesoArgentino[4].getValor();
        return (double)Math.round(resultado) ;
    }
}

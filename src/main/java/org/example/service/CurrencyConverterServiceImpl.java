package org.example.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyConverterServiceImpl implements CurrencyConverterService {
    //Valores de la moneda teniendo en cuenta 1 peso argentino
    double valorPesoADolar;
    double valorPesoAEuro;
    double valorPesoALibras;
    double valorPesoAYen;
    double valorPesoAWon;
    //Valores de la moneda teniendo el valor de otra moneda a la del peso argentino
    double valorDolarAPeso = 257.98;
    double valorEuroAPeso = 281.54;
    double valorLibrasAPeso = 327.53;
    double valorYenAPeso = 1.78;
    double valorWonAPeso = 0.20;

    public CurrencyConverterServiceImpl() {
        this.valorPesoADolar = consultarApi("ARS", "USD");
        this.valorPesoAEuro = consultarApi("ARS", "EUR");
        this.valorPesoALibras = consultarApi("ARS", "GBP");
        this.valorPesoAYen = consultarApi("ARS", "JPY");
        this.valorPesoAWon = consultarApi("ARS", "KRW");
        this.valorDolarAPeso = consultarApi("USD", "ARS");
        this.valorEuroAPeso = consultarApi("EUR", "ARS");
        this.valorLibrasAPeso = consultarApi("GBP", "ARS");
        this.valorYenAPeso = consultarApi("JPY", "ARS");
        this.valorWonAPeso = consultarApi("KRW", "ARS");
    }

    @Override
    public Double convertirPesoADolar(Double valor) {
        double resultado = valor * valorPesoADolar;
         return (double) Math.round(resultado * 100d) / 100d;
    }

    @Override
    public Double convertirPesoAEuro(Double valor) {
        double resultado = valor * valorPesoAEuro;
        return (double) Math.round(resultado * 100d) / 100d;
    }

    @Override
    public Double convertirPesoAlibras(Double valor) {

        double resultado = valor * valorPesoALibras;
        return (double) Math.round(resultado * 100d) / 100d;
    }

    @Override
    public Double convertirPesoAYen(Double valor) {
        double resultado = valor * valorPesoAYen;
        return (double) Math.round(resultado * 100d) / 100d;
    }

    @Override
    public Double convertirPesoAWonCoreano(Double valor) {
        double resultado = valor * valorPesoAWon;
        return (double) Math.round(resultado * 100d) / 100d;
    }

    @Override
    public Double convertirDolarAPeso(Double valor) {
        double resultado = valor * valorDolarAPeso;
        return (double) Math.round(resultado * 100d) / 100d;
    }

    @Override
    public Double convertirEuroAPeso(Double valor) {
        double resultado = valor * valorEuroAPeso;
        return (double) Math.round(resultado * 100d) / 100d;
    }

    @Override
    public Double convertirlibrasAPeso(Double valor) {
        double resultado = valor * valorLibrasAPeso;
        return (double) Math.round(resultado * 100d) / 100d;
    }

    @Override
    public Double convertirYenAPeso(Double valor) {
        double resultado = valor * valorYenAPeso;
        return (double) Math.round(resultado * 100d) / 100d;
    }

    @Override
    public Double convertirWonCoreanoAPeso(Double valor) {
        double resultado = valor * valorWonAPeso;
        return (double) Math.round(resultado * 100d) / 100d;
    }
/*Este  método se utiliza para consultar una api la cual permite convertir divisas,
y se convierte el valor de una moneda base a la moneda a convertir
*  */

    @Override
    public double consultarApi(String monedaBase, String monedaAConvertir) {
        String accessKey= "a3bb6fb7956f88bd6141c060";
        try {
            String baseUrl  = "https://v6.exchangerate-api.com/v6/";
            // Se setea la url
            String url_str = baseUrl+accessKey+"/pair/"+monedaBase+"/"+monedaAConvertir+"/1";

            // Se realiza la peticion
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Conversion a JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Acceso aobjeto
            JsonElement response = jsonobj.get("conversion_result");

            //Se retorna la conversion
            return response.getAsDouble();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0.0;

    }
}

package org.example.service;

import org.example.Main;
import org.example.model.Conversion;

import javax.swing.*;
import java.util.Arrays;

public class AppServiceImpl implements AppService {
    private CurrencyConverterService serviceConversionesMoneda = new CurrencyConverterServiceImpl();
    private TemperatureConverterService serviceConversionesTemperatura= new TemperatureConverterServiceImpl();
    private  String[] conversores = { "Conversor de Moneda", "Conversor de Temperatura" };
   private  String[] conversionesMonedas = {
           Main.monedaConvertir +" a Dólar",
           Main.monedaConvertir +" a Euro",
           Main.monedaConvertir+ " a Libras",
           Main.monedaConvertir+ " a Yen",
           Main.monedaConvertir+ " a Won Coreano",
           "Dólar a "+Main.monedaConvertir,
           "Euro a "+Main.monedaConvertir,
           "Libras a "+Main.monedaConvertir,
           "Yen a "+Main.monedaConvertir,
           "Won Coreano a "+Main.monedaConvertir

   };

    private  String[] conversionesTemperaturas = {
            "Celcius (C) a grados Fahrenheit (F)",
            "Celcius (C) a grados Kelvin (K)",
            "Fahrenheit (F) a grados Celcius (C)",
            "Fahrenheit (F) a grados Kelvin (K)",
            "Kelvin (K) a grados Celcius (C)",
            "Kelvin (K) a grados Fahrenheit (F)",
    };

    private JOptionPane jOptionPane = new JOptionPane();
    @Override
    public String mostrarMenuPrincipal() {
       return
                jOptionPane.showInputDialog
                        (null,
                                "Elija uno","Challenge Conversor",
                                JOptionPane.INFORMATION_MESSAGE,null
                                ,conversores,conversores[0]).toString();

    }

    @Override
    public Double mostrarEntradaDeValor() {
        /*Se solicita la entrada de un valor númerico ,se castea a un tipo double y se le
        asigna el valor a la moneda retornada
         */
        return Double.parseDouble(jOptionPane.showInputDialog
                (null,
                        "Ingrese la cantidad de dinero que deseas convertir",
                        "Input",
                        JOptionPane.INFORMATION_MESSAGE).toString());


    }

    @Override
    public int mostrarOpcionesDeConversionMonedas() {
         String seleccion =
                jOptionPane.showInputDialog
                        (null,
                                "Elija la moneda a la que deseas convertir tu dinero",
                                "Monedas",
                                JOptionPane.INFORMATION_MESSAGE,null
                                , conversionesMonedas, conversionesMonedas[0]).toString();
        return Arrays.asList(conversionesMonedas).indexOf(seleccion);

    }

    @Override
    public int mostrarOpcionesDeConversionTemperaturas() {
        String seleccion =
                jOptionPane.showInputDialog
                        (null,
                                "Elija la moneda a la que deseas convertir tu dinero",
                                "Monedas",
                                JOptionPane.INFORMATION_MESSAGE,null
                                , conversionesTemperaturas, conversionesTemperaturas[0]).toString();
        return Arrays.asList(conversionesTemperaturas).indexOf(seleccion);
    }

    @Override
    public void convertirTemperatura(Conversion conversion) {
        //Se obtiene el valor ingresado por el usuario el cual va ser convertido a otro valor de otra unidad
        Double valorAconvertir = conversion.getValorConversion();
        //Se obtiene el tipo de conversión
        int tipoConversion = conversion.getTipoConversion();

        switch (tipoConversion){
            case 0 ->{
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesTemperatura
                        .convertir(valorAconvertir,'C','F')
                        .toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"grados Fahrenheit");
            }
            case 1 ->{
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesTemperatura
                        .convertir(valorAconvertir,'C','K')
                        .toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"grados Kelvin");
            }
            case 2 ->{
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesTemperatura
                        .convertir(valorAconvertir,'F','C')
                        .toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"grados Celsius");
            }
            case 3 ->{
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesTemperatura
                        .convertir(valorAconvertir,'F','K')
                        .toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"grados Kelvin");
            }
            case 4 ->{
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesTemperatura
                        .convertir(valorAconvertir,'K','C')
                        .toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"grados Celsius");
            }
            case 5 ->{
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesTemperatura
                        .convertir(valorAconvertir,'K','F')
                        .toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"grados Fahrenheit");
            }

        }


    }

    @Override
    public void convertirMoneda(Conversion conversion) {
        //Se obtiene el valor ingresado por el usuario el cual va ser convertido a otra moneda
        Double valorAconvertir = conversion.getValorConversion();
        //Se obtiene el tipo de conversión
        int tipoConversion = conversion.getTipoConversion();

        switch (tipoConversion){
            case 0 ->{
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesMoneda.convertirPesoADolar(valorAconvertir).toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"dolares");
            }
            case 1 ->{
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesMoneda.convertirPesoAEuro(valorAconvertir).toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"euros");
            }
            case 2 ->{
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesMoneda.convertirPesoAlibras(valorAconvertir).toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"libras");
            }
            case 3 ->{
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesMoneda.convertirPesoAYen(valorAconvertir).toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"yenes");
            }
            case 4 ->{
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesMoneda.convertirPesoAWonCoreano(valorAconvertir).toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"wones");
            }
            case 5 ->{
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesMoneda.convertirDolarAPeso(valorAconvertir).toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"pesos argentinos");
            }
            case 6 ->{
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesMoneda.convertirEuroAPeso(valorAconvertir).toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"pesos argentinos");
            }
            case 7 ->{
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesMoneda.convertirlibrasAPeso(valorAconvertir).toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"pesos argentinos");
            }
            case 8 ->{
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesMoneda.convertirYenAPeso(valorAconvertir).toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"pesos argentinos");
            }
            case 9 -> {
                //LLamado al método para convertir el valor
                String resultado = serviceConversionesMoneda.convertirWonCoreanoAPeso(valorAconvertir).toString();
                //LLamado al método para mostrar el resultado
                mostrarConversion(resultado,"pesos argentinos");
            }
        }
    }

    @Override
    //LUego de convertir el valor se muestra con el siguiente método
    public void mostrarConversion(String resultado,String infoUnidadMoneda) {
        jOptionPane.showMessageDialog(null,
                "Tienes "+resultado+" "+infoUnidadMoneda,"Resultado de conversión",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void finalizarEjecucion() {
        jOptionPane.showMessageDialog(null,
                "Programa terminado ","Message",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarMensajeDeError() {
        jOptionPane.showMessageDialog(null,
                "Valor ingresado no válido", "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public int consultarNuevaEjecucion(){
        return JOptionPane.showConfirmDialog(null, "¿Desea continuar?");
    }

}

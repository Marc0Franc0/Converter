package org.example.service;

import org.example.Main;
import org.example.model.Conversion;
import org.example.model.Moneda;
import javax.swing.*;

public class AppServiceImpl implements AppService {
    private ConversionesService serviceConversiones = new ConversionesServiceImpl();
    private  String[] conversores = { "Conversor de Moneda", "Conversor de Temperatura" };
   private  String[] tiposConversiones = {
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
    public Moneda mostrarEntradaDeValor(String monedaConvertir) {
        /*Se solicita la entrada de un valor númerico ,se castea a un tipo double y se le
        asigna el valor a la moneda retornada
         */
       Double valorIngresado= Double.parseDouble(jOptionPane.showInputDialog
                (null,
                        "Ingrese la cantidad de dinero que deseas convertir",
                        "Input",
                        JOptionPane.INFORMATION_MESSAGE).toString());
         return Moneda.builder()
                 .nombre(monedaConvertir)
                         .valor(valorIngresado).build();

    }

    @Override
    public String mostrarOpcionesDeConversion(String monedaConvertir) {
         return
                jOptionPane.showInputDialog
                        (null,
                                "Elija la moneda a la que deseas convertir tu dinero",
                                "Monedas",
                                JOptionPane.INFORMATION_MESSAGE,null
                                ,tiposConversiones,tiposConversiones[0]).toString();
    }

    @Override
    public void convertir(Conversion conversion) {
        //Se obtiene el valor ingresado por el usuario el cual va ser convertido a otro valor de otra moneda
        Double valorAconvertir = conversion.getValorConversion().getValor();
        //Se obtiene el tipo de conversión
        String tipoConversion = conversion.getTipoConversion();

        //Conversión de pesos a dólar
          if(tipoConversion.equals(tiposConversiones[0])){
              //LLamado al método para convertir el valor
              String resultado = serviceConversiones.convertirPesoADolar(valorAconvertir).toString();
              //LLamado al método para mostrar el resultado
              mostrarConversion(resultado,"dolares");
          }
          //Conversión de pesos a euros
          else if (tipoConversion.equals(tiposConversiones[1])) {
              //LLamado al método para convertir el valor
              String resultado = serviceConversiones.convertirPesoAEuro(valorAconvertir).toString();
              //LLamado al método para mostrar el resultado
              mostrarConversion(resultado,"euros");
          }
          //Conversión de pesos a libras
          else if (tipoConversion.equals(tiposConversiones[2])) {
              //LLamado al método para convertir el valor
              String resultado = serviceConversiones.convertirPesoAlibras(valorAconvertir).toString();
              //LLamado al método para mostrar el resultado
              mostrarConversion(resultado,"libras");
          }
          //Conversión de pesos a yen
          else if (tipoConversion.equals(tiposConversiones[3])) {
              //LLamado al método para convertir el valor
              String resultado = serviceConversiones.convertirPesoAYen(valorAconvertir).toString();
              //LLamado al método para mostrar el resultado
              mostrarConversion(resultado,"yenes");
          }
          //Conversión de pesos a won coreano
          else if (tipoConversion.equals(tiposConversiones[4])) {
              //LLamado al método para convertir el valor
              String resultado = serviceConversiones.convertirPesoAWonCoreano(valorAconvertir).toString();
              //LLamado al método para mostrar el resultado
              mostrarConversion(resultado,"wones");
          }
          //Conversión de dolar a pesos
          else if (tipoConversion.equals(tiposConversiones[5])) {
              //LLamado al método para convertir el valor
              String resultado = serviceConversiones.convertirDolarAPeso(valorAconvertir).toString();
              //LLamado al método para mostrar el resultado
              mostrarConversion(resultado,"pesos argentinos");
          }
          //Conversión de euro a pesos
          else if (tipoConversion.equals(tiposConversiones[6])) {
              //LLamado al método para convertir el valor
              String resultado = serviceConversiones.convertirEuroAPeso(valorAconvertir).toString();
              //LLamado al método para mostrar el resultado
              mostrarConversion(resultado,"pesos argentinos");
          }
          //Conversión de libras a pesos
          else if (tipoConversion.equals(tiposConversiones[7])) {
              //LLamado al método para convertir el valor
              String resultado = serviceConversiones.convertirlibrasAPeso(valorAconvertir).toString();
              //LLamado al método para mostrar el resultado
              mostrarConversion(resultado,"pesos argentinos");
          }
          //Conversión de yen a pesos
          else if (tipoConversion.equals(tiposConversiones[8])) {
              //LLamado al método para convertir el valor
              String resultado = serviceConversiones.convertirYenAPeso(valorAconvertir).toString();
              //LLamado al método para mostrar el resultado
              mostrarConversion(resultado,"pesos argentinos");
          }
          //Conversión de won coreano a pesos
          else {
              //LLamado al método para convertir el valor
              String resultado = serviceConversiones.convertirWonCoreanoAPeso(valorAconvertir).toString();
              //LLamado al método para mostrar el resultado
              mostrarConversion(resultado,"pesos argentinos");
          }


    }

    @Override
    //LUego de convertir el valor se muestra con el siguiente método
    public void mostrarConversion(String resultado,String moneda) {
        jOptionPane.showMessageDialog(null,
                "Tienes "+resultado+" "+moneda,"Resultado de conversión",
                JOptionPane.INFORMATION_MESSAGE);
    }


}

package org.example;

import org.example.model.Conversion;
import org.example.model.Moneda;
import org.example.service.AppService;
import org.example.service.AppServiceImpl;
import javax.swing.*;

public class Main {
    public static String monedaConvertir = "Peso Argentino-ARS";
   private static AppService service = new AppServiceImpl();
    private static JOptionPane jOptionPane = new JOptionPane();
    public static void main(String[] args) {

        //Se almacena la selección del conversor que el usuario elige
        String seleccionConversor = service.mostrarMenuPrincipal();
        /*Se verifica si la selección contiene "MONEDA" refiriendose al conversor de moneda
        * y en el caso de contener esa palabra se llega al caso de que es el conversor de monedas
        * */
    if(seleccionConversor.toUpperCase().contains("MONEDA")){

    ejecutarConversorMoneda();
    }else{
        System.out.println("No es el conversor de moneda");
    }


        }
    private static void ejecutarConversorMoneda() {
        try {
            //Se solicita al usuario que ingrese el valor a convertir en pesos argentinos
            Moneda valorConversion = service.mostrarEntradaDeValor("Peso argentino-ARS");
            //Se muetran los diferentes tipos de conversion
            String tipoConversion = service.mostrarOpcionesDeConversion(monedaConvertir);
            //Se realiza la conversión y se muestra el resultado
            service.convertir(Conversion.builder()
                    .tipoConversion(tipoConversion)
                    .valorConversion(valorConversion)
                    .build());

        } catch (Exception e) {
            e.printStackTrace();
            jOptionPane.showMessageDialog(null,
                    "Valor ingresado no válido", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
}
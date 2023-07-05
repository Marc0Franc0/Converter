package org.example;

import org.example.model.Conversion;
import org.example.service.AppService;
import org.example.service.AppServiceImpl;

public class Main {
    public static String monedaConvertir = "Peso Argentino-ARS";
   private static AppService service = new AppServiceImpl();
    public static void main(String[] args) {

        //Se almacena la selección del conversor que el usuario elige
        String seleccionConversor = service.mostrarMenuPrincipal();
        /*Se verifica si la selección contiene "MONEDA" refiriendose al conversor de moneda
        * y en el caso de contener esa palabra se llega al caso de que es el conversor de monedas
        * */
        if(seleccionConversor.toUpperCase().contains("MONEDA")){
             ejecutarConversorMoneda();
        }else{
            ejecutarConversorTemperatura();
        }


        }
    private static void ejecutarConversorMoneda() {
        try {
            //Se solicita al usuario que ingrese el valor a convertir en pesos argentinos
            Double valorConversion = service.mostrarEntradaDeValor();
            //Se muetran los diferentes tipos de conversion
            int tipoConversion = service.mostrarOpcionesDeConversionMonedas();
            //Se realiza la conversión y se muestra el resultado
            service.convertirMoneda(Conversion.builder()
                    .tipoConversion(tipoConversion)
                    .valorConversion(valorConversion)
                    .build());
            //Se consulta al usuario si desea continuar
            int finalizar = service.consultarNuevaEjecucion();
            //Diferentes llamados a metodos de acuerdo a la eleccion de continuar o no
            switch (finalizar){
                case 0 -> main(null);
                default-> service.finalizarEjecucion();
            }

        } catch (Exception e) {
            service.mostrarMensajeDeError();
            e.printStackTrace();

        }
    }

    private static void ejecutarConversorTemperatura() {
        try {
            //Se solicita al usuario que ingrese el valor a convertir en pesos argentinos
            Double valorConversion = service.mostrarEntradaDeValor();
            //Se muetran los diferentes tipos de conversion
            int tipoConversion = service.mostrarOpcionesDeConversionTemperaturas();
            //Se realiza la conversión y se muestra el resultado
            service.convertirTemperatura(Conversion.builder()
                    .tipoConversion(tipoConversion)
                    .valorConversion(valorConversion)
                    .build());
            //Se consulta al usuario si desea continuar
            int finalizar = service.consultarNuevaEjecucion();
            //Diferentes llamados a metodos de acuerdo a la eleccion de continuar o no
            switch (finalizar){
                case 0 -> main(null);
                default-> service.finalizarEjecucion();
            }

        } catch (Exception e) {
            service.mostrarMensajeDeError();
            e.printStackTrace();

        }
    }


}
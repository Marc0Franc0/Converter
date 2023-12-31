# [Converter](https://github.com/Marc0Franc0/Converter#Converter)
Proyecto para realizar la conversión de una moneda local (en este caso se utiliza el peso argentino) a otras o viceversa y para la conversion de unidades de temperatura.

## Características
- Conversión de divisas
- Conversion de unidades de temperatura

## Tecnologías
- Java
- Maven
- Lombok

## Ejecución
1. Clonar repositorio: git clone https://github.com/Marc0Franc0/Converter.git
2. Ir al directorio del proyecto: cd Converter
3. Seguir pasos para ejecución con Maven

## Requerimientos para ejecutar con Maven

Para construir y ejecutar la aplicación necesita:

- [JDK 20+](https://www.oracle.com/java/technologies/downloads/#java20)
- [Maven 3+](https://maven.apache.org)

Ejecución en maquina local

```shell
mvn clean install package
```

```shell
cd target
```

```shell
 java -jar Converter-1.0.0.jar
```

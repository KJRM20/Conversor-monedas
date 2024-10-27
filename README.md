# 💵 Conversor de Divisas
[![language](https://img.shields.io/badge/language-Java-f89b24)](#)
[![GitHub last commit](https://img.shields.io/github/last-commit/KJRM20/Conversor-monedas)](#)

Este proyecto es una aplicación de consola en Java para realizar conversiones de divisas de forma rápida y sencilla. La aplicación permite convertir montos entre varias monedas predeterminadas o seleccionar otras monedas de origen y destino según las necesidades del usuario. También cuenta con un historial de conversiones y una funcionalidad para revisar las tasas de cambio actuales.

## 📋 Tabla de Contenidos
- [Características](#características)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Estructura del Proyecto](#estructura-del-proyecto)

## 💡 Características

- Conversión rápida entre monedas predeterminadas:
  - USD ↔️ ARS
  - USD ↔️ BRL
  - USD ↔️ COP
- Conversión personalizada entre cualquier par de monedas.
- Historial de conversiones para revisión y seguimiento.
- Consulta de tasas de cambio actualizadas.
  
## ⚙️ Requisitos

- Java 11 o superior.
- Editor de texto o IDE compatible con Java (por ejemplo, IntelliJ IDEA, Eclipse, VS Code con extensiones de Java).
- Biblioteca de código abierto [GSON](https://mvnrepository.com/artifact/com.google.code.gson/gson) como dependencia del proyecto.

## ⬇️ Instalación

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/tu_usuario/conversor-de-divisas.git
   cd conversor-de-divisas
   ```
2. **Compilar el proyecto:**
   Desde el terminal, compila el código fuente:
   ```bash
   javac src/*.java -d bin
   ```
3. **Ejecutar la aplicación:**
   ```bash
   java -cp bin Principal
   ```

## 👩‍💻 Uso

Al iniciar la aplicación, se te presentarán varias opciones en un menú principal:

1. **Calcular Tasa de Cambio:** selecciona la moneda de origen y destino entre opciones predefinidas o ingresa tus monedas preferidas.
2. **Historial de Conversiones:** muestra las conversiones realizadas durante la sesión actual.
3. **Consultar Tasa de Cambio de Moneda:** permite revisar la tasa de cambio de una moneda específica.
4. **Salir:** cierra la aplicación.

## 🔍 Ejemplo de Conversión

1. Selecciona la opción ```Calcular Tasa de Cambio```.
2. Selecciona una de las conversiones predeterminadas o ingresa tus monedas personalizadas.
3. Ingresa la cantidad que deseas convertir.
4. La aplicación mostrará el resultado de la conversión y lo añadirá al historial.

## ⌨️ Estructura del Proyecto

La estructura del proyecto es la siguiente:
```text
├── src
│   ├── api
│   │    └── ConsultarMoneda.java        # Clase que maneja el consumo de la Api (Exchangerate-API)
│   ├── calculos  
│   │    ├── CalculadoraTasaDeCambio.java        # Clase que maneja el cálculo de tasas de cambio
│   │    └── FiltroTasaCambio.java        # Clase que filtra las tasas de cambio de la moneda
│   ├── modelos
│   │    ├── Conversion.java        # Clase que contiene los detalles de cada conversión realizada
│   │    └── Moneda.java        # Clase que contiene los detalles de cada moneda
│   └── Principal.java          # Clase principal que ejecuta el menú principal      
└── README.md
```

- ```Principal.java```: controla la navegación de la aplicación y las opciones del menú.
- ```ConsultarMoneda.java```: maneja el consumo de la api e instancia la respuesta obtenida en la clase Moneda.
- ```Moneda.java```: define las propiedades de una moneda y permite acceder a su tasa de cambio actual.
- ```Conversion.java```: define los atributos de cada conversión (moneda origen, destino, cantidad, resultado).
- ```FiltroTasaCambio.java```: contiene la lógica principal para filtrar tasas de cambio de la moneda.
- ```CalculadoraTasaDeCambio.java```: contiene los métodos para calcular la conversión en base a las tasas de cambio.

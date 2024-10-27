import java.util.Scanner;
import api.ConsultarMoneda;
import calculos.CalculadoraTasaDeCambio;
import modelos.Conversion;
import modelos.Moneda;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    private final ConsultarMoneda consultarMoneda;
    private final CalculadoraTasaDeCambio calculadora;
    private final List<Conversion> historialConversiones;
    private final Scanner entrada;

    public Principal() {
        this.consultarMoneda = new ConsultarMoneda();
        this.calculadora = new CalculadoraTasaDeCambio();
        this.historialConversiones = new ArrayList<>();
        this.entrada = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.mostrarMenuPrincipal();
    }

    private void mostrarMenuPrincipal() {
        System.out.println("\n**************************************************************");
        System.out.println("**          Bienvenido(a) al conversor de moneda!           **");
        System.out.println("**************************************************************");

        while (true) {
            System.out.println("\n**-------------------------- Menú --------------------------**");
            System.out.println("1). Calcular tasa de cambio.");
            System.out.println("2). Consultar historial de conversiones.");
            System.out.println("0). Salir.");
            System.out.println("**----------------------------------------------------------**");
            System.out.print("\nIngrese la opción deseada: ");

            int opcion = obtenerOpcionUsuario();

            switch (opcion) {
                case 0 -> {
                    System.out.println("Finalizando proceso...");
                    return;
                }
                case 1 -> manejarConversion();
                case 2 -> mostrarHistorial();
                default -> System.out.println("\nOpción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private int obtenerOpcionUsuario() {
        while (!entrada.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            entrada.next(); // Descartar la entrada no válida
        }
        return entrada.nextInt();
    }

    private void manejarConversion() {
        System.out.println("\n**************************************************************");
        System.out.println("**                  Calcular Tasa de Cambio                 **");
        System.out.println("**************************************************************\n");

        String[] monedasSeleccionadas = seleccionarMoneda();
        if (monedasSeleccionadas == null) {
            System.out.println("\nConversión cancelada. Selección de monedas inválida.");
            return;
        }

        String monedaInicial = monedasSeleccionadas[0];
        String monedaDestino = monedasSeleccionadas[1];

        System.out.print("Ingrese la cantidad a convertir: ");
        double cantidad = obtenerCantidad();

        Moneda moneda = consultarMoneda.obtenerMoneda(monedaInicial);

        if (moneda != null) {
            double resultado = calculadora.calcularTasaDeCambio(cantidad, moneda, monedaDestino);
            Conversion conversion = new Conversion(monedaInicial, monedaDestino, cantidad, resultado);
            historialConversiones.add(conversion);
            System.out.printf("\nResultado: %.2f %s → %.2f %s\n", cantidad, monedaInicial, resultado, monedaDestino);
        } else {
            System.out.println("\nNo se pudo obtener la tasa de cambio para la moneda solicitada.");
        }
    }

    private String[] seleccionarMoneda() {
        System.out.println("Seleccione la conversión deseada:");
        System.out.println("1). Dólar (USD)           →   Peso Argentino (ARS)");
        System.out.println("2). Peso Argentino (ARS)  →   Dólar (USD)");
        System.out.println("3). Dólar (USD)           →   Real Brasileño (BRL)");
        System.out.println("4). Real Brasileño (BRL)  →   Dólar (USD)");
        System.out.println("5). Dólar (USD)           →   Peso Colombiano (COP)");
        System.out.println("6). Peso Colombiano (COP) →   Dólar (USD)");
        System.out.println("9). Otra opción (personalizada).");
        System.out.print("\nIngrese la opción correspondiente: ");

        int opcion = obtenerOpcionUsuario();

        return switch (opcion) {
            case 1 -> new String[] {"USD", "ARS"};
            case 2 -> new String[] {"ARS", "USD"};
            case 3 -> new String[] {"USD", "BRL"};
            case 4 -> new String[] {"BRL", "USD"};
            case 5 -> new String[] {"USD", "COP"};
            case 6 -> new String[] {"COP", "USD"};
            case 9 -> {
                System.out.print("Ingrese la moneda de origen (ej. USD): ");
                String origen = entrada.next().toUpperCase();
                System.out.print("Ingrese la moneda de destino (ej. EUR): ");
                String destino = entrada.next().toUpperCase();
                yield new String[] {origen, destino};
            }
            default -> {
                System.out.println("Opción no válida.");
                yield null;
            }
        };
    }

    private double obtenerCantidad() {
        while (!entrada.hasNextDouble()) {
            System.out.println("Por favor, ingrese una cantidad numérica válida.");
            entrada.next(); // Descartar la entrada no válida
        }
        return entrada.nextDouble();
    }

    private void mostrarHistorial() {
        System.out.println("\n**************************************************************");
        System.out.println("**                Historial de conversiones                 **");
        System.out.println("**************************************************************\n");

        if (historialConversiones.isEmpty()) {
            System.out.println("No hay consultas existentes.");
            return;
        }

        for (int i = 0; i < historialConversiones.size(); i++) {
            System.out.printf("[%d]. %s\n", i + 1, historialConversiones.get(i));
        }
    }
}

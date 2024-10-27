package calculos;

import modelos.Moneda;

public class CalculadoraTasaDeCambio {
    public double calcularTasaDeCambio (double cantidad, Moneda monedaActual, String MonedaDestino){
        FiltroTasaCambio filtro = new FiltroTasaCambio();
        double tasaCambio = filtro.filtrarTasaCambio(monedaActual,MonedaDestino);
        return tasaCambio * cantidad;
    }
}

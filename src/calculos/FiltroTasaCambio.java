package calculos;

import modelos.Moneda;

public class FiltroTasaCambio {
    public Double filtrarTasaCambio(Moneda monedaActual, String monedaRequerida){
        return monedaActual.conversion_rates().getOrDefault(monedaRequerida, null);
    }
}

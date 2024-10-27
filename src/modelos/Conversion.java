package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversion {
    LocalDateTime fechaConsulta;
    String monedaInicial;
    String monedaConvertida;
    double cantidadInicial;
    double cantidadCambio;

    public Conversion(String monedaInicial, String monedaConvertida, double cantidadInicial, double cantidadCambio) {
        this.fechaConsulta = LocalDateTime.now();
        this.monedaInicial = monedaInicial;
        this.monedaConvertida = monedaConvertida;
        this.cantidadInicial = cantidadInicial;
        this.cantidadCambio = cantidadCambio;
    }

    public String getMonedaInicial() {
        return monedaInicial;
    }

    public void setMonedaInicial(String monedaInicial) {
        this.monedaInicial = monedaInicial;
    }

    public String getMonedaConvertida() {
        return monedaConvertida;
    }

    public void setMonedaConvertida(String monedaConvertida) {
        this.monedaConvertida = monedaConvertida;
    }

    public double getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(double cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public double getCantidadCambio() {
        return cantidadCambio;
    }

    public void setCantidadCambio(double cantidadCambio) {
        this.cantidadCambio = cantidadCambio;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fechaFormateada = this.fechaConsulta.format(formatoFecha);

        return "  " + fechaFormateada + ",\t" + String.format("%.2f", cantidadInicial) + " " + monedaInicial + " → " + String.format("%.2f", cantidadCambio) + " " + monedaConvertida + ".";
    }
}

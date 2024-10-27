package modelos;

import java.util.Map;

public record Moneda(
    String time_last_update_unix,
    String base_code,
    Map<String,Double> conversion_rates
) {

}

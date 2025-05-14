package br.com.feliperochasi.searchfipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleData(@JsonAlias("Valor") String price,
                          @JsonAlias("Marca") String brand,
                          @JsonAlias("Modelo") String model,
                          @JsonAlias("AnoModelo") String yearModel,
                          @JsonAlias("Combustivel") String fuel) {
}

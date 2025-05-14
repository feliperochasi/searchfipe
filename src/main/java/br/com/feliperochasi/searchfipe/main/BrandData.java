package br.com.feliperochasi.searchfipe.main;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BrandData(@JsonAlias("codigo") String code, @JsonAlias("nome") String name) {
}

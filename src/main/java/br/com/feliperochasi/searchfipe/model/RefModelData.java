package br.com.feliperochasi.searchfipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RefModelData (@JsonAlias("modelos") List<ModelData> models){
}

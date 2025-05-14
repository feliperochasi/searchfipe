package br.com.feliperochasi.searchfipe.main;

import br.com.feliperochasi.searchfipe.model.*;
import br.com.feliperochasi.searchfipe.service.Api;
import br.com.feliperochasi.searchfipe.service.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner SCANNER = new Scanner(System.in);
    private final String URL = "https://parallelum.com.br/fipe/api/v1/";
    private final String TOBRANDS = "/marcas";
    private final String TOMODELS = "/modelos";
    private final String TOYEARS = "/anos";
    private final Api api = new Api();
    private final Data data = new Data();
    private String actualUrl = "";

    public void initMain() {
        showMenu();
        System.out.println("Selecione uma das opcoes para consulta: ");
        var optionSelected = SCANNER.nextLine();

        showBrands(optionSelected);
        System.out.println("Informe o código da marca: ");

        var brandCodeSelected = SCANNER.nextInt();
        SCANNER.nextLine();

        var modelsList = showModels(brandCodeSelected);

        System.out.println("Digite um trecho para filtrar os modelos: ");
        var modelSearch = SCANNER.nextLine();

        modelsList.stream()
                .filter(m -> m.name().toUpperCase().contains(modelSearch.toUpperCase()))
                .forEach(m -> showOptions(m.code(), m.name()));

        System.out.println("Digite o codigo do modelo para consultar os valores: ");
        var modelSelected = SCANNER.nextInt();
        SCANNER.nextLine();

        actualUrl = actualUrl + "/" + modelSelected + TOYEARS;
        var vehicleList = new ArrayList<Vehicle>();
        var yearData = data.getList(api.getData(actualUrl), YearData.class);
        yearData.forEach(y -> {
            var yearUrl = actualUrl + "/" + y.code();
            var vehicleData = data.getData(api.getData(yearUrl), VehicleData.class);
            vehicleList.add(new Vehicle(
                    vehicleData.price(),
                    vehicleData.brand(),
                    vehicleData.model(),
                    vehicleData.yearModel(),
                    vehicleData.fuel()
                    ));
        });

        System.out.println("Todos os veículos com os valores por ano:");
        vehicleList.forEach(System.out::println);
    }

    private void showMenu() {
        System.out.println("""
                ***** OPCOES DE VEICULOS *****
                Carros
                Motos
                Caminhoes
                """);
    }

    private void showBrands(String optionSelected) {
        actualUrl = URL + optionSelected.replace(" ", "").toLowerCase() + TOBRANDS;
        var brandData = data.getList(api.getData(actualUrl), BrandData.class);
        brandData.forEach(b -> {System.out.println("Código ref: " + b.code() + " Descricao: " + b.name().toUpperCase());});
    }

    private List<ModelData> showModels(Integer codeBrand) {
        actualUrl = actualUrl + "/" + codeBrand + TOMODELS;
        var modelsData = data.getData(api.getData(actualUrl), RefModelData.class);
        List<ModelData> modelsList = modelsData.models();
        modelsList.forEach(m -> showOptions(m.code(), m.name()));
        return modelsList;
    }

    private void showOptions(String code, String name) {
        System.out.println("Código ref: " + code + " Descricao: " + name);
    }
}

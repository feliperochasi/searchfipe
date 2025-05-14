package br.com.feliperochasi.searchfipe.main;

import br.com.feliperochasi.searchfipe.model.BrandData;
import br.com.feliperochasi.searchfipe.model.ModelData;
import br.com.feliperochasi.searchfipe.model.RefModelData;
import br.com.feliperochasi.searchfipe.service.Api;
import br.com.feliperochasi.searchfipe.service.Data;

import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner SCANNER = new Scanner(System.in);
    private final String URL = "https://parallelum.com.br/fipe/api/v1/";
    private final String TOBRANDS = "/marcas";
    private final String TOMODELS = "/modelos";
    private final String TOYEARS = "/years";
    private final Api api = new Api();
    private final Data data = new Data();

    public void initMain() {
        showMenu();
        System.out.println("Selecione uma das opcoes para consulta: ");
        var optionSelected = SCANNER.nextLine();

        var brandUrl = showBrands(optionSelected);
        System.out.println("Informe o código da marca: ");

        var brandCodeSelected = SCANNER.nextInt();
        SCANNER.nextLine();

        var modelsList = showModels(brandUrl, brandCodeSelected);

        System.out.println("Digite um trecho para filtrar os modelos: ");
        var modelSearch = SCANNER.nextLine();

        modelsList.stream()
                .filter(m -> m.name().toUpperCase().contains(modelSearch.toUpperCase()))
                .forEach(m -> showOptions(m.code(), m.name()));

        System.out.println("Digite o codigo do modelo para consultar os valores: ");
        var modelSelected = SCANNER.nextInt();
        SCANNER.nextLine();


    }

    private void showMenu() {
        System.out.println("""
                ***** OPCOES DE VEICULOS *****
                Carro
                Moto
                Caminhao
                """);
    }

    private String showBrands(String optionSelected) {
        var brandUrl = URL + optionSelected.replace(" ", "") + TOBRANDS;
        var brandData = data.getList(api.getData(brandUrl), BrandData.class);
        brandData.forEach(b -> {System.out.println("Código ref: " + b.code() + " Descricao: " + b.name().toUpperCase());});

        return brandUrl;
    }

    private List<ModelData> showModels(String urlBrand, Integer codeBrand) {
        var modelUrl = urlBrand + "/" + codeBrand + TOMODELS;
        var modelsData = data.getData(api.getData(modelUrl), RefModelData.class);
        List<ModelData> modelsList = modelsData.models();
        modelsList.forEach(m -> showOptions(m.code(), m.name()));
        return modelsList;
    }

    private void showOptions(String code, String name) {
        System.out.println("Código ref: " + code + " Descricao: " + name);
    }
}

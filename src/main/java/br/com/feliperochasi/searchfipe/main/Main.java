package br.com.feliperochasi.searchfipe.main;

import br.com.feliperochasi.searchfipe.service.Api;
import br.com.feliperochasi.searchfipe.service.Data;

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
        var brandUrl = URL + optionSelected.replace(" ", "") + TOBRANDS;
        var brandData = data.getList(api.getData(brandUrl), BrandData.class);
        System.out.println(brandData);

    }

    private void showMenu() {
        System.out.println("""
                ***** OPCOES DE VEICULOS *****
                Carro
                Moto
                Caminhao
                """);
    }
}

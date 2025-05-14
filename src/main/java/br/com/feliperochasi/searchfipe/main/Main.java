package br.com.feliperochasi.searchfipe.main;

import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public void initMain() {
        showMenu();
        var optionSelected = scanner.nextLine();
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

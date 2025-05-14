package br.com.feliperochasi.searchfipe;

import br.com.feliperochasi.searchfipe.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchfipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SearchfipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.initMain();
	}
}

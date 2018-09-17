package br.edu.fapi;

import br.edu.fapi.menu.Menu;

public class Main {
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.wellcome();
		menu.menu();
		menu.report();
	}
}

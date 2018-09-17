package br.edu.fapi.menu;

import br.edu.fapi.file.ControllerFile;
import br.edu.fapi.jogo.ControllerJogo;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
	private Scanner scan = new Scanner(System.in);
	private String escolha = "1";
	

    public void menu(){
        while(!"0".equalsIgnoreCase(escolha)) {
            //Essa parte aparece as parada na tela
            System.out.println("Ola tudo bem\n bem vindo ao jogo da forca!");
            System.out.printf("1 - Jogar\n 2 - Gerar Relatórios \n0 - Sair");


			// se for 1 Executa o jogo
			if ("1".equalsIgnoreCase(escolha)) {
				ControllerJogo jogo = new ControllerJogo();
				jogo.jogar();
			}
		}
	}

            //se for 1 Executa o jogo
            if ("1".equalsIgnoreCase(escolha)) {
                ControllerJogo jogo = new ControllerJogo();
                jogo.jogar();
            }

            if ("2".equalsIgnoreCase(escolha)) {
                do{
                   System.out.printf("1 - Gerar Relatório Geral\n2 - Gerar Relatório de Vitórias\n3 - Gerar Relatório de Derrotas");
                    escolha = scan.next();
                }while (!"1".equals(escolha) || !"2".equals(escolha) || !"3".equals(escolha));

                ControllerFile controllerFile = new ControllerFile();
                if("1".equals(escolha)){
                    controllerFile.gerarRelatorio();
                }else if("2".equals(escolha)){
                    controllerFile.gerarRelatorioVitoria();
                }else if("3".equals(escolha)){
                    controllerFile.gerarRelatorioDerrotas();
                }
                System.out.println("Relatório gerado!");
            }
        }
    }


	public void report() {
		System.out.println("==========================================================");
		System.out.println("+                                                        +");
		System.out.println("+         FIM DE JOGO DESEJA GERAR O RELATORIO           +");
		System.out.println("+                                                        +");
		System.out.println("+ ( 1 ) Gerar Relat�rio Geral                            +");
		System.out.println("+ ( 2 ) Gerar Relat�rio de Vit�rias                      +");
		System.out.println("+ ( 3 ) Gerar Relat�rio de Derrotas                      +");
		System.out.println("==========================================================");
		ControllerFile report = new ControllerFile();
		report.files_createDirectory();
	}
}

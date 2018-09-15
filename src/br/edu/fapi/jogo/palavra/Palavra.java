package br.edu.fapi.jogo.palavra;

import java.util.List;

public class Palavra {
    private String palavra;
    private String palavraForca = "";

    public String getPalavraForca() {
        return palavraForca;
    }

    public void setPalavra(String palavra) {
        for (int i = 0; i < palavra.length();i++){
            palavraForca += "-";
        }
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public boolean completa() {
        if(palavraForca.equalsIgnoreCase(palavra)) return true;
        else return false;
    }

    public int executaLetra(String letraDigitada) {
        if(verificaLetraErrada(letraDigitada.charAt(0))){
            return 1;
        }else substituiLetra(letraDigitada.charAt(0));
        return 0;
    }

    private void substituiLetra(char letraDigitada) {
        StringBuilder palavraForcaRefeita =  new StringBuilder(palavraForca);

        for (int i = 0; i < palavraForca.length();i++){
            if(palavra.charAt(i) == letraDigitada){
                palavraForcaRefeita.setCharAt(i,letraDigitada);
            }
            palavraForca = palavraForcaRefeita.toString();
        }
    }

    private boolean verificaLetraErrada(char letraDigitada){
        for (int i = 0; i < palavra.length();i++){
            if (palavra.charAt(i) == letraDigitada){
                 return false;
            }
        }
        return true;
    }

    public boolean verificaLetraExiste(char letraDigitada, List<String> digitadas){
        for (int i = 0; i < palavra.length();i++){
            if(palavraForca.charAt(i) == letraDigitada){
                System.out.println("Meu amigo, você ja digitou essa letra");
                return true;
            }

        }
        for (int i = 0; i < digitadas.size();i++){
            if(digitadas.get(i).charAt(0) == letraDigitada){
                System.out.println("Meu amigo, você ja digitou essa letra");
                return true;
            }
        }
        return false;
    }


}

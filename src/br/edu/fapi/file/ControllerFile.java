package br.edu.fapi.file;

import br.edu.fapi.dao.JogoDAO;
import br.edu.fapi.dao.impl.JogoDAOImpl;
import br.edu.fapi.jogo.Jogo;

import java.io.IOException;
import java.util.List;

public class ControllerFile {

    JogoDAO jogoDAO = new JogoDAOImpl();
    FileJogo fileJogo = new FileJogo();

    public void gerarRelatorio() throws IOException{
        List<Jogo> listaJogo = jogoDAO.listarJogo();
        fileJogo.salvarRelatorio(listaJogo, "RelatorioGeral");
    }

    public void gerarRelatorioVitoria() throws IOException{
        List<Jogo> listaJogo = jogoDAO.listarJogoVitoria();
        fileJogo.salvarRelatorio(listaJogo, "RelatorioVitorias");
    }

    public void gerarRelatorioDerrotas() throws IOException{
        List<Jogo> listaJogo = jogoDAO.listarJogoDerrota();
        fileJogo.salvarRelatorio(listaJogo, "RelatorioDerrotas");
    }
}

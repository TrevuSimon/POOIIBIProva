package br.edu.fapi.file;

<<<<<<< HEAD

public class ControllerFile {
	
	public void files_createDirectory(){
			
	}
}
=======
import br.edu.fapi.dao.JogoDAO;
import br.edu.fapi.dao.impl.JogoDAOImpl;
import br.edu.fapi.jogo.Jogo;

import java.util.List;

public class ControllerFile {

    JogoDAO jogoDAO = new JogoDAOImpl();
    FileJogo fileJogo = new FileJogo();

    public void gerarRelatorio(){
        List<Jogo> listaJogo = jogoDAO.listarJogo();
        fileJogo.salvarRelatorio(listaJogo, "RelatorioGeral");
    }

    public void gerarRelatorioVitoria(){
        List<Jogo> listaJogo = jogoDAO.listarJogoVitoria();
        fileJogo.salvarRelatorio(listaJogo, "RelatorioVitorias");
    }

    public void gerarRelatorioDerrotas(){
        List<Jogo> listaJogo = jogoDAO.listarJogoDerrota();
        fileJogo.salvarRelatorio(listaJogo, "RelatorioDerrotas");
    }
}
>>>>>>> 8bc6a989d18de55caf3f3f630def06be2310a1b1

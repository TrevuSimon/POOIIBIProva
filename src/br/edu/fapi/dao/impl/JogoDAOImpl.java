package br.edu.fapi.dao.impl;

import br.edu.fapi.dao.JogoDAO;
import br.edu.fapi.jogo.Jogo;

import java.util.List;

public class JogoDAOImpl implements JogoDAO{

    @Override
    public int cadastrarJogo(Jogo jogo) {
        return 0;
    }

    @Override
    public int salvarResultadoJogo(Jogo jogo, int Status) {
        return 0;
    }

    @Override
    public List<Jogo> listarJogo() {
        return null;
    }

    @Override
    public List<Jogo> listarJogoVitoria() {
        return null;
    }

    @Override
    public List<Jogo> listarJogoDerrota() {
        return null;
    }
}

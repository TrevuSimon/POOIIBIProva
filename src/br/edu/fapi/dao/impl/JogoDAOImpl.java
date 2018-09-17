package br.edu.fapi.dao.impl;

import br.edu.fapi.dao.JogoDAO;
import br.edu.fapi.dao.conexao.Connections;
import br.edu.fapi.jogo.Jogo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class JogoDAOImpl implements JogoDAO {

	@Override
	public int salvarResultadoJogo(Jogo jogo, int Status) {
		return 0;
	}

	@Override
	public List<Jogo> listarJogo() {
        List<Jogo> jogos = new ArrayList<>();
        try (Connection connection = Connections.openConnection()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from funcionario ", Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Jogo jogo = new Jogo();
                jogo.setIdJogo(resultSet.getInt("id"));
                jogo.setDificuldade(resultSet.getString("dificuldade"));
                jogo.setJogador(resultSet.getString("jogador"));
                jogo.setHoraJogo(resultSet.getString("profissao"));
                jogo.setHoraJogoFim(resultSet.getFloat("salario"));
                jogos.add(jogo);
            }

            jogos.forEach(funcionario -> System.out.println(funcionario));

            return jogos;
        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e.getMessage());
        }
        return funcionarios;
	}

	@Override
	public List<Jogo> listarJogoVitoria() {
		return null;
	}

	@Override
	public List<Jogo> listarJogoDerrota() {
		return null;
	}

	public int cadastrarJogo(Jogo jogo) {
		try (Connection connection = Connections.openConnection()) {

			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into funcionario_adv(jogador, dificuldade, inicio, palavra_palpite) values (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, jogo.getJogador());
			preparedStatement.setString(2, jogo.getDificuldade());
			preparedStatement.setDate(3, (Date) jogo.getHoraJogo());
			preparedStatement.setString(4, jogo.getPalavra());

			int resultado = preparedStatement.executeUpdate();
			System.out.println("Registro inserido");
			//// Obt�m a pk gerada.
			ResultSet res = preparedStatement.getGeneratedKeys();
			if (res.first()) {
				System.out.println("C�digo gerado: " + res.getInt(1));
			}
			return resultado;
		} catch (SQLException e) {
			System.out.println("Conex�o n�o estabelecida.");
			System.out.println(e.getMessage());
		}
		return 0;

	}

}

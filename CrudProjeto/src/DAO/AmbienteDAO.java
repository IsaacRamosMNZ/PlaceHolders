package DAO;

import DTO.Ambiente;
import java.sql.*;
import java.util.*;

public class AmbienteDAO {

    // Método existente para listar todos os ambientes
    public List<Ambiente> listar() {
        List<Ambiente> lista = new ArrayList<>();
        String sql = "SELECT * FROM ambiente";

        try (Connection conn = Conexao.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Ambiente a = new Ambiente();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setCapacidade(rs.getInt("capacidade"));
                a.setRecursos(rs.getString("recursos"));
                a.setLocalizacao(rs.getString("localizacao"));
                a.setLocalizacao(rs.getString("status"));
                lista.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Novo método: retorna apenas nomes de ambientes
    public List<String> listarNomes() {
        List<String> nomes = new ArrayList<>();
        String sql = "SELECT nome FROM ambiente";

        try (Connection conn = Conexao.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                nomes.add(rs.getString("nome"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nomes;
    }

    // ✅ ATUALIZAR
    public void atualizar(Ambiente a) {
        String sql = "UPDATE ambiente SET nome = ?, capacidade = ?, recursos = ?, localizacao = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getNome());
            stmt.setInt(2, a.getCapacidade());
            stmt.setString(3, a.getRecursos());
            stmt.setString(4, a.getLocalizacao());
            stmt.setInt(5, a.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ DELETAR
    public void deletar(int id) {
        String sql = "DELETE FROM ambiente WHERE id = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Ambiente a) {
        String sql = "INSERT INTO ambiente (nome, capacidade, recursos, localizacao) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getNome());
            stmt.setInt(2, a.getCapacidade());
            stmt.setString(3, a.getRecursos());
            stmt.setString(4, a.getLocalizacao());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int buscarIdPorNome(String nome) {
        int id = -1;
        String sql = "SELECT id FROM ambiente WHERE nome = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

}

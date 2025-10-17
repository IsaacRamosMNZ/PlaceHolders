package DAO;

import DTO.Ambiente;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class AmbienteDAO {

    // ✅ INSERIR
    public void inserir(Ambiente a) {
        String sql = "INSERT INTO ambiente (nome, capacidade, recursos, localizacao) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getNome());
            stmt.setInt(3, a.getCapacidade());
            stmt.setString(4, a.getRecursos());
            stmt.setString(5, a.getLocalizacao());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ LISTAR
    public List<Ambiente> listar() {
        List<Ambiente> lista = new ArrayList<>();
        String sql = "SELECT * FROM ambiente";
        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Ambiente a = new Ambiente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("capacidade"),
                    rs.getString("recursos"),
                    rs.getString("localizacao")
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // ✅ ATUALIZAR
    public void atualizar(Ambiente a) {
        String sql = "UPDATE ambiente SET nome = ?, capacidade = ?, recursos = ?, localizacao = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, a.getNome());
            stmt.setInt(3, a.getCapacidade());
            stmt.setString(4, a.getRecursos());
            stmt.setString(5, a.getLocalizacao());
            stmt.setInt(6, a.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ DELETAR
    public void deletar(Ambiente ambiente) {
        String sql = "DELETE FROM ambiente WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            String delet = JOptionPane.showInputDialog(null, "informe o ID");
            
            stmt.setString(1, delet);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

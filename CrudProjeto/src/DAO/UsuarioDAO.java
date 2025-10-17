package DAO;

import java.sql.*;
import java.util.*;
import DTO.usuario;
import DAO.Conexao;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    public boolean inserir(usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email, senha, tipoUsuario) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getGmail());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<usuario> listar() {
        List<usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                usuario u = new usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
                );
                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public usuario buscarPorEmail(String email) {
        String sql = "SELECT * FROM usuario WHERE email = ?";
        usuario usuario = null;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public void atualizar(usuario u) {
        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, tipoUsuario = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getGmail());
            stmt.setString(3, u.getSenha());
            stmt.setInt(5, u.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(usuario usuario) {
        String sql = "DELETE FROM usuario WHERE senha = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            String Senha = JOptionPane.showInputDialog(null, "insira a senha");
            
            stmt.setString(1, Senha);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean autenticar(usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE gmail = ? AND senha = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getGmail());
            stmt.setString(2, usuario.getSenha());
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

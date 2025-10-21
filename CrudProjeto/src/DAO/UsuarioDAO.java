package DAO;

import java.sql.*;
import java.util.*;
import DTO.usuario;
import DAO.Conexao;
import DTO.Usuario_logado;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    public boolean inserir(usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

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

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

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

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

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

    public boolean atualizar(usuario u) {
        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE email = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getGmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getGmail());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(usuario usuario) {
        String sql = "DELETE FROM usuario WHERE senha = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            String Senha = JOptionPane.showInputDialog(null, "insira a senha");

            stmt.setString(1, Senha);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean autenticar(usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getGmail());
            stmt.setString(2, usuario.getSenha());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Cria o objeto completo do usuário
                usuario u = new usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setGmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));

                Usuario_logado.setUsuarioAtual(u); // Preenche todos os dados
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

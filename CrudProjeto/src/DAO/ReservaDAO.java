package DAO;

import java.sql.*;
import java.util.*;
import DTO.reserva;
import DAO.Conexao;

public class ReservaDAO {

    public void inserir(reserva r) {
        String sql = "INSERT INTO reserva (idUsuario, idAmbiente, data, horaInicio, horaFim, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, r.getIdUsuario());
            stmt.setInt(2, r.getIdAmbiente());
            stmt.setString(3,r.getData());
            stmt.setInt(4, r.getHoraInicio());
            stmt.setInt(5, r.getHorafim());
            stmt.setString(6, r.getStatus());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<reserva> listar() {
        List<reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reserva";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                reserva r = new reserva(
                    rs.getInt("id"),
                    rs.getInt("idAmbiente"),
                    rs.getString("data"),
                    rs.getInt("horaInicio"),
                    rs.getInt("horaFim"),
                    rs.getString("status")
                );
                lista.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public reserva buscarPorId(int id) {
        String sql = "SELECT * FROM reserva WHERE id = ?";
        reserva r = null;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                r = new reserva(
                    rs.getInt("id"),
                    rs.getInt("idAmbiente"),
                    rs.getString("data"),
                    rs.getInt("horaInicio"),
                    rs.getInt("horaFim"),
                    rs.getString("status")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    public void atualizarStatus(int id, String novoStatus) {
        String sql = "UPDATE reserva SET status = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoStatus);
            stmt.setInt(2, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM reserva WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author will
 */
public class reserva {

    private int id;
    private int idUsuario;
    private int idAmbiente;
    private int data;
    private int horaInicio;
    private int horafim;
    private String status;

    public reserva(int id, int idAmbiente, int data, int horaInicio, int horafim, String status) {
        this.id = id;
        this.idAmbiente = idAmbiente;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horafim = horafim;
        this.status = status;
    }

    public reserva() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(int idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHorafim() {
        return horafim;
    }

    public void setHorafim(int horafim) {
        this.horafim = horafim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
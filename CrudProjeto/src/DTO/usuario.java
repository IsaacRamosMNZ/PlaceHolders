package DTO;

public class usuario{

    private int id;
    private String nome;
    private String Gmail;
    private String senha;
    
    
    public usuario(int id, String nome, String Gmail, String senha) {
        this.id = id;
        this.nome = nome;
        this.Gmail = Gmail;
        this.senha = senha;
    }

    public usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
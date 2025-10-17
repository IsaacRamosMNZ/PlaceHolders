package DTO;

public class Usuario_logado {
    
    private static usuario usuarioAtual;
    private static usuario nomeAtual;
    private static usuario idAtual;
    private static usuario Senha;

    public static usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public static void setUsuarioAtual(usuario usuarioAtual) {
        Usuario_logado.usuarioAtual = usuarioAtual;
    }

    public static usuario getNomeAtual() {
        return nomeAtual;
    }

    public static void setNomeAtual(usuario nomeAtual) {
        Usuario_logado.nomeAtual = nomeAtual;
    }

    public static usuario getIdAtual() {
        return idAtual;
    }

    public static void setIdAtual(usuario idAtual) {
        Usuario_logado.idAtual = idAtual;
    }

    public static usuario getSenha() {
        return Senha;
    }

    public static void setSenha(usuario Senha) {
        Usuario_logado.Senha = Senha;
    }
    
    public static void limparUsuario() {
    idAtual = null;
    Senha = null;
    usuarioAtual = null;
    nomeAtual = null;
    }
}

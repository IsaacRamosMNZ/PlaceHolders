package DTO;

public class Usuario_logado {
    
    private static usuario usuarioAtual;

    public static usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public static void setUsuarioAtual(usuario usuario) {
        usuarioAtual = usuario;
    }

    public static void limparUsuario() {
        usuarioAtual = null;
    }

    public static boolean isLogado() {
        return usuarioAtual != null;
    }
}

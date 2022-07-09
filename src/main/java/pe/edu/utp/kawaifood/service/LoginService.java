package pe.edu.utp.kawaifood.service;

public interface LoginService {
    boolean isAuthenticated();

    public void iniciarSesion(String email, String contrasena);
}

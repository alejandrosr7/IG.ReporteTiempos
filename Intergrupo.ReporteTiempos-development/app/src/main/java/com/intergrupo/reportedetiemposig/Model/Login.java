package com.intergrupo.reportedetiemposig.Model;

/**
 * Created by mauricio on 7/11/15.
 *
 * Entidad para el inicio de sesión de la aplicación
 */
public class Login {


    /**
     * Permite obtener o establecer el usuario para la aplicacion
     */
    private String Usuario;

    /**
     * Permite obtener o establecer la contraseña del usuario para la aplicacion
     */
    private String Contrasena;

    public Login() {
    }

    public Login(String Usuario, String Contrasena) {
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

}

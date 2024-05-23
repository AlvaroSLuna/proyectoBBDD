package BBDD.Interfaces;

import BBDD.Usuario;

import java.sql.Connection;

public interface ConexionesBaseDatos {

    public Connection conectar();

    void startDB();

    public String anyadirUsuario(Usuario usuario);

    public String mostrarUsuario();

    String editarUsuario(Usuario usuario);

    String eliminarUsuario(Usuario usuario);

    String mostrarPaises(Usuario usuario);
}
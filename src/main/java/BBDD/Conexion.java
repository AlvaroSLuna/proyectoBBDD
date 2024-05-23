package BBDD;

import BBDD.Interfaces.ConexionesBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conexion implements ConexionesBaseDatos {
    // Constantes para la conexión a la base de datos
    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3309/proyecto?allowPublicKeyRetrieval=true";
    private static final String USUARIO = "root";
    private static final String CLAVE = "123456789";

    // Método para establecer la conexión a la base de datos
    @Override
    public Connection conectar() {
        Connection conexion = null;
        try {
            // Obtiene la conexión a la base de datos utilizando las constantes de conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión OK");
        } catch (SQLException e) {
            // Si hay un error en la conexión, imprime un mensaje de error y muestra la traza de la excepción
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
        return conexion;
    }

    @Override
    public void startDB(){
        Conexion con = new Conexion();
        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            cn = con.conectar();
            if (cn != null) {
                if (!tableExists(cn, "Usuarios")) {
                    stm = cn.createStatement();
                    stm.executeUpdate("CREATE TABLE Usuarios (DNI VARCHAR(12) NOT NULL, nombre VARCHAR(45), pais VARCHAR(45), PRIMARY KEY (DNI))");
                    System.out.println("Tabla 'Usuarios' creada exitosamente.");
                } else {
                    stm = cn.createStatement();
                    System.out.println("La tabla 'Usuarios' ya existe.");
                }

                rs = stm.executeQuery("SELECT * FROM Usuarios");

                while (rs.next()) {
                    String dni = rs.getString("DNI");
                    String nombre = rs.getString("nombre");
                    String pais = rs.getString("pais");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static boolean tableExists(Connection connection, String tableName) throws SQLException {
        boolean exists = false;
        DatabaseMetaData meta = connection.getMetaData();
        try (ResultSet rs = meta.getTables(null, null, tableName, null)) {
            if (rs.next()) {
                exists = true;
            }
        }
        return exists;
    }

    @Override
    public String anyadirUsuario(Usuario usuario){
        Conexion con = new Conexion();
        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;
        String result = null;
        try {
            cn = con.conectar();
            stm = cn.createStatement();
            String query = "INSERT INTO Usuarios (DNI, nombre, pais) VALUES ('" + usuario.getDni() + "', '" + usuario.getNombre() + "', '" + usuario.getPais() + "');";
            stm.executeUpdate(query);
            result = "Usuario añadido exitosamente: " + usuario;

        } catch (SQLException e) {
            //e.printStackTrace();
            result = "\nError en la inserción\n";
        }
        return result;
    }

    @Override
    public String mostrarUsuario() {
        Conexion con = new Conexion();
        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;
        String result = null;
        try {
            cn = con.conectar();
            stm = cn.createStatement();
            String query = "SELECT * FROM Usuarios";
            rs = stm.executeQuery(query);

            List <Usuario> usuarios = new ArrayList<>();
            while (rs.next()) {
                String dni = rs.getString("DNI");
                String nombre = rs.getString("nombre");
                String pais = rs.getString("pais");

                usuarios.add(new Usuario(dni, nombre, pais));
            }
            result = "Lista de usuarios: " + usuarios;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return result;
    }

    @Override
    public String editarUsuario(Usuario usuario) {

        Conexion con = new Conexion();
        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;
        String result = null;

        try {
            cn = con.conectar();
            stm = cn.createStatement();
            String query = "UPDATE Usuarios SET nombre='" + usuario.getNombre() + "', pais='" + usuario.getPais() + "' WHERE DNI='" + usuario.getDni() + "'";
            int rowsAffected = stm.executeUpdate(query);

            if (rowsAffected > 0) {
                result = "Usuario editado exitosamente.";
            } else {
                result = "No se encontró un usuario con ese DNI, por favor intenta de nuevo.";
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return result;
    }

    @Override

    public String eliminarUsuario(Usuario usuario) {
        Conexion con = new Conexion();
        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;
        String result = null;
        try {
            cn = con.conectar();
            stm = cn.createStatement();
            String query = "DELETE FROM Usuarios WHERE DNI = '" + usuario.getDni() + "'";
            int rowsAffected = stm.executeUpdate(query);
            if (rowsAffected > 0) {
                result = "Usuario eliminado exitosamente.";
            } else {
                result = "No se encontró un usuario con ese DNI, por favor intenta de nuevo.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String mostrarPaises(Usuario usuario) {
        Conexion con = new Conexion();
        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;
        String result = null;
        try {
            cn = con.conectar();
            stm = cn.createStatement();
            String query = "SELECT * FROM Usuarios WHERE Pais = '" + usuario.getPais() + "'";
            rs = stm.executeQuery(query);

            List <Usuario> usuarios = new ArrayList<>();
            while (rs.next()) {
                String dni = rs.getString("DNI");
                String nombre = rs.getString("nombre");
                String pais = rs.getString("pais");

                usuarios.add(new Usuario(dni, nombre, pais));
            }
            result = "Lista de usuarios: " + usuarios;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return result;
    }

}
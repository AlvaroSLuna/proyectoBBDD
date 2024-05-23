package BBDD.Interfaces;

import java.util.Scanner;

public interface InterfazMenu {

    public void menu();

    void anyadirUsuarios(Scanner scanner);

    void mostrarUsuarios();

    void editarUsuario(Scanner scanner);

    void eliminarUsuario(Scanner scanner);

    void mostrarPaises(Scanner scanner);
}
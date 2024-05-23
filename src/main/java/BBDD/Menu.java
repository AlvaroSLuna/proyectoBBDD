package BBDD;

import BBDD.Interfaces.InterfazMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu implements InterfazMenu {

    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opc = 0;
        System.out.println("Bienvenido al gestor de BBDD");
        do {
            System.out.println("\nElija una de las siguientes opciones:");
            System.out.println("1. Añadir Usuarios.");
            System.out.println("2. Mostrar Usuarios.");
            System.out.println("3. Editar Usuarios.");
            System.out.println("4. Eliminar Usuarios.");
            System.out.println("5. Paises de Usuarios.");
            System.out.println("6. Salir.");
            System.out.println("Opcion:");

            opc = validaMenu(scanner);
            System.out.println();

            switch (opc) {
                case 1:
                    anyadirUsuarios(scanner);
                    break;
                case 2:
                    mostrarUsuarios();
                    break;
                case 3:
                    editarUsuario(scanner);
                    break;
                case 4:
                    eliminarUsuario(scanner);
                    break;
                case 5:
                    mostrarPaises(scanner);
                    break;
                case 6:
                    System.out.println("\n Cerrando el programa...\n");
                    break;
                default:
            }
        } while (opc != 6);
    }
    @Override
    public void anyadirUsuarios(Scanner scanner) {
        String dni = "";
        String nombre = "";
        String pais = "";
        do {
            System.out.println("Introduzca el DNI del usuario: ");
            dni = scanner.next();
            System.out.println("Introduzca el nombre del usuario: ");
            nombre = scanner.next();
            System.out.println("Introduzca el pais del usuario: ");
            pais = scanner.next();
        } while (dni.equals("") || nombre.equals("") || pais.equals(""));


        Usuario usuario = new Usuario(dni, nombre, pais);
        Conexion con = new Conexion();
        String result =con.anyadirUsuario(usuario);
        System.out.println(result);
    }

    @Override
    public void mostrarUsuarios() {

        Conexion con = new Conexion();
        String result = con.mostrarUsuario();
        System.out.println(result);
    }

    @Override
    public void editarUsuario(Scanner scanner) {
        String dni = "";
        String nombre = "";
        String pais = "";

        System.out.println("Editar usuario: \n");
        System.out.println("Introduzca el DNI del usuario que desea editar: ");
        dni = scanner.next();
        System.out.println("Introduzca el nuevo nombre del usuario: ");
        nombre = scanner.next();
        System.out.println("Introduzca el nuevo pais del usuario: ");
        pais = scanner.next();

        Usuario usuario = new Usuario(dni, nombre, pais);
        Conexion con = new Conexion();
        String result = con.editarUsuario(usuario);
        System.out.println(result);
    }

    @Override
    public void eliminarUsuario(Scanner scanner) {
        String dni = "";

        System.out.println("Eliminar usuario: \n");
        System.out.println("Introduzca el DNI del usuario que desea eliminar: ");
        dni = scanner.next();

        Usuario usuario = new Usuario(dni, "", "");
        Conexion con = new Conexion();
        String result = con.eliminarUsuario(usuario);
        System.out.println(result);
    }

    @Override
    public void mostrarPaises(Scanner scanner) {
        String pais = "";

        System.out.println("Introduzca el pais de los usuarios que desee ver: ");
        pais = scanner.next();

        Usuario usuario = new Usuario("", "", pais);
        Conexion con = new Conexion();
        String result = con.mostrarPaises(usuario);
        System.out.println(result);
    }

    /**
     * Este método sirve para validar que se introduce la opción
     * correcta a la hora de seleccionar en el menú.
     * @return: Devuelve el valor introducido por el usuario una vez se ha comprobado
     */


    public static int validaMenu(Scanner t) {
        int resultado = 0;
        boolean valid = false;

        do {
            try {
                resultado = t.nextInt();
                if (resultado >= 1 && resultado <= 6) {
                    valid = true;
                } else {
                    System.out.println("Opción Incorrecta, vuelve a intentarlo");
                    valid = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opción erronea, vuelve a intentarlo");
                t.next();
            }
        } while (!valid);
        return resultado;
    }
}
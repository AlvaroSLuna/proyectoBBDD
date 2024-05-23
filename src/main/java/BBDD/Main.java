package BBDD;

public class Main {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.startDB();

        Menu menu = new Menu();
        menu.menu();
    }

}
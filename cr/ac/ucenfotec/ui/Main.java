package cr.ac.ucenfotec.ui;

public class Main {
    public static void main(String[] args) {
        try {
            Menu menu = new Menu();
            menu.iniciar();
        } catch (Exception e) {
            System.out.println("Error iniciando el menú: " + e.getMessage());
        }
    }
}
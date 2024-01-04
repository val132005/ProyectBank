import java.util.Scanner;

public class MenuClient {
    static Scanner sc = new Scanner(System.in);
    static Cliente cliente = new Cliente();
    public static void MenuHambur(int codPerson) {
        
        int cod_Person = codPerson;
        
        System.out.println("--------- Menú Personas -------");
        System.out.println("1. Cuenta de Ahorros");
        System.out.println("2. Tarjeta Debito");
        System.out.println("3. Tarjeta credito");
        System.out.println("0. Cerrar Sesión");
        System.out.print("Seleccione una opción: ");
        int op = sc.nextInt();

        do {
            switch (op) {
                case 1:
                    accountSaving(cod_Person);

                    break;
                case 2:
                    System.out.println("Tarjeta Debito"); 
                    break;
                case 3:
                    System.out.println("Tarjeta credito");
                    break;
                case 0:
                    System.out.println("Sesión cerrada. ¡Hasta luego!");
                    Atm.welcome();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }

        } while (op != 4);
    }

    private static void accountSaving(int codPerson) {
        int cod_Person = codPerson;
        int op;
        do {
            System.out.println("1. Ver saldo");
            System.out.println("2. Retirar");
            System.out.println("3. Consignar");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                cliente.verSaldo();

                    break;
                case 2:
                System.out.print("Ingrese la cantidad a retirar: ");
                double cantidadRetiro = sc.nextDouble();
                cliente.retirar(cantidadRetiro);

                    break;
                case 3:
                System.out.print("Ingrese la cantidad a consignar: ");
                double cantidadConsignar = sc.nextDouble();
                cliente.consignar(cantidadConsignar);

                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal");
                    MenuHambur(cod_Person);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while ( op != 0 );

    }
}

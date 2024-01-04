import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Atm {

    static Scanner sc = new Scanner(System.in);
    // static List<Person> people = new ArrayList<>();
    static Cliente client = new Cliente();
    public static void welcome() {
        Administrador.crearAdminPredefinido();

        int op;
        do {
            System.out.println("Bienvenido a patito!");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción: ");
            op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    Atm.login();
                }
                case 2 -> {
                    Cliente.registerClient();
                }
                case 0 -> {
                    System.out.println("Adios");
                }
                default -> {
                    System.out.println("Ingrese una opción correcta");
                }
            }
        } while ( op != 0 );
    }



    private static void login() {
        System.out.println("-------- Iniciar Sesión ---------");

        System.out.print("Ingrese su código de usuario: ");
        int inputCod = sc.nextInt();

        System.out.print("Ingrese su clave (4 dígitos): ");
        String inputPassword = sc.next();

        // Buscar la persona en la lista
        boolean found = false;
        for (Person person : Cliente.people) {
            if (person.getCodPerson() == inputCod && person.getPasswordPerson().equals(inputPassword)) {
                found = true;
                if ( person.getRolPerson() == 1 ) {
                    Atm.accountAdmin( person.getCodPerson() );
                } else if ( person.getRolPerson() == 2 ) {
                    Atm.accountClient( person.getCodPerson() );
                } else {
                    System.out.println("Error: Rol no econtrado");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Código de usuario o clave incorrectos. Inicio de sesión fallido.");
        }
    }

    private static void accountClient(int codPerson) {
        for (Person person : Cliente.people) {
            if (person.getCodPerson() == codPerson) {
                System.out.println("Bienvenido " + person.getNamePerson());
                MenuClient.MenuHambur(person.getCodPerson());
            }
        }
    }

    private static void accountAdmin(int codPerson) {
        for (Person person : Cliente.people) {
            if (person.getCodPerson() == codPerson) {
                System.out.println("Bienvenido " + person.getNamePerson());
                System.out.println("-------- Menú administrador ------------");
                System.out.println("1. Consultar Cliente");
                System.out.println("2. Registrar Cliente");
                System.out.println("3. Modificar Cliente");
                System.out.println("4. Eliminar Cliente");
                System.out.println("5. Cerrar Sesión");
                System.out.print("Seleccione una opción: ");
                int adminOp = sc.nextInt();
    
                switch (adminOp) {
                    case 1:
                        Administrador.consultClient();
                        break;
                    case 2:
                        Administrador.registerClient();
                        break;
                    case 3:
                        Administrador.modifyClient();
                        break;
                    case 4:
                        Administrador.deleteClient();
                        break;
                    case 5:
                        System.out.println("Sesión cerrada. ¡Hasta luego!");
                        Atm.welcome();
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        break;
                }
            }
        }
    }

    /*
    private static void numPerson() {
        int numPerson = 0;
        for (Person person : people) {
            numPerson++;
        }
        System.out.println("Usuarios registrados: " + numPerson);
    }*/
}


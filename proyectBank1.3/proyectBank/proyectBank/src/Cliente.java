import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Person {
    static Scanner sc = new Scanner(System.in);

    private static int cont_codPerson = 1;
    private static List<ClienteSaldo> saldosClientes = new ArrayList<>();

    public static void registerClient() {
        Person new_person = new Person();
        new_person.setCodPerson(cont_codPerson);
        cont_codPerson++;

        System.out.println("-------- Registro ---------");

        System.out.print("Ingrese su nombre:");
        String name_person = sc.next();

        System.out.print("Ingrese su apellido:");
        String lastname_person = sc.next();

        System.out.print("Ingrese su clave (4 digitos): ");
        String password_person = sc.next();

        if (name_person.equals("") || lastname_person.equals("")) {
            System.out.println("No puede tener un nombre u apellido vacío");
            return;
        } else if (password_person.length() != 4) {
            System.out.println("La clave debe ser de 4 digitos");
        } else {
            new_person.setNamePerson(name_person);
            new_person.setLastnamePerson(lastname_person);
            new_person.setPasswordPerson(password_person);
            new_person.setRolPerson(2);
        }

        people.add(new_person);

        saldosClientes.add(new ClienteSaldo(new_person.getCodPerson(), 0.0));

        System.out.println("Persona: " + new_person.getNamePerson() + " registrado con exito");
        System.out.println("Guarde los siguientes datos para iniciar sesión posteriormente");
        System.out.println("Código de usuario: " + new_person.getCodPerson());
    }

    public Cliente() {
        // ...
    }

    public static double obtenerSaldoPorId(int idCliente) {
        for (ClienteSaldo cs : saldosClientes) {
            if (cs.getIdCliente() == idCliente) {
                return cs.getSaldo();
            }
        }
        return 0.0;
    }

    public static void retirar(int idCliente, double cantidad) {
        for (ClienteSaldo cs : saldosClientes) {
            if (cs.getIdCliente() == idCliente) {
                if (cantidad > cs.getSaldo()) {
                    System.out.println("No tiene suficiente saldo.");
                } else {
                    cs.setSaldo(cs.getSaldo() - cantidad);
                    System.out.println("Ha retirado $" + cantidad + ". Su saldo actual es: $" + cs.getSaldo());
                }
                return;
            }
        }
        System.out.println("No se encontró el cliente.");
    }

    public static void consignar(int idCliente, double cantidad) {
        for (ClienteSaldo cs : saldosClientes) {
            if (cs.getIdCliente() == idCliente) {
                cs.setSaldo(cs.getSaldo() + cantidad);
                System.out.println("Ha consignado $" + cantidad + ". Su saldo actual es: $" + cs.getSaldo());
                return;
            }
        }
        System.out.println("No se encontró el cliente.");
    }
}

class ClienteSaldo {
    private int idCliente;
    private double saldo;

    public ClienteSaldo(int idCliente, double saldo) {
        this.idCliente = idCliente;
        this.saldo = saldo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

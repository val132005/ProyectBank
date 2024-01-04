import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Person {
    static Scanner sc = new Scanner(System.in);
    
    private static int cont_codPerson = 1;

    private double saldo;

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

        // Añadir el nuevo producto a la lista / Add the new product to the List
        people.add(new_person);
        System.out.println("Persona: " + new_person.getNamePerson() + " registrado con exito");
        System.out.println("Guarde los siguientes datos para iniciar sesión posteriormente");
        System.out.println("Código de usuario: " + new_person.getCodPerson());
    }


    public Cliente() {
        this.saldo = 0.0; 
    }

    public double getSaldo() {
        return saldo;
    }

    public void verSaldo() {
        System.out.println("Su saldo actual es: $" + saldo);
    }

    public void retirar(double cantidad) {
        if (cantidad > saldo) {
            System.out.println("No tiene suficiente saldo para realizar esta transacción.");
        } else {
            saldo -= cantidad;
            System.out.println("Ha retirado $" + cantidad + ". Su saldo actual es: $" + saldo);
        }
    }

    public void consignar(double cantidad) {
        saldo += cantidad;
        System.out.println("Ha consignado $" + cantidad + ". Su saldo actual es: $" + saldo);
    }
}

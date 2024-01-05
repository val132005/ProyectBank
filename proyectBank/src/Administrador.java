import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Administrador extends Person {
    static Scanner sc = new Scanner(System.in);

    public static void crearAdminPredefinido() {
        Person admin = new Person();
        admin.setCodPerson(0);
        admin.setNamePerson("Admin");
        admin.setLastnamePerson("Predefinido");
        admin.setPasswordPerson("0000"); 
        admin.setRolPerson(1);

        people.add(admin);
        registeredDocuments.add(0); //documento ficticio para el admin
    }
    
    private static int cont_codPerson = 1;

    private static Set<Integer> registeredDocuments = new HashSet<>();


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

        System.out.print("Ingrese su número de documento:");
        int document = sc.nextInt();

        if (name_person.equals("") || lastname_person.equals("")) {
            System.out.println("No puede tener un nombre u apellido vacío");
            return;
        } else if (password_person.length() != 4) {
            System.out.println("La clave debe ser de 4 digitos");
            return;
        } else if (registeredDocuments.contains(document)) {
            System.out.println("El número de documento ya está registrado. No se permite duplicar.");
            return;
        }

        new_person.setNamePerson(name_person);
        new_person.setLastnamePerson(lastname_person);
        new_person.setPasswordPerson(password_person);
        new_person.setRolPerson(2);
        new_person.setDocument(document);

        // Añadir el nuevo producto a la lista / Add the new product to the List
        people.add(new_person);
        registeredDocuments.add(document);

        System.out.println("Persona: " + new_person.getNamePerson() + " registrado con éxito");
        System.out.println("Guarde los siguientes datos para iniciar sesión posteriormente");
        System.out.println("Código de usuario: " + new_person.getCodPerson());
    }

    public static void deleteClient() {
        System.out.print("Ingrese el número de documento del cliente que desea eliminar: ");
        int documentToDelete = sc.nextInt();

        boolean found = false;
        for (Person person : people) {
            if (person.getDocument() == documentToDelete) {
                people.remove(person);
                registeredDocuments.remove(documentToDelete);
                found = true;
                System.out.println("Cliente eliminado con éxito.");
                break;
            }
        }

        if (!found) {
            System.out.println("No se encontró un cliente con el número de documento proporcionado.");
        }
    }

    public static void modifyClient() {
        System.out.print("Ingrese el número de documento del cliente que desea modificar: ");
        int documentToModify = sc.nextInt();

        boolean found = false;
        for (Person person : people) {
            if (person.getDocument() == documentToModify) {
                System.out.println("-------- Modificación ---------");
                System.out.print("Ingrese el nuevo nombre: ");
                String newName = sc.next();
                person.setNamePerson(newName);

                System.out.print("Ingrese el nuevo apellido: ");
                String newLastname = sc.next();
                person.setLastnamePerson(newLastname);

                System.out.print("Ingrese la nueva clave (4 digitos): ");
                String newPassword = sc.next();
                if (newPassword.length() != 4) {
                    System.out.println("La clave debe ser de 4 dígitos. No se realizaron cambios.");
                    return;
                }
                person.setPasswordPerson(newPassword);

                System.out.println("Cliente modificado con éxito.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No se encontró un cliente con el número de documento proporcionado.");
        }
    }

    public static void consultClient() {
        System.out.print("Ingrese el número de documento del cliente que desea consultar: ");
        int documentToConsult = sc.nextInt();

        boolean found = false;
        for (Person person : people) {
            if (person.getDocument() == documentToConsult) {
                System.out.println("-------- Consulta ---------");
                System.out.println("Nombre: " + person.getNamePerson());
                System.out.println("Apellido: " + person.getLastnamePerson());
                System.out.println("Número de Documento: " + person.getDocument());
                System.out.println("Rol: " + person.getRolPerson());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No se encontró un cliente con el número de documento proporcionado.");
        }
    }

}

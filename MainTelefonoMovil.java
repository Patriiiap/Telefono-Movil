package TelefonoMovil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTelefonoMovil {


    public static void main(String[] args) {

        TelefonoMovil telefonoMovil = new TelefonoMovil("487598652");

        boolean salir = false;

        do{

            System.out.println("Introduce el número para elegir una acción");
            imprimirMenu();
            int numeroElegido = CapturaExcepcionesInt();

            switch (numeroElegido){

                case 0:
                    salir = true;
                    break;
                case 1:
                    telefonoMovil.printContacts();
                    break;
                case 2:
                    anadirContacto(telefonoMovil);
                    break;
                case 3:
                    actualizarContacto(telefonoMovil);
                    break;
                case 4:
                    eliminarContacto(telefonoMovil);
                    break;
                case 5:
                    buscarContacto(telefonoMovil);
                    break;
                case 6:
                    imprimirMenu();
                    break;
            }

        } while (salir == false);

    }

    public static void imprimirMenu(){
        System.out.println("Pulsa 0 para salir");
        System.out.println("Pulsa 1 para imprimir tus contactos");
        System.out.println("Pulsa 2 para agregar un nuevo contacto");
        System.out.println("Pulsa 3 para modificar un contacto existente");
        System.out.println("Pulsa 4 para eliminar un contacto");
        System.out.println("Pulsa 5 para buscar un contacto");
        System.out.println("Pulsa 6 para imprimir el menú");
    }

    public static void anadirContacto(TelefonoMovil telefonoMovil){

        Scanner sc = new Scanner(System.in);

        boolean valido = true;

        do{
            System.out.println("Escribe el nombre de tu contacto: ");
            String elNombre = sc.nextLine();

            if(telefonoMovil.queryContact(elNombre) == null){
                String numero = CapturaExcepcionNumero();
                telefonoMovil.addNewContact(Contacto.createContact(elNombre, numero));
                System.out.println("Contacto Añadido");
                valido = true;
            }
            else{
                System.out.println("Error, el contacto introducido ya existe");
                valido = false;
            }
        } while (valido == false);


    }

    public static void actualizarContacto(TelefonoMovil telefonoMovil){

        Scanner sc = new Scanner(System.in);

        boolean valido = true;

        do{
            System.out.println("Escribe el nombre del contacto que quieres Actualizar: ");
            String contactoViejo = sc.nextLine();

            if(telefonoMovil.queryContact(contactoViejo) != null){
                System.out.println("Escribe el nombre del nuevo Contacto");
                String nuevoContacto = sc.nextLine();
                valido = true;

                if(telefonoMovil.queryContact(nuevoContacto) == null){
                    String telefonoNuevo = CapturaExcepcionNumero();
                    telefonoMovil.updateContact(telefonoMovil.queryContact(contactoViejo), Contacto.createContact(nuevoContacto, telefonoNuevo));
                    System.out.println("Contacto Actualizado");
                    valido = true;
                }
                else{
                    System.out.println("El nuevo contacto introducido ya extiste, no se ha podido añadir");
                    valido = false;
                }
            }
            else{
                System.out.println("El contacto introducido no extiste.");
                valido = false;
            }
        } while (valido == false);

    }

    public static void eliminarContacto(TelefonoMovil telefonoMovil){
        Scanner sc = new Scanner(System.in);

        boolean valido = true;

        do{
            System.out.println("Escribe el nombre del contacto que quieres eliminar");
            String nombree = sc.nextLine();

            if(telefonoMovil.queryContact(nombree) != null){
                telefonoMovil.removeContact(telefonoMovil.queryContact(nombree));
                System.out.println("Contacto Eliminado");
                valido = true;
            }
            else{
                System.out.println("El contacto introducido no se puede eliminar porque no existe.");
                valido = false;
            }

        } while (valido == false);

    }

    public static void buscarContacto(TelefonoMovil telefonoMovil){

        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe el nombre del contacto que quieres buscar: ");
        String nombreContact = sc.nextLine();
        telefonoMovil.queryContact(nombreContact);

        if(telefonoMovil.queryContact(nombreContact) != null){
            System.out.println("Contacto: " + telefonoMovil.queryContact(nombreContact).getName());
            System.out.println("Teléfono: " + telefonoMovil.queryContact(nombreContact).getPhoneNumber());
        }
        else{
            System.out.println("El contacto introducido no existe.");
        }

    }

    public static String CapturaExcepcionNumero (){

        Scanner sc = new Scanner(System.in);

        boolean valido = true;
        String numero = "";

        do {

            valido = true;
            System.out.println("Escribe el número de teléfono: ");

            numero = sc.nextLine();
            int i = 0;
            boolean control = true;

            for(; i < numero.length(); i++){
                char caracter = numero.charAt(i);
                int caracterInt = (int) caracter;
                if(caracterInt < 48 || caracterInt > 57){
                    valido = false;
                    control = false;
                }
            }
            if(control == false){
                System.out.println("Solo puedes ingresar números");
            }
            if(i != 9){
                System.out.println("El número de teléfono debe contener 9 digitos.");
                valido = false;
            }
        } while (valido == false);

        return (numero);
    }

    public static int CapturaExcepcionesInt (){

        Scanner sc = new Scanner(System.in);

        int numero = 0;
        boolean valido = true;

        do{
            valido = true;

            try{

                do{
                    numero = sc.nextInt();
                    if(numero < 0 || numero > 6){
                        System.out.println("El número debe ser entre 0 y 6");
                    }
                }
                while(numero < 0 || numero > 6);
            }
            catch (InputMismatchException e){
                System.out.println("El número debe ser entre 0 y 6, ambos inclusive");
                valido = false;
                sc.next();
            }
        }
        while (valido == false);

        return (numero);

    }

}

package TelefonoMovil;

import java.util.ArrayList;
import java.util.List;

public class TelefonoMovil {

    private String myNumber;
    private List<Contacto> myContacts;


    //Constructor

    public TelefonoMovil(String myNumber){
        this.myNumber = myNumber;
        myContacts = new ArrayList<>();
    }


    //Métodos

    private int findContact(Contacto contacto){

        int indice = -1;

        if(myContacts.contains(contacto) == true){
            indice = myContacts.indexOf(contacto);
        }
        else{
            indice = -1;
        }

        return indice;
    }

    public boolean addNewContact(Contacto contacto){

        boolean existe = true;

        if (findContact(contacto) == -1){
            myContacts.add(contacto);
            existe = true;
        }
        else{
            existe = false;
        }

        return existe;

    }

    public boolean updateContact(Contacto contactoAntiguo, Contacto contactoNuevo){

        boolean actualizar = true;

        if(findContact(contactoAntiguo) != -1){
            myContacts.set(myContacts.indexOf(contactoAntiguo), contactoNuevo);
            actualizar = true;
        }
        else{
            actualizar = false;
        }

        return actualizar;
    }

    public boolean removeContact(Contacto contacto){

        boolean eliminar = false;

        if(findContact(contacto) != -1){
            myContacts.remove(contacto);
            eliminar = true;
        }
        else{
            eliminar = false;
        }

        return eliminar;
    }

    private int findContact (String nombre){

        int resultado = -1;
        int controlador = 0;

        for(int i = 0; i < myContacts.size(); i++){
            if (myContacts.get(i).getName().equalsIgnoreCase(nombre)){
                resultado = i;
                controlador = 1;
            }
            if (controlador == 0){
                resultado = -1;
            }
        }

        return resultado;
    }

    public Contacto queryContact(String nombre){

        Contacto contacto = null;

        if(findContact(nombre) != -1){
            contacto = myContacts.get(findContact(nombre));
        }
        else{
            contacto = null;
        }
        return contacto;
    }

    public void printContacts(){
        int contadorLista = 1;
        System.out.println("Lista de Contactos");
        for (int i = 0; i < myContacts.size(); i++){
            System.out.println(contadorLista + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
            contadorLista++;
        }
    }

    @Override
    public String toString() {
        return "TelefonoMovil{" +
                "myNumber='" + myNumber + '\'' +
                ", myContacts=" + myContacts +
                '}';
    }
}

package TelefonoMovil;

public class Contacto {

    private String name;
    private String phoneNumber;


    //Constructor

    public Contacto(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    //Métodos

    public static Contacto createContact(String name, String phoneNumber){

        Contacto contacto = new Contacto(name, phoneNumber);

        return contacto;
    }


    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

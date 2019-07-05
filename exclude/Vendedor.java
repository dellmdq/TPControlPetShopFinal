package com.company.exclude;

public class Vendedor {
    private int id;
    private static int idCount = 1;
    private String name;
    private String surname;
    private long celphone;

    ///constructor


    public Vendedor(String name, String surname, long celphone) {
        setId();
        setName(name);
        setSurname(surname);
        setCelphone(celphone);
    }

    ///getters and setters

    private void setId(){
        this.id = idCount++;
    }

    public int getId(){
        return  id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getCelphone() {
        return celphone;
    }

    public void setCelphone(long celphone) {
        this.celphone = celphone;
    }

    ///methods

    @Override
    public String toString() {
        String messege = "Vendedor\n----\nId: %d || Nombre: %s || Apelliodo: %s || Celular: %d";
        return String.format(messege, getId(), getName(), getSurname(), getCelphone());
    }

    public boolean equals (Object obj){
        if (obj.getClass().isInstance(Vendedor.class)){
            return ((Vendedor)obj).getId() == getId();
        }
        return false;
    }

}

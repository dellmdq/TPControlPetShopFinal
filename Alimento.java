package com.company;

import static java.util.Objects.isNull;

public class Alimento extends Producto {
    private static int idCount=0;
    private int id;
    private String brandName;
    private String animal;
    private String taste;
    private float crudeProtein;
    private String type;
    private float numberOfKilos;///kgs en bolsa
    private String description;

    ///constructor
    public Alimento(String nombre, String animal, Proveedor company, float precioCosto, String brandName, String taste, float crudeProtein, String type, float numberOfKilos) {
        super(nombre, company, precioCosto,"KG");
        setId();
        setAnimal(animal);
        setBrandName(brandName);
        setTaste(taste);
        setCrudeProtein(crudeProtein);
        setType(type);
        setNumberOfKilos(numberOfKilos);
    }

    //constructor con precioVenta.
    public Alimento(String nombre,String animal, Proveedor company, float precioCosto, float precioVenta,String brandName, String taste, float crudeProtein, String type, float numberOfKilos) {
        super(nombre, company, precioCosto, precioVenta,"KG");
        setId();
        setAnimal(animal);
        setBrandName(brandName);
        setTaste(taste);
        setCrudeProtein(crudeProtein);
        setType(type);
        setNumberOfKilos(numberOfKilos);
    }

    ///getters and setters
    public int getId(){
        return this.id;
    }

    private void setId(){
        this.id = idCount++;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public float getCrudeProtein() {
        return crudeProtein;
    }

    public void setCrudeProtein(float crudeProtein) {
        this.crudeProtein = crudeProtein;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getNumberOfKilos() {
        return numberOfKilos;
    }

    public void setNumberOfKilos(float numberOfKilos) {
        this.numberOfKilos = numberOfKilos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    ///methods

    @Override
    public String toString() {
        String base = super.toString();
        String message = "Alimento %s || ID: %d\n----\nMarca: %s\nSabor: %s\nProteina Bruta: %.2f \nTipo: %s\nCantidad de Kilos: %.2f\n";
        return base.concat(String.format(message,getAnimal(),getId(), getBrandName(), getTaste(), getCrudeProtein(), getType(), getNumberOfKilos()));
    }

    @Override
    public boolean equals(Object o) {
        boolean equals = false;
        if(!isNull(o) && o instanceof Alimento){
            equals = (((Alimento) o).getId() == this.id);
        }
        return equals;
    }

}


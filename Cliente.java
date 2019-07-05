package com.company;

import java.io.Serializable;

public class Cliente implements Serializable {
    private long dni;
    private String nombre;
    private String apellido;
    private long telefono;

    ///constructor


    public Cliente(long dni, String nombre, String apellido, ClientesLista clientesLista) {
        setDni(dni);
        setNombre(nombre);
        setApellido(apellido);
        clientesLista.agregarCliente(this);
    }

    ///getters and setters

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    ///methods
    public String toString() {
        String message = "Cliente\n----\nDNI: %d\nNombre: %s\nApellido: %s\n";
        return String.format(message, getDni(), getNombre(),getApellido());
    }

    public boolean equals(Object obj){
        if (obj instanceof Cliente && obj != null){
            return ((Cliente)obj).getDni() == getDni();
        }
        return  false;
    }
}

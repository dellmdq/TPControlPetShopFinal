/**idea para nombre: podria ser un string compuesto por la suma
 * de sus atributos.*/

package com.company;

import java.io.Serializable;

public abstract class Producto implements Serializable {
    private String nombre;
    private Proveedor company;
    private float precioCosto;
    private float precioVenta;
    ///private float markUp;//margen de ganancia
    private String unidadDeMedida;
    private String descripcion;
    private boolean bloqueado;//si por alguna razón el producto no puede ser vendido.

    ///constructor sin precio venta, sin descripcion, bloqueado = false predeterminado.
    public Producto(String nombre, Proveedor company, float precioCosto, String unidadDeMedida) {
        setNombre(nombre);
        setCompany(company);
        setPrecioCosto(precioCosto);
        ///setMarkUp(markUp);
        setUnidadDeMedida(unidadDeMedida);
        this.bloqueado = false;
    }

    ///constructor para pruebas con parametro precio de venta.
    public Producto(String nombre, Proveedor company, float precioCosto, float precioVenta, String unidadDeMedida) {
        setNombre(nombre);
        setCompany(company);
        setPrecioCosto(precioCosto);
        setPrecioVenta(precioVenta);
        //setMarkUp(markUp);
        setUnidadDeMedida(unidadDeMedida);
        this.bloqueado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Proveedor getCompany() {
        return company;
    }

    public void setCompany(Proveedor company) {
        this.company = company;
    }

    public float getPrecioCosto() {
        return precioCosto;
    }
    /**Los set de precio de venta y de costo son privados, estos solo pueden ser modificados
     * a a través de los métodos definidos a tal efecto.*/

    protected void setPrecioCosto(float precioCosto) {
        this.precioCosto = precioCosto;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    protected void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    //public float getMarkUp() { return markUp; }

    //public void setMarkUp(float markUp) {this.markUp = markUp;}

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String toString(){///falta mostrar el proveedor
        String message = "Nombre: %s || Precio Costo: $ %.2f || Precio Venta: $ %.2f \n" +
                "|| Unid Medida: %s || Bloqueado: %s\n" +
                "Descripcion: %s";

        return String.format(message,getNombre(),getPrecioCosto(),getPrecioVenta(),getUnidadDeMedida(),isBloqueado(),getDescripcion());
    }
}

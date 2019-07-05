package com.company;

import java.io.Serializable;
import java.util.Objects;

import static java.util.Objects.isNull;

public class Item implements Serializable {
    private static int idCount = 0;
    private int id;
    private int cantidadBolsas;//cantidadBolsas refiere a bolsas
    private Alimento alimento;
    private final float porcentajeGanancia = 1.25f;///Se decide ganar un 25%

    ///constructor

    /**Constructor para items que no modifican ID, son items destinados a
     * representar los movimientos del sistema, bajas/altas de stock, sin
     * crear items nuevos en el stock.*/
    public Item(int cantidadBolsas, Alimento alimento){
        setCantidadBolsas(cantidadBolsas);
        setAlimento(alimento);
    }

    /**Constructor para items destinados a ser ingresados al stock como
     * referencia y con cantidad inicial cero.
     * Con el objetivo de representar el producto, a través del cual se
     * reflejara la cantidad en stock, con un ID .*/
    ///Constructor. Item instanciado con cantidadBolsas cero.
    public Item(Alimento alim){
        setId();
        setAlimento(alim);
    }

    ///getters and setters
    private void setId(){
        this.id=idCount++;
    }
    public int getId(){
        return this.id;
    }

    public int getCantidadBolsas() {
        return cantidadBolsas;
    }

    public void setCantidadBolsas(int cantidadBolsas) {
        this.cantidadBolsas = cantidadBolsas;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    ///methods
    public String toString() {
        String message = "ID: %d || Producto: %s || Cantidad Bolsas: %d\n";
        return String.format(message,getId(),getAlimento().getNombre(),getCantidadBolsas());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getAlimento().equals(item.getAlimento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCantidadBolsas(), getAlimento(), porcentajeGanancia);
    }

    public float calcularPrecioVentaPorProducto(Producto producto){
        float ganancia = getAlimento().getPrecioCosto() * porcentajeGanancia;
        return ganancia;
    }

}

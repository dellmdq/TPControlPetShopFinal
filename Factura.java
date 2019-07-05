package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.isNull;


/**La facturas al momento de instanciarse tienen su atributo cerrada igual a false.
 * Este atributo nos indica cuando una factura termino de ser cargada con items y fue terminada,
 * no se puede modificar una vez que esta fue cerrada. Por otro lado cada vez que se agrega un
 * item a la lista de items, debe validarse antes que exista la cantidad suficiente en stock
 * para cubrir el pedido. Las bolsas facturadas serán dadas de baja del stock al momento de cerrar
 * la factura.*/


public class Factura implements Serializable {
    private int numeroFactura;
    private  static int nroFactCount = 0;
    private String fecha;
    private Cliente cliente;
    private List<Item> listaItems;
    private boolean cerrada;

    ///constructor
    public Factura(String fecha, Cliente cliente,FacturasLista facturasLista) {
        setNumeroFactura();
        setFecha(fecha);
        setCliente(cliente);
        setListaItems();
        setCerrada(false);
        facturasLista.agregarFactura(this);
    }

    /**Factura se crea sin id y sin ser agregada a la lista, ya que esto
     * se realizara al momento de cerrar la factura.*/
    public Factura(String fecha, Cliente cliente) {
        setFecha(fecha);
        setCliente(cliente);
        setListaItems();
        setCerrada(false);
    }

    ///getters and setters

    public int getNumeroFactura() {
        return numeroFactura;
    }

    private void setNumeroFactura() {
            this.numeroFactura = nroFactCount++;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        if(!this.isCerrada()) {
            this.fecha = fecha;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if(!this.isCerrada()) {
            this.cliente = cliente;
        }
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    private void setListaItems() {
        if(!this.isCerrada()) {
            this.listaItems = new ArrayList<>();
        }
    }


    public boolean isCerrada() {
        return cerrada;
    }

    public void setCerrada(boolean cerrada) {//factura cerrada no puede anularse, ni modificarse.
        if(!this.isCerrada()) {
            this.cerrada = cerrada;
        }
    }

    ///methods

    public String toString() {
        String message = "Factura C\n----\nNumero de Factura: %d\nFecha: %s\nCliente: %s %s\n " +
                this.listaItemsToString() +
                "\nTotal Factura: " + this.calcularTotal() + "\n------------------------------------------------\n";
        return String.format(message, getNumeroFactura(), getFecha(), getCliente().getNombre(), getCliente().getApellido());
    }

    public boolean equals(Object obj){
        if (!isNull(obj) && obj instanceof Factura){
            return ((Factura)obj).getNumeroFactura() == getNumeroFactura();
        }
        return false;
    }

    ///metodos interface

    /**PROBADO?*/
    /**Debe agregar a la factura los items. Validando que haya la
     * cantidad suficiente de los mismos en stock.*/
    public void agregarItemToFactura(Object obj){
        if(!isNull(obj) && obj instanceof Item)
            this.listaItems.add((Item)obj);
    }


    public void agregarItemEnPos(int index,Item item){
        listaItems.add(index,item);
    }
    public void eliminar(Object obj){
        if(!isNull(obj) && obj instanceof Item)
            this.listaItems.remove((Item)obj);
    }

    public Item getItemFromFacturadosList(int index){
        return listaItems.get(index);
    }
    /*
    public String itemsFacturadosListToString(){
        String itemsFacturados="ITEMS FACTURADOS";
        for(Item item : getListaItems()){
            itemsFacturados=itemsFacturados.concat(item.toString());
        }
        return itemsFacturados;
    }
    */
    public void modificar(Object obj){
        int pos = 0;
        Item item=null;
        Scanner reader = new Scanner(System.in);
        if(!isNull(obj) && obj instanceof  Item){
            if(this.consultarItemPos((Item)obj) > -1){
                pos=this.consultarItemPos((Item)obj);
                item = listaItems.get(pos);
                System.out.println("Esta a punto de cambiar la cantidad de items.\n Ingrese la nueva cantidad\n");
                int modCase = reader.nextInt();
                switch(modCase){
                    case 1:{
                        int cant=0;
                        System.out.println("Cantidad actual: " + item.getCantidadBolsas());
                        System.out.println("Ingrese nueva cantidad: ");
                        cant = reader.nextInt();
                        if(cant > 0){
                            item.setCantidadBolsas(cant);
                        }
                        break;
                    }
                }
                System.out.println("Estado del item: " + item + "\nDesea confirmar los cambios? (s/n)");
                String cambios=reader.next();
                if(cambios.equals("S")||cambios.equals("s"))
                    listaItems.add(pos,item);
            }
        }
    }

    public void listar(){
        for (Item item : listaItems) {
            System.out.println(item);
        }
    }

    public String listaItemsToString(){
        String lista = "ITEMS\n";
        for(Item item : getListaItems()){
            lista=lista.concat(item.toString());
        }
        return lista;
    }

    public float calcularTotal(){
        float precioTotal = 0;
        for(Item item : getListaItems()){
            float precioVenta = item.calcularPrecioVentaPorProducto(item.getAlimento());
            precioTotal+= item.getCantidadBolsas() * precioVenta;
        }
        return precioTotal;
    }

    public int cantidadItem(){
        int cant=0;
        for(Item item : listaItems){
            cant++;
        }
        return cant;
    }

    public Item itemMasCaro(){
        Item itemMasCaro=listaItems.get(0);
        for(Item item : listaItems){
            if(itemMasCaro.getAlimento().getPrecioVenta() < item.getAlimento().getPrecioVenta())
                itemMasCaro = item;
        }
        return itemMasCaro;
    }
    ///le agrego item porque sino no se como chequear
    public boolean consultarItem(Item item){
        boolean exists = false;
        for(int i=0; i<getListaItems().size() && !exists; i++ ){
            exists = item.getAlimento().getNombre() == getItemFromFacturadosList(i).getAlimento().getNombre();
        }
        return exists;
    }
    public int consultarItemPos(Item item){
        int pos = -1;
        boolean exists = false;
        for(int i=0; i < getListaItems().size() && !exists ;i++ ){
            if(item.getAlimento().getNombre() == listaItems.get(i).getAlimento().getNombre()){
                pos = i;
                exists = true;
            }
        }
        return pos;
    }

}

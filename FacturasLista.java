/**Almacena todas las facturas generadas por el sistema*/

package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class FacturasLista  {
    private List<Factura>facturasLista;

    ///constructor
    public FacturasLista(){
        this.facturasLista = new ArrayList<>();
    }

    public List<Factura> getFacturasLista() {
        return facturasLista;
    }

    public void agregarFactura(Factura fact){
        if(!isNull(fact) && fact.isCerrada()){
            getFacturasLista().add(fact);
        }
    }

    public String toString(){
        String lista = "FACTURACION LISTA\n";

        for(Factura f : getFacturasLista()){
            lista = lista.concat("----\n" +f);
        }
        return lista;
    }

    public void listar(){
        for(Factura f : getFacturasLista()){
            System.out.println(f);
        }
    }

    public Factura consultarFacturaByNroFact(int nroFact){
        for(Factura f : getFacturasLista()){
            if(f.getNumeroFactura() == nroFact)
                return f;
        }
        return null;
    }

}

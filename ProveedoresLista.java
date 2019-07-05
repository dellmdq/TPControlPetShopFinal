package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.isNull;

public class ProveedoresLista {
    private List<Proveedor> proveedoresLista;

    ///constructor
    public ProveedoresLista(){
        this.proveedoresLista = new ArrayList<>();
    }


    public List<Proveedor> getProveedoresLista() {
        return proveedoresLista;
    }


    public void agregarProveedor(Proveedor proveedor){
        if(!isNull(proveedor) && !existeProveedor(proveedor)){
            getProveedoresLista().add(proveedor);
        }
    }

    public boolean existeProveedor(Proveedor proveedor){
        for (Proveedor prov : getProveedoresLista()) {
            if (prov.getId() == proveedor.getId()){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String lista = "Proveedores LISTA\n";

        for(Proveedor proveedor : getProveedoresLista()){
            lista = lista.concat("----\n" +proveedor);
        }
        return lista;
    }

    public void listar(){
        for (Proveedor prove : getProveedoresLista()) {
            System.out.println(prove);
        }
    }

    public Proveedor consultarProveedorPorID(int id){
        for(Proveedor p : getProveedoresLista()){
            if(p.getId() == id)
                return p;
        }
        return null;
    }

}

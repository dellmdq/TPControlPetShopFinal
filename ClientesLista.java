package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class ClientesLista {
    private List<Cliente> clientesLista;

    ///constructor
    public ClientesLista(){
        this.clientesLista = new ArrayList<>();
    }

    public List<Cliente> getClientesLista() {
        return clientesLista;
    }

    public void agregarCliente(Cliente cliente){
        if(!isNull(cliente) && !existeCliente(cliente)){
            getClientesLista().add(cliente);
        }
    }

    public boolean existeCliente(Cliente cliente){
        boolean existe = false;
        for (Cliente cli : getClientesLista()) {
            if (cli.getDni() == cliente.getDni()){
                existe = true;
            }
        }
        return existe;
    }

    public String toString(){
        String lista = "Clientes LISTA\n";

        for(Cliente cliente : getClientesLista()){
            lista = lista.concat("----\n" +cliente);
        }
        return lista;
    }

    public Cliente consultarByDNI(long dni){
        for(Cliente c : getClientesLista()){
            if(c.getDni() == dni)
                return c;
        }
        return null;
    }

    public void listarClientes(){
        for(Cliente c : getClientesLista()){
            System.out.println(c);
        }
    }

    public Cliente consultarClienteByDNI(long dni){
        for(Cliente c : getClientesLista()){
            if(c.getDni() == dni){
                return c;
            }
        }
        return null;
    }
}

package com.company;

import java.util.Scanner;

public class MenuCliente extends UI{
    public void uno(){
        Scanner reader = new Scanner(System.in);
        String control = "s";




        while(control.equals("s") || control.equals("S")){
            System.out.println("MENU CLIENTES.\n1)Listar Clientes.\n2)Consultar Cliente.\n3)Agregar Cliente Nuevo.\n" +
                    "Seleccion opcion:");
            int opcion = reader.nextInt();


            switch(opcion){
                case 1:{
                    getClientList().listarClientes();
                    break;
                }
                case 2:{
                    System.out.println("Ingrese DNI de cliente a buscar:");
                    System.out.println(getClientList().consultarClienteByDNI(reader.nextInt()));
                    break;
                }
                case 3:{
                    System.out.println("AGREGAR CLIENTE.");
                    getClientList().agregarCliente(generateCliente());
                    break;
                }
            }
            System.out.println("MENU CLIENTE. Desea realizar otra operacion?(s/n)");
            control=reader.next();
        }///fin while
    }

}

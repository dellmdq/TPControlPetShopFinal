package com.company;

import java.util.Scanner;

public class MenuProveedor extends UI {
    public void uno(){
        Scanner reader = new Scanner(System.in);
        String control = "s";


        while(control.equals("s") || control.equals("S")){
            System.out.println("MENU PROVEEDORES.\n1)Listar Proveedores.\n2)Consultar Proveedor.\n3)Agregar Proveedor Nuevo.\n" +
                    "Seleccion opcion:");
            int opcion = reader.nextInt();


            switch(opcion){
                case 1:{
                    getProveeList().listar();
                    break;
                }
                case 2:{
                    System.out.println("Ingrese ID de proveedor a buscar:");
                    System.out.println(getProveeList().consultarProveedorPorID(reader.nextInt()));
                    break;
                }
                case 3:{
                    System.out.println("AGREGAR PROVEEDOR.");
                    getProveeList().agregarProveedor(generateProveedor());
                    break;
                }
            }
            System.out.println("MENU CLIENTE. Desea realizar otra operacion?(s/n)");
            control=reader.next();
        }///fin while
    }


}

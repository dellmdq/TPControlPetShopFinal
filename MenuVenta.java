package com.company;

import java.util.Scanner;

public class MenuVenta extends UI {
    public void uno(){
        Scanner reader = new Scanner(System.in);
        String control = "s";

        while (control.equals("s") || control.equals("S")){
            System.out.println("MENU VENTAS. FACTURACION\n" +
            "1)Listar Facturas.\n2)Consultar factura.\n3)Facturar\n" +
            "Por favor seleccione opcion:");
            int opcion = reader.nextInt();
            switch (opcion) {
                case 1: {
                    System.out.println("LISTA DE FACTURAS.\n");
                    getFactList().listar();
                    break;
                }
                case 2:{
                    System.out.println("CONSULTA DE FACURA POR NRO.\n" +
                            "Ingrese nro de factura:");
                    int id = reader.nextInt();
                    System.out.println(getFactList().consultarFacturaByNroFact(id));
                    break;
                }
                case 3:{
                    String controlFact = "s";
                    System.out.println("FACTURACION,");
                    System.out.println(getClientList().toString());
                    System.out.println("Por favor ingrese dni de cliente:");
                    long dni = reader.nextLong();
                    Factura fact = generateFactura(getClientList().consultarByDNI(dni));
                    getStock1().listarStock();

                    while(controlFact.equals("s") || controlFact.equals("S")) {
                        System.out.println("Ingrese ID de item a agregar a factura:");
                        int id = reader.nextInt();
                        System.out.println("Ingrese cantidad a facturar:");

                        int cant = reader.nextInt();
                        try {
                            Item item = new Item(cant, getStock1().getItemByIdFromStock(id).getAlimento());
                            if (getStock1().suficienteCantidadEnStock(item)) {///validacion dentro del metodo lanzando excepcion
                                fact.agregarItemToFactura(item);
                            }else{
                                throw new Exception();
                            }
                            System.out.println("Desea agregar otro item a la factura?(s/n)");
                            controlFact = reader.next();
                        }catch (Exception e){
                            System.out.println("Error. Esta intentando quitar una cantidad de bolsas mayor a la existente en stock.");
                        }
                    }
                    System.out.println("Desea cerrar la factura? Se daran de baja bolsas de stock. (s/n)");
                    controlFact=reader.next();
                    if(controlFact.equals("s") || controlFact.equals("S")){
                        for(Item i : fact.getListaItems()){
                            getStock1().quitarBolsasStock(i);
                        }
                        fact.setCerrada(true);
                        getFactList().agregarFactura(fact);
                    }
                    else
                        System.out.println("Se cancelo generacion de factura.\n");
                    break;
                }//fin case 3

            }
            System.out.println("MENU VENTAS. FACTURACION. Desea realizar otra operacion?(s/n)");
            control=reader.next();
        }///fin while







    }
}

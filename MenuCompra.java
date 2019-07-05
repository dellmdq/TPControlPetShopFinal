package com.company;

import java.util.Scanner;

public class MenuCompra extends UI{
    public void uno(){
        System.out.println("Menu Compra. Ingreso de bolsas a stock.");
        Scanner reader = new Scanner(System.in);
        System.out.println("LISTADO DE ITEMS EN STOCK.\n");
        getStock1().listarStock();
        System.out.println("Seleccione nro ID de item en Stock para agregar bolsas:");
        int id = reader.nextInt();
        System.out.println("ITEM SELECCCIONADO es:");
        System.out.println(getStock1().getItemByIdFromStock(id));
        System.out.println("Ingrese la cantidad de bolsas a ingresar a stock:");
        int cant = reader.nextInt();
        Item item = new Item(cant,getStock1().getItemByIdFromStock(id).getAlimento());
        getStock1().agregarBolsasStock(item);
        System.out.println("Estado actualizado de item:");
        System.out.println(getStock1().getItemByIdFromStock(id));
    }
}

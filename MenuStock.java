/**Solo se podra agregar productos nuevos a traves de este menu.*/

package com.company;

import java.util.Scanner;

import static java.util.Objects.isNull;

public class MenuStock extends UI {

    public void uno() {
        Scanner reader = new Scanner(System.in);
        String control = "s";
        String s;
        int opcion;

        while(control.equals("s")||control.equals("S")){
            System.out.println("Por favor seleccione una opcion del Menu de Stock: \n" +
           "1)Ver Stock\n2)Ver Stock por Marca\n3)Capacidad Stock\n4)Estado bloqueado\n5)Agregar Producto Nuevo a Stock.");
            opcion = reader.nextInt();

            switch(opcion){
                case(1):{
                    super.getStock1().listarStock();
                    break;
                }
                case(2):{
                    System.out.println("Ingrese marca a buscar:");
                    s = reader.next();
                    super.getStock1().showByBrand(s);
                    break;
                }
                case(3):{
                    System.out.println("Capacidad Stock: " + (super.getStock1().getCapacidadDeposito()));
                    float capacidadRest = super.getStock1().getCapacidadDeposito() - super.getStock1().calculateNumberOfKilosStoraged();
                    System.out.println("Capacidad libre: " + (capacidadRest + (capacidadRest/super.getStock1().getCapacidadDeposito())));
                    break;
                }
                case(4):{
                    System.out.println("Ingrese ID de producto a cambiar de estado bloqueado: ");
                    int id = reader.nextInt();
                    boolean found = false;
                    int pos=-1;
                    if(!isNull(id)){
                        for(int i = 0; i<super.getStock1().getItemList().size() && !found; i++){
                            if(super.getStock1().getItemList().get(i).getAlimento().getId() == id) {
                                pos = i;
                                found = true;
                            }

                        }
                        if(found){
                            System.out.println("Estado actual bloqueo: " +super.getStock1().getItemList().get(pos).getAlimento().isBloqueado() + "\nDesea cambiarlo?(s/n)");
                            s = reader.next();
                            if(s.equals("s")||s.equals("S")) {
                                if (super.getStock1().getItemList().get(pos).getAlimento().isBloqueado())
                                    super.getStock1().getItemList().get(pos).getAlimento().setBloqueado(false);
                                else
                                    super.getStock1().getItemList().get(pos).getAlimento().setBloqueado(true);
                            }
                        }
                    }
                    break;
                }//fin case 4
                case(5):{
                    System.out.println("Agregando nuevo producto a stock.\nProducto ingresa a stock con cantidad cero.\n");
                    System.out.println("Seleccione id proveedor de la lista:");
                    getProveeList().listar();
                    int i = reader.nextInt();
                    Proveedor p = super.getProveeList().getProveedoresLista().get(i);
                    getStock1().agregarItemNuevoStockCantidadCero(generateItemInitial(generateAlimento(p)));
                    break;
                }
                default:{
                    System.out.println("Opcion ingresada es erronea.\n");
                }
            }
            System.out.println("CONTROL STOCK. Desea realizar otra operacion?(s/n)");
            control = reader.next();
        }
    }
}
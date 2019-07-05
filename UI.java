/**UI tendra todas las listas. Las clases Menu heredaran de esta las listas
 * para poder tener acceso.*/

package com.company;


import com.company.*;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class UI implements Serializable{

    ///Lista de facturas
    private static FacturasLista factList;

    ///Lista de Clientes
    private static ClientesLista clientList;

    ///Listas Proveedores
    private static ProveedoresLista proveeList;

    ///Stock
    private static Stock stock1;

    ///Menu Stock
    private static MenuStock menuStock;

    //Menu Compra
    private static MenuCompra menuCompra;

    //Menu Venta
    private static MenuVenta menuVenta;

    //Menu Cliente
    private static MenuCliente menuCliente;

    //Menu Proveedor
    private static MenuProveedor menuProveedor;

    /**GETTERS Y SETTERS**********************/

    public FacturasLista getFactList() {
        return factList;
    }

    private void setFactList(FacturasLista facturaList){factList = facturaList;}

    public ClientesLista getClientList() {
        return clientList;
    }

    private void setClientList(ClientesLista cList){
        clientList = cList;
    }

    public ProveedoresLista getProveeList() {
        return proveeList;
    }

    private void setProveeList(ProveedoresLista pList){
        proveeList = pList;
    }

    public Stock getStock1() {
        return stock1;
    }

    public MenuStock getMenuStock(){
        return menuStock;
    }


    public UI(){

    }


    protected static void MenuPrincipal() {
        factList = new FacturasLista();
        clientList = new ClientesLista();
        proveeList = new ProveedoresLista();
        stock1 = new Stock();
        menuProveedor = new MenuProveedor();
        menuVenta = new MenuVenta();
        menuCliente = new MenuCliente();
        menuCompra = new MenuCompra();
        menuStock = new MenuStock();

        /***********************************************************************************************************/
        /**ZONA INSTANCIAS PRUEBA***********************************************************************************/


        ///Instancias Vendedor
        //Vendedor vend1 = new Vendedor("Leonardo", "Simons", 2235332995L);
        //System.out.println(vend1);

        ///Instancias Proveedor
        Proveedor prov1 = new Proveedor("Migues SA", "Italia 2233", 30710036329L, 2234563299L, "migues@mail.com", proveeList);
        Proveedor prov2 = new Proveedor("LONCO SA", "Saavedra 223", 30230036129L, 2234223299L, "pedidos@lonco.com", proveeList);
        //System.out.println(prov1);

        ///Instancias AlimentoPerro, AlimentoGato.
        Alimento alimP1 = new Alimento("Dog Chow Medianas/Grandes 21kgs","Perro",prov1, 1750f, 2000f,"Dog Chow", "Carne", 22f, "Razas Medianas/Grandes", 21f);
        Alimento alimP2 = new Alimento("Dog Chow Medianas/Grandes 21kgs","Perro",prov1, 1750f, 2000f,"Dog Chow", "Pollo", 22f, "Razas Medianas/Grandes", 21f);
        Alimento alimP3 = new Alimento("Dog Chow Medianas/Grandes 21kgs","Perro",prov1, 1750f, 2400f ,"Dog Chow", "Carne", 22f, "Razas Medianas/Grandes", 21f);
        Alimento alimP4 = new Alimento("Ganacan 22Kgs","Perro",prov2,485f,600f,"Ganacan","CarnePolloHigado",18f,"Adulto",22f);
        //System.out.println(alimP3);
        //System.out.println(alimP1);
        //System.out.println(alimP2);
        Alimento alimG1 = new Alimento("Excellent Gato Adulto 15kgs","Gato" ,prov1, 2240f, 2600f,"Excellent", "Pollo y Arroz", 30f, "Gato Adulto", 15f);
        //System.out.println(alimG1);
        Alimento alimG2 = new Alimento("Excellent Gato Adulto 7,5Kgs","Gato" ,prov1, 1200f, 1750f,"Excellent", "Pollo y Arroz", 30f, "Gato Adulto", 7.5f);

        ///Items
        Item item1 = new Item(2,alimP1);
        Item item2 = new Item(1,alimG1);
        Item item3 = new Item(1,alimP1);
        //Item item4 = new Item(10,alimP4);
        //System.out.println(item1.equals(item1));///true
        //System.out.println(item1.equals(item2));//false


        //System.out.println(item1);


        //Instancias stock

        stock1.agregarItemNuevoStockCantidadCero(item1);
        stock1.agregarItemNuevoStockCantidadCero(item2);
        //stock1.agregarItemNuevoStockCantidadCero(item4);
        stock1.agregarBolsasStock(item1);
        stock1.agregarBolsasStock(item1);
        stock1.agregarBolsasStock(item2);
        //stock1.agregarBolsasStock(item4);
        //stock1.quitarBolsasStock(item3);
        //stock1.quitarBolsasStock(item1);
        //System.out.println(stock1.suficienteCantidadEnStock(item1));

        //stock1.listarStock();
        //System.out.println(stock1.existeItemEnLista(alimG1));
        //System.out.println(stock1.existeItemEnLista(alimG2));
        //stock1.quitarStock(alimG1);
        ///stock1.listarStock();
        ///stock1.listarStock();
        ///System.out.println(stock1.calculateNumberOfKilosStoraged());
        //stock1.showByBrand("Dog Chow");

        //System.out.println("Cantidad de bolsas en stock: " + stock1.calculateNumberOfKilosStoraged());


        ///Clientes
        Cliente cliente1 = new Cliente(34343077L, "Fabian", "Garcia", clientList);
        //System.out.println(cliente1);
        Cliente cliente2 = new Cliente(34656521L,"Pepe","Grillo",clientList);
        Cliente cliente3 = new Cliente(12457123L,"Fede","Guevara",clientList);
        Cliente cliente4 = new Cliente(23489221L,"Gaston","Gaudio",clientList);

        ///Facturas
        /*
        Factura factura1 = new Factura("1/7/2019", cliente1,factList);
        factura1.setCerrada(true);
        factura1.agregarItemToFactura(item1);
        */
        /*
        factList.agregarFactura(factura1);
        Factura factura2 = new Factura("1/7/2019", cliente1,factList);
        factura2.setCerrada(true);
        Factura factura3 = new Factura("1/7/2019", cliente1,factList);
        factura3.setCerrada(true);
        factura1.agregarItemToFactura(item2);
        factura2.agregarItemToFactura(item1);
        factura3.agregarItemToFactura(item2);
        */
        //System.out.println(factList);
        //factura1.listar();
        //factura1.modificar(item1);
        //System.out.println("La cantidad de items a facturar son : " + factura1.cantidadItem());

        //System.out.println("mostrar por marca \n");
        //stock1.showByBrand("Dog Chow");


        int menuPrincipal;
        Scanner reader = new Scanner(System.in);
        String control = "n";//volvimos a c



        ///String nombres de archivos.
        String fileFactura = "fileFactura";



        while (control.equals("n") || control.equals("N")){




            System.out.println("CONTROL STOCK PET SHOP\n" +
                    "Menu Stock\n" + "\n1)Stock\n2)Compras\n3)Ventas\n4)Clientes\n5)Proveedores\n6)Guardar datos.(PRUEBA).\n7)Leer datos.(PRUEBA)\n" +
                    "Por favor seleccione opcion:");
            menuPrincipal = reader.nextInt();
            switch (menuPrincipal) {
                case 1: {
                    menuStock.uno();
                    break;
                }
                case 2:{
                    menuCompra.uno();
                    break;
                }
                case 3:{
                    menuVenta.uno();
                    break;
                }
                case 4:{
                    menuCliente.uno();
                    break;
                }
                case 5:{
                    menuProveedor.uno();
                    break;
                }
                case 6:{
                    //Persistencia FacturaLista
                  try {
                      PersistenceCollecion<Factura> facturaPersistenceCollecion = new PersistenceCollecion<>();
                      facturaPersistenceCollecion.WriteIntoFile(factList.getFacturasLista(), fileFactura);
                  }catch (Exception e){
                      System.out.println("Fallo escritura de archivo lista de facturas.");
                  }
                  break;
                  }//fin case 6
                case 7:{
                    try{
                        PersistenceCollecion<Factura> facturaPersistenceCollecion = new PersistenceCollecion<>();
                        List<Factura> facturaList=factList.getFacturasLista();
                        System.out.println(facturaList=facturaPersistenceCollecion.ReadFromFile(fileFactura));

                    }catch (Exception e){
                        System.out.println("Fallo lectura de archivo lista de facturas.\n");
                    }
                }
                break;
            }//fin case 7
            System.out.println("MENU PRINCIPAL. Desea salir del programa?(s/n)");
            control=reader.next();
        }
    }

    public static Proveedor generateProveedor(){
        Scanner reader = new Scanner(System.in);
        System.out.println("CREACION NUEVO PROVEEDOR.");
        System.out.println("Ingrese nombre de la compañia:");
        String nombre = reader.next();
        System.out.println("Ingrese dirección:");
        String direccion = reader.next();
        System.out.println("Ingrese CUIT: ");
        long cuit = reader.nextLong();
        System.out.println("Ingrese nro telefono:");
        long telefono = reader.nextLong();
        System.out.println("Ingrese email:");
        String mail = reader.next();

        return new Proveedor(nombre,direccion,cuit,telefono,mail,proveeList);
    }

    public static Alimento generateAlimento(Proveedor proveedor){
        Scanner reader = new Scanner(System.in);
        System.out.println("CREACION NUEVO ALIMENTO");
        System.out.println("Ingrese nombre de alimento. (Nomenclatura: NombreTipoAnimalTipoAlimentoSaborKGSxBolsa):");
        String alimento = reader.next();
        System.out.println("Ingrese animal:");
        String animal = reader.next();
        System.out.println("Ingrese precio de costo:");
        float precioCosto = reader.nextFloat();
        System.out.println("Ingrese nombre de la marca:");
        String marca = reader.next();
        System.out.println("Ingrese el sabor:");
        String sabor = reader.next();
        System.out.println("Ingrese % de proteina bruta:");
        float crudeProtein = reader.nextFloat();
        System.out.println("Ingrese tipo:");
        String tipo = reader.next();
        System.out.println("Ingrese numero de kgs por bolsa:");
        float nrokg = reader.nextFloat();

        return new Alimento(alimento,animal,proveedor,precioCosto,marca,sabor,crudeProtein,tipo,nrokg);
    }

    public static Item generateItem(Alimento p){
        Scanner reader = new Scanner(System.in);
        System.out.println("CREACION NUEVO ITEM");
        System.out.println("Ingrese cantidad:");
        int cantidad = reader.nextInt();
        return new Item(cantidad,p);
    }

    public static Item generateItemInitial(Alimento p){
        Scanner reader = new Scanner(System.in);
        System.out.println("CREACION NUEVO ITEM");
        return new Item(0,p);
    }

    public static Factura generateFactura(Cliente cliente){
        Scanner reader = new Scanner(System.in);
        System.out.println("CREACION NUEVA FACTURA");
        System.out.println("Ingrese fecha:");
        String fecha = reader.next();

        return new Factura(fecha, cliente);
    }

    public static Cliente generateCliente(){
        Scanner reader = new Scanner(System.in);
        System.out.println("CREACION NUEVO CLIENTE");
        System.out.println("Ingrese DNI:");
        long dni = reader.nextLong();
        System.out.println("Ingrese nombre:");
        String nombre = reader.next();
        System.out.println("Ingrese apellido:");
        String apellido = reader.next();

        return new Cliente(dni, nombre, apellido, clientList);
    }


}

package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class Stock implements Serializable,IConsultasStock {
    private float capacidadDeposito = 50000;
    private List<Item> itemList;

    ///constructor

    public Stock() {
        itemList = new ArrayList<Item>();
    }

    ///getter

    public List<Item> getItemList() {
        return itemList;
    }

    public float getCapacidadDeposito() {
        return capacidadDeposito;
    }

    ///methods
    /**PROBADO? OK*/
    public boolean existeItemEnLista(Item item1){
        if (item1 != null){
            for (Item item : getItemList()) {
                if (item.getAlimento().equals(item1.getAlimento())){
                    return true;
                }
            }
        }
        return false;
    }

    /**PROBADO? OK*/
    /**Metodo para agregar un item nuevo al stock. Con cantidad cero.*/
    public void agregarItemNuevoStockCantidadCero(Item item){
        try{
            if(!isNull(item) && !existeItemEnLista(item)){
                Item aux = new Item(item.getAlimento());///item seteado sin id
                aux.setCantidadBolsas(0);
                getItemList().add(aux);
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("Error en agregarItemNuevoStockCantidadCero");
        }
    }

    /**PROBADO? OK*/
    /**Metodo para agregar bolsas para items existentes en el stock.*/
    public void agregarBolsasStock(Item item){
        try {
            if (!isNull(item) && existeItemEnLista(item)) {
                int pos = -1;
                int cant = 0;
                pos = getItemList().indexOf(item);
                cant = getItemList().get(pos).getCantidadBolsas();//cantidad bolsas en stock
                cant += item.getCantidadBolsas(); //cantidad bolsas a agregar en stock
                getItemList().get(pos).setCantidadBolsas(cant);//asigna nueva cantidad al item en stock
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("Error en agragarBolsasStock.");
        }
    }

    /**PROBADO? OK*/
    /**Valida que la cantidad del item sea menor o igual a la existente en stock*/
    public boolean suficienteCantidadEnStock(Item item){
        int pos = getItemList().indexOf(item);
        if(!isNull(item) && item.getCantidadBolsas() <= getItemList().get(pos).getCantidadBolsas() ){
            return true;
        }
        return false;
    }

    /**PROBADO? OK*/
    public void quitarBolsasStock(Item item){
        try {
            int pos = -1;
            if (!isNull(item)) {
                pos = getItemList().indexOf(item);
                if (pos != -1 && this.suficienteCantidadEnStock(item)) {
                    getItemList().get(pos).setCantidadBolsas(getItemList().get(pos).getCantidadBolsas() - item.getCantidadBolsas());
                }
                else{
                    throw new Exception();
                }
            }
        }catch(Exception e){
            System.out.println("Error en quitarBolsasStock. Esta quitando una cantidad mayor de bolsas a la existente.");
        }
    }

    /**PROBADO? OK*/
    public void listarStock() {
        if(getItemList()!=null){
            for(Item item : getItemList())
                System.out.println(item);
        }
    }

    /**PROBADO? OK*/
    @Override
    public float calculateNumberOfKilosStoraged() {
        float numberOfKilos = 0;
        if (itemList != null) {
            for (Item item : getItemList()) {
                numberOfKilos += item.getAlimento().getNumberOfKilos() * item.getCantidadBolsas();
            }
        }
        return numberOfKilos;
    }


    /**PROBADO? OK*/
    @Override
    public void showByBrand(String brand){
        try {
            if (brand != null) {
                for (Item item : getItemList()) {
                    if(item.getAlimento().getBrandName().equals(brand))
                        System.out.println(item.toString());
                }
            }
            else
                throw new Exception();
        } catch (Exception e) {
            System.out.println("Hubo un inconvenientes con el listado del Alimento");
        }
    }

    /**PROBADO?*/
    public Item getItemByIdFromStock(int id){
        for(Item item1 : getItemList()){
            if(item1.getId() == id){
                return item1;
            }
        }
        return null;
    }
}

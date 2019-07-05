package com.company;


import java.io.Serializable;

public class Proveedor implements Serializable {
    private static int idCount=0;
    private int id;
    private String CompanyName;
    private  String adreess;
    private long cuit;
    private long phone;
    private String email;

    ///constructor

    public Proveedor(String companyName, String adreess, long cuit, long phone, String email, ProveedoresLista proveedoresLista) {
        setId();
        setCompanyName(companyName);
        setAdreess(adreess);
        setCuit(cuit);
        setPhone(phone);
        setEmail(email);
        proveedoresLista.agregarProveedor(this);
    }

    ///getters and setters
    private void setId(){
        this.id = idCount++;
    }

    public int getId(){
        return this.id;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getAdreess() {
        return adreess;
    }

    public void setAdreess(String adreess) {
        this.adreess = adreess;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    ///methods
    @Override
    public String toString() {
        String message = "ID: %d || Nombre: %s || Direccion: %s || Cuit: %d\nTelefono: %d || Email: %s";
        return  String.format(message,getId(), getCompanyName(), getAdreess(), getCuit(), getPhone(), getEmail());
    }

    public boolean equals(Object o){
        if(o instanceof Proveedor){
            return ((Proveedor)o).getCompanyName() == this.getCompanyName();
        }
        return false;
    }

}
/**    public Alimento(String nombre,String animal, Proveedor company, float precioCosto,
 *  String unidadDeMedida, String brandName, String taste, float crudeProtein, String type, float numberOfKilos) {
 super(nombre, company, precioCosto, unidadDeMedida);*/
/** public Proveedor(String companyName, String adreess, long cuit, long phone, String email, ProveedoresLista proveedoresLista) o*/
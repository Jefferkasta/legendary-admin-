package com.legendaryadmin;

public class Empresa {
    private String nombre;
    private String direccion;
    private String telefono;
    private int nitEmpresa;

    public Empresa(String nombre, String direccion, String telefono, int nitEmpresa) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nitEmpresa = nitEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(int nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }
}

package com.example.inmobiliaria.datos;

import java.util.UUID;

public class inmueble {
    private String id;
    private Double precio;
    private String moneda;
    private String propiedad;
    private String operacion;
    private String descripcion;
    private String ciudad;
    private String provincia;
    private String imagen;
    private String latitud;
    private String longitud;


public inmueble(Double precio,String moneda,String propiedad,String operacion, String descripcion,String ciudad,String provincia, String imagen,String latitud,String longitud){

this.id= UUID.randomUUID().toString();
this.precio=precio;
this.moneda=moneda;
this.propiedad=propiedad;
this.operacion=operacion;
this.descripcion=descripcion;
this.ciudad=ciudad;
this.provincia=provincia;
this.imagen=imagen;
this.latitud=latitud;
this.longitud=longitud;
}

public String getId(){return id;}
    public Double getPrecio(){return precio;}
    public String getMoneda(){return moneda;}
    public String getPropiedad(){return propiedad;}
    public String getOperacion(){return operacion;}
    public String getDescripcion(){return descripcion;}
    public String getCiudad(){return ciudad;}
    public String getProvincia(){return provincia;}
    public String getImagen(){return imagen;}
    public String getLatitud(){return latitud;}
    public String getLongitud(){return longitud;}





}

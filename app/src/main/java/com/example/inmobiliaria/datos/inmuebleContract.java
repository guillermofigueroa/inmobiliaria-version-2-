package com.example.inmobiliaria.datos;

import android.provider.BaseColumns;

public class inmuebleContract {

private inmuebleContract(){

}

public static class inmuebleEntry implements BaseColumns {


public static final String TABLE_NAME = "t_inmuebles";
public static final String _ID = "id";
public static final String COLUMN_NAME_PRECIO = "precio";
public static final String COLUMN_NAME_MONEDA = "moneda";
public static final String COLUMN_NAME_PROPIEDAD = "propiedad";
public static final String COLUMN_NAME_OPERACION = "operacion";
public static final String COLUMN_NAME_DESCRIPCION = "descripcion";
public static final String COLUMN_NAME_CIUDAD = "ciudad";
public static final String COLUMN_NAME_PROVINCIA = "provincia";
public static final String COLUMN_NAME_IMAGEN ="imagen";
public static final String COLUMN_NAME_LATITUD="latitud";
public static final String COLUMN_NAME_LONGITUD="longitud";

}


}

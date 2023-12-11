package com.example.inmobiliaria.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.inmobiliaria.datos.inmuebleContract.inmuebleEntry;

public class dbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "inmobiliaria.db";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + inmuebleEntry.TABLE_NAME + " (" +
                    inmuebleEntry._ID + " INTEGER PRIMARY KEY," +
                    inmuebleEntry.COLUMN_NAME_PRECIO + " DOUBLE," +
                    inmuebleEntry.COLUMN_NAME_MONEDA + " TEXT," +
                    inmuebleEntry.COLUMN_NAME_PROPIEDAD + " TEXT," +
                    inmuebleEntry.COLUMN_NAME_OPERACION + " TEXT," +
                    inmuebleEntry.COLUMN_NAME_DESCRIPCION + " TEXT," +
                    inmuebleEntry.COLUMN_NAME_CIUDAD + " TEXT," +
                    inmuebleEntry.COLUMN_NAME_PROVINCIA + " TEXT," +
                    inmuebleEntry.COLUMN_NAME_IMAGEN + " TEXT," +
                    inmuebleEntry.COLUMN_NAME_LATITUD + " TEXT," +
                    inmuebleEntry.COLUMN_NAME_LONGITUD + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + inmuebleEntry.TABLE_NAME;

    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w("dbHelper", "Actualizando desde la version "+oldVersion+
                " a la version "+newVersion+". Se eliminaran todos los datos");
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);

    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }




}

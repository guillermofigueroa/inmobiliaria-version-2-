package com.example.inmobiliaria;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.inmobiliaria.datos.dbHelper;
import com.example.inmobiliaria.datos.inmuebleContract.inmuebleEntry;

public class publicarActivity extends AppCompatActivity {
    private dbHelper dbIn;
private EditText txtPrecio,txtMoneda,txtPropiedad,txtOperacion,txtDescripcion,txtCiudad,txtProvincia,txtImagen,txtLatitud,txtLongitud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar);

        txtPrecio = findViewById(R.id.text_precio);
        txtMoneda = findViewById(R.id.text_moneda);
        txtPropiedad = findViewById(R.id.text_propiedad);
        txtOperacion = findViewById(R.id.text_operacion);
        txtDescripcion = findViewById(R.id.text_descripcion);
        txtCiudad = findViewById(R.id.text_ciudad);
        txtProvincia = findViewById(R.id.text_provincia);
        txtImagen = findViewById(R.id.text_imagen);
        txtLatitud = findViewById(R.id.text_latitud);
        txtLongitud = findViewById(R.id.text_longitud);


        dbIn = new dbHelper(this);

        Button botonGuardar = findViewById(R.id.boton_agregar);

botonGuardar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        guardarInmueble();
    }

});
    }

public void guardarInmueble(){

    SQLiteDatabase db = dbIn.getWritableDatabase();

    ContentValues valores = new ContentValues();

valores.put(inmuebleEntry.COLUMN_NAME_PRECIO, txtPrecio.getText().toString());
valores.put(inmuebleEntry.COLUMN_NAME_MONEDA, txtMoneda.getText().toString());
valores.put(inmuebleEntry.COLUMN_NAME_PROPIEDAD, txtPropiedad.getText().toString());
valores.put(inmuebleEntry.COLUMN_NAME_OPERACION, txtOperacion.getText().toString());
valores.put(inmuebleEntry.COLUMN_NAME_DESCRIPCION, txtDescripcion.getText().toString());
valores.put(inmuebleEntry.COLUMN_NAME_CIUDAD, txtCiudad.getText().toString());
valores.put(inmuebleEntry.COLUMN_NAME_PROVINCIA, txtProvincia.getText().toString());
valores.put(inmuebleEntry.COLUMN_NAME_IMAGEN, txtImagen.getText().toString());
valores.put(inmuebleEntry.COLUMN_NAME_LATITUD, txtLatitud.getText().toString());
    valores.put(inmuebleEntry.COLUMN_NAME_LONGITUD, txtLongitud.getText().toString());


    long newRowId = db.insert(inmuebleEntry.TABLE_NAME, null, valores);

    if(newRowId!=-1){
        Toast.makeText(this, "Inmueble Guardado", Toast.LENGTH_LONG).show();
        finish();
    }else{
        Toast.makeText(this, "Error al Guardar el Inmueble", Toast.LENGTH_LONG).show();
    }

}

    @Override
    public void onDestroy(){
        dbIn.close();
        super.onDestroy();
    }



}
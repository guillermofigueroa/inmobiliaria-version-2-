package com.example.inmobiliaria;

import static com.example.inmobiliaria.datos.inmuebleContract.inmuebleEntry.COLUMN_NAME_CIUDAD;
import static com.example.inmobiliaria.datos.inmuebleContract.inmuebleEntry.COLUMN_NAME_DESCRIPCION;
import static com.example.inmobiliaria.datos.inmuebleContract.inmuebleEntry.COLUMN_NAME_IMAGEN;
import static com.example.inmobiliaria.datos.inmuebleContract.inmuebleEntry.COLUMN_NAME_LATITUD;
import static com.example.inmobiliaria.datos.inmuebleContract.inmuebleEntry.COLUMN_NAME_LONGITUD;
import static com.example.inmobiliaria.datos.inmuebleContract.inmuebleEntry.COLUMN_NAME_MONEDA;
import static com.example.inmobiliaria.datos.inmuebleContract.inmuebleEntry.COLUMN_NAME_OPERACION;
import static com.example.inmobiliaria.datos.inmuebleContract.inmuebleEntry.COLUMN_NAME_PRECIO;
import static com.example.inmobiliaria.datos.inmuebleContract.inmuebleEntry.COLUMN_NAME_PROPIEDAD;
import static com.example.inmobiliaria.datos.inmuebleContract.inmuebleEntry.COLUMN_NAME_PROVINCIA;
import static com.example.inmobiliaria.datos.inmuebleContract.inmuebleEntry.TABLE_NAME;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inmobiliaria.datos.dbHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class filtradoActivity extends ListActivity {

    private dbHelper db;
    private List<Map<String, Object>> inmuebles;

    private String lat;
    private String lon;

    ImageView img;
    String image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtrado);


        String[] datos = {"precio", "moneda", "propiedad","operacion","descripcion","ciudad","provincia","imagen","latitud","longitud"};
        int[] vistas = {R.id.precio, R.id.moneda, R.id.propiedad, R.id.operacion, R.id.descripcion,R.id.ciudad,R.id.provincia,R.id.imagen,R.id.latitud,R.id.longitud};

        db = new dbHelper(this);

        SimpleAdapter adaptador =
                new SimpleAdapter(this, listadoInmuebles(),
                        R.layout.list_inmuebles, datos, vistas);

        setListAdapter(adaptador);



    }

    private List<Map<String, Object>> listadoInmuebles() {

        inmuebles = new ArrayList<Map<String, Object>>();

        Map<String, Object> inm = new HashMap<String, Object>();

        SQLiteDatabase dbI = db.getReadableDatabase();

        Intent intencion=getIntent();

        String srtOp=intencion.getStringExtra("keyOp");
        String srtProp=intencion.getStringExtra("keyProp");
        String srtUbi=intencion.getStringExtra("keyUbi");

        Cursor cursor = dbI.rawQuery("SELECT * FROM " + 
                TABLE_NAME + " WHERE " +
                COLUMN_NAME_PROVINCIA + " ==? " + " AND " +
                COLUMN_NAME_OPERACION + "==?" + " AND " +
                COLUMN_NAME_PROPIEDAD + "==?",new String[]{srtUbi,srtOp,srtProp});

        cursor.moveToFirst();

        for (int i=0; i < cursor.getCount(); i++){

            inm = new HashMap<String, Object>();
            inm.put(COLUMN_NAME_PRECIO, cursor.getDouble(1));
            inm.put(COLUMN_NAME_MONEDA, cursor.getString(2));
            inm.put(COLUMN_NAME_PROPIEDAD,cursor.getString(3));
            inm.put(COLUMN_NAME_OPERACION,cursor.getString(4));
            inm.put(COLUMN_NAME_DESCRIPCION,cursor.getString(5));
            inm.put(COLUMN_NAME_CIUDAD,cursor.getString(6));
            inm.put(COLUMN_NAME_PROVINCIA,cursor.getString(7));
            inm.put(COLUMN_NAME_IMAGEN,cursor.getString(8));
            inm.put(COLUMN_NAME_LATITUD,cursor.getString(9));
            inm.put(COLUMN_NAME_LONGITUD,cursor.getString(10));

            inmuebles.add(inm);
            cursor.moveToNext();

        }

        cursor.close();
        return inmuebles;
    }


    public void onListItemClick(ListView parent, View v, int posicion, long id) {
        Map<String, Object> item = inmuebles.get(posicion);
        Toast.makeText(getBaseContext(), "Ha seleccionado " + item.get("propiedad").toString(), Toast.LENGTH_LONG).show();

    }

  public void onClick(View view){

TextView la=(TextView)findViewById(R.id.latitud);
TextView lo=(TextView)findViewById(R.id.longitud);

       lat=String.valueOf(la.getText());
       lon=String.valueOf(lo.getText());

       Intent intencion =new Intent(this,mapaActivity.class);

       intencion.putExtra("keyLat",lat);
       intencion.putExtra("keyLon",lon);
        startActivity(intencion);

   }


}
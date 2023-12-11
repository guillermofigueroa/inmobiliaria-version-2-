package com.example.inmobiliaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class buscarActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtUbi;
    String[] items_1 = {"ventas","alquileres","compras"};
    AutoCompleteTextView auto_Complete_op;
    ArrayAdapter<String> adapterItems;

    String[] items_2 ={"casas","departamentos","terrenos","locales comerciales"};
    AutoCompleteTextView auto_Complete_inm;
    ArrayAdapter<String> adapterItems_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        txtUbi=findViewById(R.id.campo_ubicacion);

Button buscar = findViewById(R.id.boton_buscar);
buscar.setOnClickListener(this);


        auto_Complete_op=findViewById(R.id.auto_Complete_op);

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items_1);

        auto_Complete_op.setAdapter(adapterItems);

        auto_Complete_op.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item"+item,Toast.LENGTH_SHORT).show();
            }
        });

        auto_Complete_inm=findViewById(R.id.auto_Complete_inm);

        adapterItems_2 = new ArrayAdapter<String>(this,R.layout.list_item,items_2);

        auto_Complete_inm.setAdapter(adapterItems_2);

        auto_Complete_inm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item2"+item2,Toast.LENGTH_SHORT).show();
            }
        });

    }

public void onClick(View view){

        String op=auto_Complete_op.getText().toString();
        String prop=auto_Complete_inm.getText().toString();
        String ubi=txtUbi.getText().toString();

        Intent intencion = new Intent(this, filtradoActivity.class);

    intencion.putExtra("keyOp",op);
    intencion.putExtra("keyProp",prop);
    intencion.putExtra("keyUbi",ubi);
    startActivity(intencion);


}

}
package com.nextsofts.asteroides;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Puntuaciones extends ListActivity {


    /*el identificador simple_list_item_1 es un layout ya definido en el sistema por eso antes de R ponemos android
     * el ultimo parametro es el arrar con el contenido de strings amostrar*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puntuaciones);
        setListAdapter(new MiAdaptador(Puntuaciones.this,
                MainActivity.almacen.listaPuntuaciones(10)));
    }
}

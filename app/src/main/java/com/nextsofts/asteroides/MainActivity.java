package com.nextsofts.asteroides;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static AlmacenPuntuacines almacen;
    /*en la linea 22  lo que se hace es acceder al metodo de la clase padre osea AppCompatActivity
    *la insancia BUndle lo que hace es guardar el estado de nuestra app para que no hayga perdida de informacion al cerrar
    * en la linea 24 se crea una referencia a la clase
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        almacen=new AlmacenPuntuacionesArray();
    }
    /*metodo listener que espera la accion de un objeto View para poderse ejecutar
    * ¿que se necesita para ejecutar este medodo?res.-un objeto View*/
    public void lanzarAcercaDe(View v){
        Intent i=new Intent(MainActivity.this,AcercaDe.class);
        startActivity(i);
    }
    /*este metodo lo que nos permite hacer es salir de la actividad de la que estamos acutalmente
    * el metodo finish() es un metodo interno de la clase padre  AppCompatActivity*/
    public void salir(View v){
        finish();
    }
    /*metodo que nos permite crear un menu  con opciones.
    * crear obciones de menu*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    /*metodo de opciones de elementos seleccionables.
    * que parametro de entrada necesito para ejecutar este metodo? res.- elementos del menu ovbio*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.acercaDe:
                lanzarAcercaDe(null);
                break;
            case R.id.configuracion:
                lanzarPreferencias(null);
                break;
        }
        return true;
    }
    /*que parametro de entrada necesitamos para ejecutar este metodo? res.-un objeto vista*/
    public void lanzarPreferencias(View v){
        Intent i=new Intent(MainActivity.this,Preferencias.class);
        startActivity(i);
    }
    /*metodo que me permite recuperar los valores de las preferencias*/
    public void mostrarPreferencias(View v){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String s = "música: "+ pref.getBoolean("musica",true)
                +", gráficos: " + pref.getString("graficos","?");
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    /*metodo que me permite navegar desde esta actividad asta otra actividad de nombre puntuaciones*/
    public void lanzarPuntuaciones(View v){
        Intent i=new Intent(MainActivity.this,Puntuaciones.class);
        startActivity(i);
    }
}

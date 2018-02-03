package com.nextsofts.asteroides;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static AlmacenPuntuacines almacen;

     /*static por que el contenido de la variable no cambiara ej pi=0.213434(esto es statico nunca cambia)
     * en el caso de final se pone para decir que solo va ocupar un espacio de memoria y no mas de uno malgastando pues*/

    @Override
    /*se llama en la creacion del IU, tbm se utiliza para realizar todo tipo de inicializaciones de estructuras de datos,
     puede recibir inicializacion de estado de la actividad
    * en una instancia de clase bundle , por si se reanuda desde una actividad que ha sido destruida y vuelta a crear*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"oncreate",Toast.LENGTH_SHORT).show();
        almacen=new AlmacenPuntuacionesArray();
        MediaPlayer mp=MediaPlayer.create(this,R.raw.audio);
        mp.start();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        //mp.stop();
    }
    @Override
    /*nos indica que la actividad esta apunto de mostrarse al usuario*/
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show();
    }
    @Override
    /*se llama cuando la activida va a comenzar a interactuar con el usuario, es un buen lugar para lanzar las animaciones y
    * la musica*/
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume",Toast.LENGTH_LONG).show();
    }
    @Override
    /*indica que la actividad esta apunto de ser lanzada a segundo plano, esto normalmente por que se lanzo otra actividad, es
    * el lugar adecuado para detener animacines, musica o almacenar los datos que estaban en la edicion*/
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause",Toast.LENGTH_LONG).show();
    }
    @Override
    /*la actividad ya no sera vicible para el usuario*/
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop",Toast.LENGTH_LONG).show();
    }
    @Override
    /*indica que la actividad volvera  a ser representada despues de haber pasado por onStop()*/
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart",Toast.LENGTH_LONG).show();
    }
    @Override
    /*se llama antes de que laactividad sea totalmente destruida, por ejemplo cuando el usuario pulsa el boton volver o
     * cuando se llama al metodo finish()*/
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show();
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

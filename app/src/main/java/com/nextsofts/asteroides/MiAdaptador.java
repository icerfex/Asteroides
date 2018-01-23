package com.nextsofts.asteroides;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

/**
 * en esta clse tbm se indica la actividad en donde se ejecutara este adaptador
 * Created by ariel on 21-12-17.
 */
public class MiAdaptador extends BaseAdapter {
    private final Activity actividad;
    private final Vector<String> lista;

    public MiAdaptador(Activity actividad, Vector<String> lista) {
        super();
        this.actividad = actividad;
        this.lista = lista;
    }
    /*con este metodo se construye un nuevo objeto View que se visualizara en la posicion x
    * lo ultimo que se hace es añadirse al contenedor de vistas
    * inicialmente podemos partir de una vista base como lo es convertView esto para generar mas rapido este objeto
    * este metodo lo que hara es construir los diferentes vistas que se añadiran a la lista
    * LayoutInflater lo que hace es construir un objeto View*/
    public View getView(int position, View convertView,ViewGroup parent) {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View view = inflater.inflate(R.layout.elemento_lista, null, true);
        TextView textView =(TextView)view.findViewById(R.id.titulo);
        textView.setText(lista.elementAt(position));
        ImageView imageView=(ImageView)view.findViewById(R.id.icono);
        switch (Math.round((float)Math.random()*3)){
            case 0:
                imageView.setImageResource(R.drawable.asterisco);
                break;
            case 1:
                imageView.setImageResource(R.drawable.ic_launcher_corazones);
                break;
            default:
                imageView.setImageResource(R.drawable.asterisco);
                break;
        }
        return view;
    }
    /*metodo geter para conocer el tamaño del vector lista*/
    public int getCount() {
        return lista.size();
    }
    /*metodo geter para botener un bojeto de la lista de objetos esto pido con un id de posicion*/
    public Object getItem(int arg0) {
        return lista.elementAt(arg0);
    }
    /*metodo que me permite obtener la posicion de un id del vector lista*/
    public long getItemId(int position) {
        return position;
    }
}

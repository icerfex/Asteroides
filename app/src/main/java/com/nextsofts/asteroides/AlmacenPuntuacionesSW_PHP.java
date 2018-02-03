package com.nextsofts.asteroides;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Vector;

/**
 * Created by ariel on 02-02-18.
 */
public abstract class AlmacenPuntuacionesSW_PHP implements AlmacenPuntuacines{

    public Vector<String> listaPuntuaciones(int cantidad){
        Vector<String> result=new Vector<String>();
        try {
            URL url=new URL("http://192.168.1.2/puntuaciones/lista.php"+"?max=20");
            HttpURLConnection conexion=(HttpURLConnection) url.openConnection();
            if (conexion.getResponseCode()==HttpURLConnection.HTTP_OK){
                BufferedReader reader=new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea=reader.readLine();
                while (!linea.equals("")){
                    result.add(linea);
                    linea=reader.readLine();
                }
                reader.close();
                return result;
            }else {
                Log.e("Asteroides",conexion.getResponseMessage());
                return result;
            }
        } catch (Exception e) {
            Log.e("Asteroides",e.getLocalizedMessage(),e);
            return  result;
        }
    }

    public  void  guardarPuntuaciones(int puntos,String nombre,int fecha){
        try {
         URL url=new URL("http://192.168.1.2/puntuaciones/nueva.php"
         +"?puntos="+puntos+"&nombre="+ URLEncoder.encode(nombre,"UTF-8")+"&fecha="+fecha);
            HttpURLConnection conexion=(HttpURLConnection)url.openConnection();
            if (conexion.getResponseCode()==HttpURLConnection.HTTP_OK){
                BufferedReader reader=new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea=reader.readLine();
                if (!linea.equals("OK")){
                    Log.e("Asteroides",conexion.getResponseMessage());
                }
                conexion.disconnect();
            }
        }catch (Exception e){
            Log.e("Asteroides",e.getMessage(),e);
        }
    }

}

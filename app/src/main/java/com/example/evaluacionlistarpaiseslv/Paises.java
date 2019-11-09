package com.example.evaluacionlistarpaiseslv;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Paises {

    private String nombrePais;
    private String url_Pais;


    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getUrl_Pais() {
        return url_Pais;
    }

    public void setUrl_Pais(String url_Pais) {
        this.url_Pais = url_Pais;
    }

    public Paises(String npais,String nurl) throws JSONException {
        nombrePais = npais;
        url_Pais = nurl;
    }


    public static ArrayList<Paises> JsonObjectsBuild(JSONObject datos) throws JSONException {
        ArrayList<Paises> paises = new ArrayList<>();

        JSONObject results=datos.getJSONObject("Results");
        JSONArray namesBD=results.names();

        for (int i = 0; i < namesBD.length(); i++) {

            String namebd= namesBD.getString(i);
            JSONObject datosBD=results.getJSONObject(namebd);
            String nombrePais=datosBD.getString("Name");
            JSONObject countryCodes=datosBD.getJSONObject("CountryCodes");
            String iso2=countryCodes.getString("iso2");
            paises.add(new Paises(nombrePais,"http://www.geognos.com/api/en/countries/flag/"+iso2+".png"));
        }

        return paises;
    }
}

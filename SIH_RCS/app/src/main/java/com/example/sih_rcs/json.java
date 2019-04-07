package com.example.sih_rcs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class json extends AsyncTask<String, Void,String> {

    String from,to,day;
    public static int length = 100;
    public static String[] fare = new String[length];
    public static String[] flight_id = new String[length];
    public static String[] airline = new String[length];
    public static String[] departure = new String[length];
    public static String[] arrival = new String[length];
    public static String[] seats = new String[length];
    public static JSONArray ja;
    AlertDialog dialog;
    Context context;
    public Boolean login = false;
    public json(Context context,String from,String to, String day)
    {
        this.context = context;
        this.from = from;
        this.to = to;
        this.day = day;
    }

    @Override
    protected void onPreExecute() {
        Log.d("yo",from+to+day);

    }
    @Override
    protected void onPostExecute(String s) {
        if(fare[0]!=null)
        {
            context.startActivity(new Intent(context,SearchFlight2.class));
        }
        else
        {
            context.startActivity(new Intent(context,No_results.class));
        }

        Log.d("yo","connect hogya");
        Log.d("json",from);
    }
    @Override
    protected String doInBackground(String... voids) {
        String result = "";

        String din;
        din = String.valueOf(day.charAt(0))+ String.valueOf(day.charAt(1))+String.valueOf(day.charAt(2));
        //String connstr = "http://192.168.43.107:8080/linking_phps/search_flight.php?from=%22Delhi%22&to=%22Kanpur%22&day=%22Mon%22";
        String connstr = "http://192.168.43.107:8080/linking_phps/search_flight.php?from=%22"+from+"%22&to=%22"+to+"%22&day=%22"+din+"%22";

        try {
            Log.d("day",din);

            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            Log.d("json","1");
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);
            Log.d("json","2");

            InputStream ips = http.getInputStream();
            Log.d("json","3");
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));
            String line ="";
            while ((line = reader.readLine()) != null)
            {
                result += line;
            }

            ja = new JSONArray(result);
            length = ja.length();


            for (int i = 0; i < ja.length(); i++) {
                Log.d("json", String.valueOf(ja.length()));
                JSONObject jsonobject = ja.getJSONObject(i);
                fare[i] = jsonobject.getString("fare");
                airline[i] = jsonobject.getString("airline");
                departure[i] = jsonobject.getString("departure");
                arrival[i] = jsonobject.getString("arrival");
                seats[i] = jsonobject.getString("seats");
                flight_id[i] = jsonobject.getString("flight_id");
                Log.d("json",fare[0]);
            }
            reader.close();
            ips.close();
            http.disconnect();
            return result;


        } catch (MalformedURLException e) {
            result = e.getMessage();
        } catch (IOException e) {
            result = e.getMessage();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }


}
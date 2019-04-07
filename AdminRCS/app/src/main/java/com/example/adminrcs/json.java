package com.example.adminrcs;

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
   public static int rcs_booked,total_booked;
    public static JSONArray ja;
    AlertDialog dialog;
    Context context;
    public Boolean login = false;
    public json(Context context)
    {
        this.context = context;
    }


    @Override
    protected void onPreExecute() {
        Log.d("yo",from+to+day);

    }
    @Override
    protected void onPostExecute(String s) {

            context.startActivity(new Intent(context,SecondActivity.class));

    //    Log.d("yo","connect hogya");
//        Log.d("json",from);
    }
    @Override
    protected String doInBackground(String... voids) {
        String result = "";

        //String connstr = "http://192.168.43.107:8080/linking_phps/search_flight.php?from=%22Delhi%22&to=%22Kanpur%22&day=%22Mon%22";
        //String connstr = "http://192.168.43.107:8080/linking_phps/search_flight.php?from=%22"+from+"%22&to=%22"+to+"%22&day=%22"+din+"%22";
        //String connstr = "http://192.168.43.107:8080/linking_phps/RCSseats.php?flight_id=%22" +  + "%22&date=%22" + SecondActivity.tvDetailsDate.getText().toString() +"%22";
        String connstr = "http://192.168.43.107:8080/linking_phps/RCSseats.php?flight_id=%22AI%20821%22&date=%2225/02/19%22";
        Log.d("json", connstr);
        try {

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
                rcs_booked = Integer.parseInt(jsonobject.getString("rcs"));
                total_booked = Integer.parseInt(jsonobject.getString("total"));
                Log.d("json_rcs" , String.valueOf(total_booked));
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
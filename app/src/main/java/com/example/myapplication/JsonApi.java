package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class JsonApi extends AsyncTask<String, String, String> {
    SharedPreferences.Editor editor;
    public JsonApi(SharedPreferences.Editor editor){
        this.editor = editor;
    }

    @Override
    protected String doInBackground(String... params) {
        String favouriteDesk = "";
        ArrayList<Integer> tableCapacity = new ArrayList<Integer>();
        int roomCapacity = 0;
        try {
            URL endpoint = new URL("https://mocki.io/v1/8feb9f8f-8bbd-41eb-b969-32e7430be09f");
            //"https://mocki.io/v1/40e02676-e81b-4151-a998-18d643694117"
            // Create connection
            URLConnection myConnection = endpoint.openConnection();
            myConnection.setRequestProperty("Accept", "application/json");
            InputStream responseBody = myConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(responseBody, "UTF-8");
            JsonReader jsonReader = new JsonReader(inputStreamReader);
            jsonReader.beginObject(); // Start processing the JSON object

            while (jsonReader.hasNext()) { // Loop through all keys
                String key = jsonReader.nextName(); // Fetch the next key
                if (key.contains("Room"))
                    roomCapacity = jsonReader.nextInt();
                else if (key.contains("Table"))
                    tableCapacity.add(jsonReader.nextInt());
                else if (key.equals("favourite"))
                    favouriteDesk = jsonReader.nextString();
            }
            editor.putInt("RoomCapacity_0", roomCapacity);
            editor.putInt("TableCapacity_0", tableCapacity.get(0));
            editor.putInt("TableCapacity_1", tableCapacity.get(1));
            editor.putInt("TableCapacity_2", tableCapacity.get(2));
            editor.putString("FavouriteTable", favouriteDesk);
            editor.commit();
        } catch (Exception ignored) {
            ignored.printStackTrace();

        }
        return "";
    }
}

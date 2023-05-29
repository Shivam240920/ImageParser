package com.example.imageparsing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {

    private String url = "https://jsonplaceholder.typicode.com/photos";
    private JsonArrayRequest jsonArrayRequest;
    private RequestQueue requestQueue;
    private ArrayList<ImageClass> imageClassArrayList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        recyclerView = findViewById(R.id.recyclerview);
        imageClassArrayList = new ArrayList<>();

        jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for(int i = 0;i<response.length();i++){
                    try{
                        jsonObject = response.getJSONObject(i);
                        ImageClass imageClass = new ImageClass(jsonObject.getString("url"),jsonObject.getString("thumbnailUrl"),jsonObject.getString("title"));
                        imageClassArrayList.add(imageClass);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setRecyclerView(imageClassArrayList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(ImageActivity.this);
        requestQueue.add(jsonArrayRequest);
    }

    private void setRecyclerView(ArrayList<ImageClass> imageClassArrayList){
        recyclerAdapter adapter = new recyclerAdapter(this,imageClassArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
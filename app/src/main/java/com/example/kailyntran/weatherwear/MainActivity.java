package com.example.kailyntran.weatherwear;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity {
    
    //creating tags for each variable so the tags can be passed to the next activity
    public static final String TAG_ID = "id";
    public static final String TAG_CURRENTTEMP = "currenttemp";
    public static final String TAG_MAXTEMP = "maxtemp";
    public static final String TAG_MINTEMP = "mintemp";
    public static final String TAG_ZIP = "zip";
   
    //variables that will be initialized in on click and passed to the next activity
    private String zip = "";
    private String id = "";
    private String currenttemp = "";
    private String maxtemp = "";
    private String mintemp = "";
    
    private EditText enteredzip;

    private Button button;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        enteredzip = (EditText) findViewById(R.id.editText);

        button = (Button) findViewById(R.id.button);
        
      
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //initializes zip to the value in the EditText enteredzip
                zip = enteredzip.getText().toString();
                String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?zip=";
                String API_CALL= "&APPID=9974c0ebd73bf2310ea2bcd73c09e316";

                //Request a string response from the URL resource using the volley method
                StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL+zip+API_CALL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //Parses the response string which comes in a json format to assign values to the strings declared above
                                for (int i = 0; i < response.length(); i++) {
                                    if (response.substring(i, i + 2).equals("id")) {
                                        id = response.substring(i + 4, i + 7);
                                        break;
                                    }
                                }

                                for (int i = 0; i < response.length(); i++) {
                                    if (response.substring(i, i + 4).equals("temp")) {
                                        currenttemp = response.substring(i + 6, i + 12);
                                        break;
                                    }
                                }

                                for (int i = 0; i < response.length(); i++) {
                                    if (response.substring(i, i + 8).equals("temp_min")) {
                                        mintemp = response.substring(i + 10, i + 16);
                                        break;
                                    }
                                }

                                for (int i = 0; i < response.length(); i++) {
                                    if (response.substring(i, i + 8).equals("temp_max")) {
                                        maxtemp = response.substring(i + 10, i + 16);
                                        break;
                                    }
                                }
                        
                                launchMain2Activity();
                            }
                            //catches an error in the volley
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //When an error is returned from the volley request due to a given zip code not having a value in the API, this toasts an error message that prompts the user to reenter a zip code
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.error_et), Toast.LENGTH_LONG).show();
                        return;
                    }
                });
                //Instantiate the RequestQueue and add the request to the queue
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                queue.add(stringRequest);
            }
        });

    }

    private void launchMain2Activity() {
        Intent Main2Activity = new Intent(MainActivity.this, Main2Activity.class);
        
        //pass variables to next activity using tags
        Main2Activity.putExtra(TAG_ID, id);
        Main2Activity.putExtra(TAG_CURRENTTEMP, currenttemp);
        Main2Activity.putExtra(TAG_MAXTEMP, maxtemp);
        Main2Activity.putExtra(TAG_MINTEMP, mintemp);
        Main2Activity.putExtra(TAG_ZIP, zip);

        startActivity(Main2Activity);
    }

}

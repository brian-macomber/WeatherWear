package com.example.kailyntran.weatherwear;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.widget.CheckBox;
        import android.view.View;
        import android.widget.Button;
        import android.view.View.OnClickListener;

public class Main2Activity extends Activity implements OnClickListener {

    public static final String TAG_CHECKARRAY = "check array";
    private boolean checkarray[];
    private Button enter;

    public static final String TAG_ID2 = "id";
    public static final String TAG_CURRENTTEMP2 = "currenttemp";
    public static final String TAG_MAXTEMP2 = "maxtemp";
    public static final String TAG_MINTEMP2 = "mintemp";
    public static final String TAG_ZIP2 = "zip";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        checkarray = new boolean[12];

        enter = (Button) findViewById(R.id.enter);

        enter.setOnClickListener(this);

        String id = getIntent().getExtras().getString(MainActivity.TAG_ID);
        String currenttemp = getIntent().getExtras().getString(MainActivity.TAG_CURRENTTEMP);
        String maxtemp = getIntent().getExtras().getString(MainActivity.TAG_MAXTEMP);
        String mintemp = getIntent().getExtras().getString(MainActivity.TAG_MINTEMP);
        String zip = getIntent().getExtras().getString(MainActivity.TAG_ZIP);
    }

    public void onClick(View v)
    {
        CheckBox checkBox_fall_jacket= (CheckBox) findViewById(R.id.checkBox_fall_jacket);
        CheckBox checkBox_jeans= (CheckBox) findViewById(R.id.checkBox_jeans);
        CheckBox checkBox_rain_boots= (CheckBox) findViewById(R.id.checkBox_rain_boots);
        CheckBox checkBox_rain_jacket= (CheckBox) findViewById(R.id.checkBox_rain_jacket);
        CheckBox checkBox_sandals= (CheckBox) findViewById(R.id.checkBox_sandals);
        CheckBox checkBox_shorts= (CheckBox) findViewById(R.id.checkBox_shorts);
        CheckBox checkBox_sneakers= (CheckBox) findViewById(R.id.checkBox_sneakers);
        CheckBox checkBox_sweater= (CheckBox) findViewById(R.id.checkBox_sweater);
        CheckBox checkBox_sweatpants= (CheckBox) findViewById(R.id.checkBox_sweatpants);
        CheckBox checkBox_sweatshirt= (CheckBox) findViewById(R.id.checkBox_sweatshirt);
        CheckBox checkBox_t_shirt= (CheckBox) findViewById(R.id.checkBox_t_shirt);
        CheckBox checkBox_winter_boots= (CheckBox) findViewById(R.id.checkBox_winter_boots);
        CheckBox checkBox_winter_jacket= (CheckBox) findViewById(R.id.checkBox_winter_jacket);


        if (checkBox_fall_jacket.isChecked())
            checkarray[0]=true;
        if (checkBox_jeans.isChecked())
            checkarray[1]=true;
        if (checkBox_rain_boots.isChecked())
            checkarray[2]=true;
        if (checkBox_rain_jacket.isChecked())
            checkarray[3]=true;
        if (checkBox_sandals.isChecked())
            checkarray[4]=true;
        if (checkBox_shorts.isChecked())
            checkarray[5]=true;
        if (checkBox_sneakers.isChecked())
            checkarray[6]=true;
        if (checkBox_sweater.isChecked())
            checkarray[7]=true;
        if (checkBox_sweatpants.isChecked())
            checkarray[8]=true;
        if (checkBox_sweatshirt.isChecked())
            checkarray[9]=true;
        if (checkBox_t_shirt.isChecked())
            checkarray[10]=true;
        if (checkBox_winter_boots.isChecked())
            checkarray[11]=true;
        if (checkBox_winter_jacket.isChecked())
            checkarray[12]=true;

        launchMain3Activity();
    }

    private void launchMain3Activity() {
        String id = getIntent().getExtras().getString(MainActivity.TAG_ID);
        String currenttemp = getIntent().getExtras().getString(MainActivity.TAG_CURRENTTEMP);
        String maxtemp = getIntent().getExtras().getString(MainActivity.TAG_MAXTEMP);
        String mintemp = getIntent().getExtras().getString(MainActivity.TAG_MINTEMP);
        String zip = getIntent().getExtras().getString(MainActivity.TAG_ZIP);

        Intent Main3Activity = new Intent(Main2Activity.this, Main3Activity.class);

        Main3Activity.putExtra(TAG_ID2, id);
        Main3Activity.putExtra(TAG_CURRENTTEMP2, currenttemp);
        Main3Activity.putExtra(TAG_MAXTEMP2, maxtemp);
        Main3Activity.putExtra(TAG_MINTEMP2, mintemp);
        Main3Activity.putExtra(TAG_ZIP2, zip);

        Main3Activity.putExtra(TAG_CHECKARRAY,checkarray);

        startActivity(Main3Activity);
    }

}


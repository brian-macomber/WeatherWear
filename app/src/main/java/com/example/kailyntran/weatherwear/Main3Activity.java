package com.example.kailyntran.weatherwear;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.text.Html;
import android.text.method.LinkMovementMethod;

public class Main3Activity extends Activity {
    
    //Declares all text views that will be displayed 
    private TextView TextViewZip;
    private TextView TextViewCurrent;
    private TextView TextViewHigh;
    private TextView TextViewLow;
    private TextView TextViewWeather;
    private TextView TextViewC1;
    private TextView TextViewC2;
    private TextView TextViewC3;
    private ImageView imageView;
    private ImageView imageViewC1;
    private ImageView imageViewC2;
    private ImageView imageViewC3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        
       
        String id = getIntent().getExtras().getString(Main2Activity.TAG_ID2);
        String zip = getIntent().getExtras().getString(Main2Activity.TAG_ZIP2);
        String currenttemp = getIntent().getExtras().getString(Main2Activity.TAG_CURRENTTEMP2);
        String maxtemp = getIntent().getExtras().getString(Main2Activity.TAG_MAXTEMP2);
        String mintemp = getIntent().getExtras().getString(Main2Activity.TAG_MINTEMP2);
        boolean checkarray[] = getIntent().getExtras().getBooleanArray(Main2Activity.TAG_CHECKARRAY);

        TextViewZip = (TextView) findViewById(R.id.textViewZIP);
        TextViewCurrent = (TextView) findViewById(R.id.textViewCurrent);
        TextViewHigh = (TextView) findViewById(R.id.textViewHigh);
        TextViewLow = (TextView) findViewById(R.id.textViewLow);
        TextViewWeather = (TextView) findViewById(R.id.textViewWeather);
        TextViewC1 = (TextView) findViewById(R.id.textViewC1);
        TextViewC2 = (TextView) findViewById(R.id.textViewC2);
        TextViewC3 = (TextView) findViewById(R.id.textViewC3);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageViewC1 = (ImageView) findViewById(R.id.imageViewC1);
        imageViewC2 = (ImageView) findViewById(R.id.imageViewC2);
        imageViewC3 = (ImageView) findViewById(R.id.imageViewC3);

        TextViewC1.setClickable(true);
        TextViewC2.setClickable(true);
        TextViewC3.setClickable(true);
        TextViewC1.setMovementMethod(LinkMovementMethod.getInstance());
        TextViewC2.setMovementMethod(LinkMovementMethod.getInstance());
        TextViewC3.setMovementMethod(LinkMovementMethod.getInstance());

        initializeTextViews(zip,currenttemp,maxtemp,mintemp);
        initializePictures(id);
        displayClothes(id,maxtemp,checkarray);
    }
    
    //Initializes the TextViews for zip code, currenttemp, maxtemp, and mintemp 
    private void initializeTextViews(String zip, String currenttemp, String maxtemp, String mintemp) {
        //converts temperatures from doubles in Kelvin units to ints in Fahrenheit unitds
        int newmaxtemp = (int) (((Double.parseDouble(maxtemp) - 273) * 9)/5) +32;
        int newmintemp = (int) (((Double.parseDouble(mintemp) - 273) * 9)/5) +32;
        int newcurrenttemp = (int) (((Double.parseDouble(currenttemp) - 273) * 9)/5) +32;

        //converts values to strings so they can be put in the text view
        maxtemp = newmaxtemp + "";
        mintemp = newmintemp + "";
        currenttemp = newcurrenttemp + "";

        TextViewZip.setText(zip);
        TextViewCurrent.setText(currenttemp);
        TextViewHigh.setText(maxtemp);
        TextViewLow.setText(mintemp);
    }
    
    //initializes the image icon set for the category of weather based on the id based from the api
    private void initializePictures(String id){
        //creates a new variable for id as a double
        double newid = Double.parseDouble(id);
        Integer images[] = {R.drawable.sunny, R.drawable.cloudy, R.drawable.rainy, R.drawable.snowy};
        String sunny = "Sunny";
        String cloudy = "Cloudy";
        String rainy = "Rainy";
        String snow = "Snow";
        //sets image based on meaning gotten from openweathermap.org/api
        if (newid == 800) {
            TextViewWeather.setText(sunny);
            imageView.setImageResource(images[0]);
        }
        else if ((newid > 700 && newid < 800) || newid > 800) {
            TextViewWeather.setText(cloudy);
            imageView.setImageResource(images[1]);
        }
        else if (newid >= 200 && newid < 600) {
            TextViewWeather.setText(rainy);
            imageView.setImageResource(images[2]);
        }
        else {
            TextViewWeather.setText(snow);
            imageView.setImageResource(images[3]);
        }

    }
    
    //This method selects which clothes to display and hyperlinks their text depending on whether they own the clothing recomended
    private void displayClothes(String id, String maxtemp, boolean checkarray[]){
        //List of strings to hyperlink apparel if the user does not own that specific apparel
        String linkjeans = "<a href ='https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=jeans+&rh=i%3Aaps%2Ck%3Ajeans+'> Jeans </a>";
        String linkfalljacket = "<a href ='https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=fall+jacket'> Fall Jacket </a>";
        String linkrainboots = "<a href ='https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=rainboots&rh=i%3Aaps%2Ck%3Arainboots'> Rain Boots </a>";
        String linkrainjacket = "<a href ='https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=rain+jacket&rh=i%3Aaps%2Ck%3Arain+jacket'> Rain Jacket </a>";
        String linksandals = "<a href ='https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=sandals&rh=i%3Aaps%2Ck%3Asandals'> Sandals </a>";
        String linkshorts = "<a href ='https://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=shorts+'> Shorts </a>";
        String linksneakers = "<a href ='https://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Daps&field-keywords=sneakers'> Sneakers </a>";
        String linksweater = "<a href ='https://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Daps&field-keywords=sweater&rh=i%3Aaps%2Ck%3Asweater'> Sweater </a>";
        String linksweatpants = "<a href ='https://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Daps&field-keywords=sweat+pants&rh=i%3Aaps%2Ck%3Asweat+pants'> Sweatpants </a>";
        String linksweatshirt = "<a href ='https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=sweatshirt&rh=i%3Aaps%2Ck%3Asweatshirt'> Sweatshirt </a>";
        String linktshirt = "<a href ='https://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Dfashion-mens&field-keywords=t+shirt&rh=n%3A7147441011%2Ck%3At+shirt'> T-Shirt </a>";
        String linkwinterboots = "<a href ='https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Dfashion-mens&field-keywords=winter+boots&rh=n%3A7147441011%2Ck%3Awinter+boots'> Boots </a>";
        String linkwinterjacket = "<a href ='https://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Dfashion-mens&field-keywords=winter+jacket&rh=n%3A7147441011%2Ck%3Awinter+jacket'> Winter Jacket </a>";


        //Initializes an array of images from the drawable folder
        Integer images[] = {R.drawable.falljacket, R.drawable.jeans, R.drawable.rainboots, R.drawable.rainjacket, R.drawable.sandals,
                R.drawable.shorts, R.drawable.sneakers, R.drawable.sweatpants, R.drawable.sweater, R.drawable.sweatshirt, R.drawable.tshirt,
                R.drawable.winterboots, R.drawable.winterjacket };
        //parses the max temp of the day from a string to a double because this value will be used to recommend apparel
        double newmaxtemp = (((Double.parseDouble(maxtemp) - 273) * 9)/5) +32;
        int newid = Integer.parseInt(id);
        
        String falljacket = "Fall Jacket"; //0
        String jeans = "Jeans"; //1
        String rainboots = "Rain Boots"; //2
        String rainjacket = "Rain Jacket"; //3
        String sandals = "Sandals"; //4
        String shorts = "Shorts"; //5
        String sneakers = "Sneakers"; //6
        String sweatpants = "Sweatpants"; //7
        String sweater = "Sweater"; //8
        String sweatshirt = "Sweatshirt"; //9
        String tshirt = "T-Shirt"; //10
        String winterboots = "Winter Boots"; //11
        String winterjacket = "Winter Jacket"; //12
        
        //This determines if the weather is sunny, and then recommends clothing based on if it is sunny as well the temperature
        if (newid == 800) {
            if (newmaxtemp >= 65){
                imageViewC1.setImageResource(images[10]);
                imageViewC2.setImageResource(images[5]);
                imageViewC3.setImageResource(images[4]);
                if (checkarray[10] == false){
                    TextViewC1.setText(Html.fromHtml(linktshirt));
                }
                else{
                    TextViewC1.setText(tshirt);
                }
                if (checkarray[5] == false){
                    TextViewC2.setText(Html.fromHtml(linkshorts));
                }
                else{
                    TextViewC2.setText(shorts);
                }
                if (checkarray[4] == false){
                    TextViewC3.setText(Html.fromHtml(linksandals));
                }
                else{
                    TextViewC3.setText(sandals);
                }
            }
            else if(newmaxtemp > 32){

                imageViewC1.setImageResource(images[8]);
                imageViewC2.setImageResource(images[1]);
                imageViewC3.setImageResource(images[6]);
                if (checkarray[8] == false){
                    TextViewC1.setText(Html.fromHtml(linksweater));
                }
                else{
                    TextViewC1.setText(sweater);
                }
                if (checkarray[1] == false){
                    TextViewC2.setText(Html.fromHtml(linkjeans));
                }
                else{
                    TextViewC2.setText(jeans);
                }
                if (checkarray[6] == false){
                    TextViewC3.setText(Html.fromHtml(linksneakers));
                }
                else{
                    TextViewC3.setText(sneakers);
                }
            }
            else if(newmaxtemp <= 32){
                imageViewC1.setImageResource(images[12]);
                imageViewC2.setImageResource(images[7]);
                imageViewC3.setImageResource(images[6]);
                if (checkarray[12] == false){
                    TextViewC1.setText(Html.fromHtml(linkwinterjacket));
                }
                else{
                    TextViewC1.setText(winterjacket);
                }
                if (checkarray[7] == false){
                    TextViewC2.setText(Html.fromHtml(linksweatpants));
                }
                else{
                    TextViewC2.setText(sweatpants);
                }
                if (checkarray[6] == false){
                    TextViewC2.setText(Html.fromHtml(linksneakers));
                }
                else{
                    TextViewC3.setText(sneakers);
                }
            }

        }
        //This determines if the weather is cloudy, and then recommends clothing based on if it is cloudy as well the temperature
        else if ((newid > 700 && newid < 800) || newid > 800) { //Cloudy
            imageViewC3.setImageResource(images[6]);
            if (checkarray[6] == false){
                TextViewC3.setText(Html.fromHtml(linksneakers));
            }
            else{
                TextViewC3.setText(sneakers);
            }
            if (newmaxtemp >= 65){
                imageViewC1.setImageResource(images[9]);
                imageViewC2.setImageResource(images[5]);
                if (checkarray[9] == false){
                    TextViewC1.setText(Html.fromHtml(linksweatshirt));
                }
                else{
                    TextViewC1.setText(sweatshirt);
                }
                if (checkarray[5] == false){
                    TextViewC2.setText(Html.fromHtml(linkshorts));
                }
                else{
                    TextViewC2.setText(shorts);
                }
            }
            else if(newmaxtemp > 32){

                imageViewC1.setImageResource(images[0]);
                imageViewC2.setImageResource(images[1]);
                if (checkarray[0] == false){
                    TextViewC1.setText(Html.fromHtml(linkfalljacket));
                }
                else{
                    TextViewC1.setText(falljacket);
                }
                if (checkarray[1] == false){
                    TextViewC2.setText(Html.fromHtml(linkjeans));
                }
                else{
                    TextViewC2.setText(jeans);
                }
            }
            else if(newmaxtemp <= 32){
                imageViewC1.setImageResource(images[12]);
                imageViewC2.setImageResource(images[7]);
                if (checkarray[12] == false){
                    TextViewC1.setText(Html.fromHtml(linkwinterjacket));
                }
                else{
                    TextViewC1.setText(winterjacket);
                }
                if (checkarray[7] == false){
                    TextViewC2.setText(Html.fromHtml(linksweatpants));
                }
                else{
                    TextViewC2.setText(sweatpants);
                }
            }
        }
        //This determines if the weather is rainy, and then recommends clothing based on if it is rainy as well the temperature
        else if (newid >= 200 && newid < 600){ //rainy
            imageViewC1.setImageResource(images[3]);
            imageViewC3.setImageResource(images[2]);
            if (checkarray[3] == false){
                TextViewC1.setText(Html.fromHtml(linkrainjacket));
            }
            else{
                TextViewC1.setText(rainjacket);
            }
            if (checkarray[2] == false){
                TextViewC3.setText(Html.fromHtml(linkrainboots));
            }
            else{
                TextViewC3.setText(rainboots);
            }
            if (newmaxtemp >= 65){
                imageViewC2.setImageResource(images[5]);
                if (checkarray[5] == false){
                    TextViewC2.setText(Html.fromHtml(linkshorts));
                }
                else{
                    TextViewC2.setText(shorts);
                }
            }
            else if(newmaxtemp > 32){

                imageViewC2.setImageResource(images[1]);
                if (checkarray[1] == false){
                    TextViewC2.setText(Html.fromHtml(linkjeans));
                }
                else{
                    TextViewC2.setText(jeans);
                }
            }
            else if(newmaxtemp <= 32){
                imageViewC2.setImageResource(images[7]);
                if (checkarray[7] == false){
                    TextViewC2.setText(Html.fromHtml(linksweatpants));
                }
                else{
                    TextViewC2.setText(sweatpants);
                }
            }

        }
        //This determines if the weather is snow, and then recommends clothing based on if it is snow as well the temperature
        else if(newmaxtemp <= 32) { //snow
            imageViewC1.setImageResource(images[12]);
            imageViewC3.setImageResource(images[11]);
            imageViewC2.setImageResource(images[7]);
            if (checkarray[12] == false){
                TextViewC1.setText(Html.fromHtml(linkwinterjacket));
            }
            else{
                TextViewC1.setText(winterjacket);
            }
            if (checkarray[11] == false){
                TextViewC3.setText(Html.fromHtml(linkwinterboots));
            }
            else{
                TextViewC3.setText(winterboots);
            }
            if (checkarray[7] == false){
                TextViewC2.setText(Html.fromHtml(linksweatpants));
            }
            else{
                TextViewC2.setText(sweatpants);
            }
        }

    }
}


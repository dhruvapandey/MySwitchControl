package com.example.dhrpande.switchcontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    int red_on=0;
    int blue_on=0;
    int yellow_on=0;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = database.getReference("message");

    TextView colorText;
    Button redButton;
    Button blueButton;
    Button yellowButton;

    HashMap<String, Integer> colour = new HashMap<String, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colour.put("Red",0);

        dbRef.push().setValue(colour);
        colorText = (TextView) findViewById(R.id.colorText);
        colorText.setText("The control is yours -");

    }

    public void onRedClick(View view) {

        dbRef.setValue(null);

        if(red_on==0) {
            colour.put("Red", 1);
            red_on=1;
        }
        else {
            colour.put("Red",0);
            red_on=0;
        }
        dbRef.push().setValue(colour);
    }
    public void onBlueClick(View view) {

        dbRef.setValue(null);

        if(blue_on==0){

            colour.put("Blue", 1);
            blue_on=1;
        }
        else {
            colour.put("Blue", 0);
            blue_on=0;
        }

        dbRef.push().setValue(colour);
    }
    public void onYellowClick(View view) {

        dbRef.setValue(null);

        if(yellow_on==0) {
            colour.put("Yellow", 1);
            yellow_on=1;
        }
        else {
            colour.put("Yellow", 0);
            yellow_on=0;
        }
        dbRef.push().setValue(colour);
    }

}

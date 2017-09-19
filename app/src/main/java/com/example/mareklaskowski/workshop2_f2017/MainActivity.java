package com.example.mareklaskowski.workshop2_f2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    this method is what actually handles the button click
     */
    public void handleA2click(){
        //for now, display a Toast message for debugging purposes
        Toast.makeText(this, "You clicked a2_button. Way to go!", Toast.LENGTH_LONG).show();
        //don't forget .show() at the end
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //let's add a button handler to a2_button
        //first we get a reference to the button by using findViewByID which returns a Java reference
        Button a2 = (Button) findViewById(R.id.a2_button); //note the cast to the actual View class
        //define a click handling method for the button
        //NOTE: we are using a java style here called an "Anonymous temporary class"
        a2.setOnClickListener(/* instantiate an OnClickListener object inside the method call braces*/
            new View.OnClickListener(){ //override the onClick method so that our anonymous class is no longer abstract
                public void onClick(View v){
                    //marek's advice is to always add behavior to a method defined in MainActivity to do the work
                    handleA2click();
                }
            }


        );

    }
}

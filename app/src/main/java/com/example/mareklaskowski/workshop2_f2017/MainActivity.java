package com.example.mareklaskowski.workshop2_f2017;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    this method is what actually handles the button click
     */
    public void handleA2click(){
        //for now, display a Toast message for debugging purposes
        Toast.makeText(this, "You clicked a2_button. Way to go!", Toast.LENGTH_LONG).show();
        //don't forget .show() at the end

        //use an implicit intent to launch SecondActivity
        //step 1 create the intent
        Intent a2intent = new Intent("com.seneca.lab2.marek"); //TODO: change to your name
        //use our intent to start the SecondActivity
        //startActivity will not listen or handle a result back from SecondActivity
        //startActivity(a2intent);
        //if we want to use another Activity as a "dialog" we have to use startActivityForResult instead
        //startActivityForResult exepcts both an Intent and an int request code so that you
        //can later match up the request with the eventual reply from the started activity
        startActivityForResult(a2intent, 1);//for simple apps we can use a literal code
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

    /* onActivityResult will be called by the Android framework once the Activity we
        started with startActivityForResult completes.
        We are passed the same request code that we passed to startActivityForResult
        and a result code that indicates whether the user completed the Activity or pressed
        back to cancel.
         */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //handler
        if(requestCode == 1){
            //check to see whether the user pressed OK or hit the back button
            if(resultCode == Activity.RESULT_OK){
                //exract the message from the Intent that was returned (data)
                String result = data.getStringExtra("message");
                //set the textView's string to display the message
                TextView text = (TextView) findViewById(R.id.message);
                text.setText(result);
            }
        } else{
            Log.e("lab2", "SOMETHING WENT VERY WRONG");
        }
    }
}





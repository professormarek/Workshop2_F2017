package com.example.mareklaskowski.workshop2_f2017;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    public void ok_button_handler(){
        /* compose a reply to send back to MainActivity
        using an Intent to store the reply
         */
        Intent result = new Intent();
        //get the text in the EditText box so we can include it in the reply
        EditText editText = (EditText) findViewById(R.id.editText);
        //extract the string stored in editText
        String message = editText.getText().toString();

        //add the message as an extra to the "result" Intent
        result.putExtra("message", message);

        //if the activity was started with StartActivityForResult we will need the line below
        //to end the Activity - note, you don't need this for ThirdActivity because it's not started
        //with startActivityForResult

        setResult(Activity.RESULT_OK, result);

        //end this activity
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //set a button handler for OK button
        Button ok = (Button) findViewById(R.id.ok_button);
        ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ok_button_handler();
            }
        });
    }
}

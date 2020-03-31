package com.example.showactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    // variable to house the firstActivityMessage
    // will display messages in a text view
    private TextView firstActivityMessage;
    private Button returnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // create bundle instance to grab intent extras sent from first activity
        Bundle extras = getIntent().getExtras();
        // handle for firstActivityMessage textView
        firstActivityMessage = findViewById(R.id.firstActivityMessageID);
        // handle for returnButton
        returnButton = findViewById(R.id.returnButtonID);
        if(extras != null){
            String firstMessage = extras.getString("firstMessage");
            String secondMessage = extras.getString("secondMessage");
            Toast.makeText(Main2Activity.this, firstMessage, Toast.LENGTH_SHORT).show();
            Toast.makeText(Main2Activity.this, secondMessage, Toast.LENGTH_SHORT).show();
        }
        returnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                intent.putExtra("returnMessage", "Hello from the Second Activity!!");
                startActivity(intent);
            }
        });
    }
}

package com.example.showactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button activityButton;
    private final int REQUEST_CODE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityButton = (Button) findViewById(R.id.activityButtonID);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            Toast.makeText(MainActivity.this, extras.getString("returnMessage"), Toast.LENGTH_SHORT).show();
        }
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // new intent class instance
                Intent intent;
                intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("firstMessage", "Hello from the first activity!");
                intent.putExtra("secondMessage", "How are you?");
                startActivity(intent);
            }
        });
    }
}

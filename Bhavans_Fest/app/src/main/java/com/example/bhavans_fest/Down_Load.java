package com.example.bhavans_fest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Down_Load extends AppCompatActivity {

    private Button download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down__load);
        getSupportActionBar().hide();

        download=findViewById(R.id.btndownload);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(Down_Load.this,All_One.class);
                startActivity(i);
            }
        });




    }
}

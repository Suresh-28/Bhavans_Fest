package com.example.bhavans_fest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Second_Activity extends AppCompatActivity {
    private EditText edInstitute;
    private Button btnnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        getSupportActionBar().hide();

        edInstitute=findViewById(R.id.edInstitute);
        btnnext=findViewById(R.id.buttonnext);

        if (TextUtils.isEmpty(edInstitute.getText().toString())) {
            edInstitute.setError("enter institute");
        }

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Second_Activity.this, FirstActivity.class);
                startActivity(i);
                finish();
            }
        });




            }
        }


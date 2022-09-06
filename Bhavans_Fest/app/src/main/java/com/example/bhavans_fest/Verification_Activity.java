package com.example.bhavans_fest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Verification_Activity extends AppCompatActivity {
    private EditText editTextMobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        getSupportActionBar().hide();

        editTextMobile=findViewById(R.id.editTextMobile);
        findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile=editTextMobile.getText().toString().trim();
                if(mobile.isEmpty()|| mobile.length()<10) {
                    editTextMobile.setError("enter a valid number");
                    editTextMobile.requestFocus();
                    return;
                }
                Intent intent=new Intent(Verification_Activity.this,Verify_Activity.class);
                intent.putExtra("mobile",mobile);
                startActivity(intent);
            }
        });
    }
}

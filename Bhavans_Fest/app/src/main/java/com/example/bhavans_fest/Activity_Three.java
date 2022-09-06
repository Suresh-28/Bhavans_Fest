package com.example.bhavans_fest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Activity_Three extends AppCompatActivity {
    private Button login;
    private TextView text;
    private EditText username, password;

    private  FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    int count = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__three);
        getSupportActionBar().hide();
        login=findViewById(R.id.btnlogin);
        text=findViewById(R.id.textView);
        username=findViewById(R.id.edemail);
        password=findViewById(R.id.edpassword);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Login();
            }
        });
    }

    private void Login(){

        String e = username.getText().toString();
        String p = password.getText().toString();

        if (TextUtils.isEmpty(e)){
            username.setError("enter email");
        }

      else   if (TextUtils.isEmpty(p)){
            password.setError("enter password");
        }

        else{
            progressDialog.setMessage("Logging in");
            progressDialog.show();

            firebaseAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        Toast.makeText(Activity_Three.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                        Intent varun = new Intent(Activity_Three.this,Down_Load .class);
                        startActivity(varun);
                    } else {

                        Toast.makeText(Activity_Three.this, "Couldn't Login", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        count--;
                        text.setText("No of attempts left: "+count);
                        if (count==0){
                            login.setEnabled(false);
                            Toast.makeText(Activity_Three.this, "Button disable,restart the application", Toast.LENGTH_LONG).show();


                        }
                    }
                }
            });

        }
    }
}
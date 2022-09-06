package com.example.bhavans_fest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton btnregister, btnlogin, btngallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel("MyNotifications", "MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        FirebaseMessaging.getInstance().subscribeToTopic("general").
                addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        String msg = "Successful";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }
                        Toast.makeText(FirstActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

        btnregister = findViewById(R.id.imageregister);
        btnlogin = findViewById(R.id.imagelogin);
        btngallery = findViewById(R.id.imagegallery);

        btnregister.setOnClickListener(this);
        btnlogin.setOnClickListener(this);
        btngallery.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_scrolling_, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.loginadmin:

                Intent intent=new Intent(FirstActivity.this,Maps_Destination.class);
                startActivity(intent);
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                return true;

           case R.id.rate:

            Intent i=new Intent(FirstActivity.this,Rating.class);
            startActivity(i);
            Toast.makeText(this, "Please rate us 5 stars", Toast.LENGTH_SHORT).show();
            return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {

        if (view == btnregister) {
            startActivity(new Intent(FirstActivity.this, MainActivity.class));
        }
        if (view == btnlogin) {
            startActivity(new Intent(FirstActivity.this, Verification_Activity.class));
        }
        if (view == btngallery) {
            startActivity(new Intent(FirstActivity.this, Grid_View.class));
        }
    }

    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Confirm Exit...");
        alertDialogBuilder.setIcon(R.drawable.ic_input);
        alertDialogBuilder.setMessage("Are you sure you want to exit..");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(FirstActivity.this, "You clicked on No", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
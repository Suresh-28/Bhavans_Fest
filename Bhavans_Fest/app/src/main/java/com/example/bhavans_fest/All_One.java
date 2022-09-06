package com.example.bhavans_fest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class All_One extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private  TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__one);

        textView=findViewById(R.id.text);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
      /*  textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(All_One.this,FirstActivity.class);
                startActivity(intent);

            }
        });*/

        textView2=findViewById(R.id.bhavans);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());

        textView3=findViewById(R.id.fare);
        textView3.setMovementMethod(LinkMovementMethod.getInstance());

        textView4=findViewById(R.id.annual);
        textView4.setMovementMethod(LinkMovementMethod.getInstance());

        textView5=findViewById(R.id.republic);
        textView5.setMovementMethod(LinkMovementMethod.getInstance());






    }
}
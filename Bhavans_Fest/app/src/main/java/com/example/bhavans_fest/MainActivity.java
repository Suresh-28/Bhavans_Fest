package com.example.bhavans_fest;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;



    public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private EditText firstname;
        private EditText lastname;
        private EditText email, password;
        private EditText editconfirm;
        private EditText printing;
        private TextView textView;
        private RadioGroup rd;
        private RadioButton male;
        private RadioButton female;
        private RadioButton others;
        private EditText ednumber;
        private EditText address;
        private EditText nation;
        private Button register;

        private Button btdob;
        private int year, month, day;

        private FirebaseAuth firebaseAuth;
        private ProgressDialog progressDialog;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            firstname = findViewById(R.id.firstname);
            lastname = findViewById(R.id.lastname);
            email = findViewById(R.id.email);

            btdob = findViewById(R.id.btdob);
            printing = findViewById(R.id.edprinting);
            male = findViewById(R.id.male);
            password = findViewById(R.id.editpassword);
            editconfirm = findViewById(R.id.editconfirm);
            female = findViewById(R.id.female);
            others = findViewById(R.id.others);
            ednumber = findViewById(R.id.ednumber);
            address = findViewById(R.id.edaddress);
            nation = findViewById(R.id.ednation);
            register = findViewById(R.id.btsave);
            firebaseAuth = FirebaseAuth.getInstance();
            progressDialog = new ProgressDialog(this);

            rd = findViewById(R.id.radiogroup);
            btdob = findViewById(R.id.btdob);
            btdob.setOnClickListener(this);
            register.setOnClickListener(this);


        }


        @Override
        public void onClick(View view) {

            if (view == btdob) {
                final Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day_of_month) {

                        printing.setText(day_of_month + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);

                datePickerDialog.show();

            }

            if (view == register) {

                if (TextUtils.isEmpty(firstname.getText().toString())) {

                    firstname.setError("enter first name");
                } else {

                    if (TextUtils.isEmpty(lastname.getText().toString())) {

                        lastname.setError("enter last name");
                    }

                    if (TextUtils.isEmpty(email.getText().toString())) {
                        email.setError("enter email");
                    }


                    if (TextUtils.isEmpty(firstname.getText().toString())) {

                        firstname.setError("enter name");
                    }

                    if (TextUtils.isEmpty(password.getText().toString())) {

                        password.setError("enter password");
                    }
                    if (TextUtils.isEmpty(editconfirm.getText().toString())) {

                        editconfirm.setError("enter confirm password");

                    }


                    if (TextUtils.isEmpty(printing.getText().toString())) {

                        printing.setError("enter DOB");
                    }
                    if (TextUtils.isEmpty(ednumber.getText().toString())) {

                        ednumber.setError("enter number");
                    }
                    if (TextUtils.isEmpty(address.getText().toString())) {

                        address.setError("enter address");
                    }

                    if (TextUtils.isEmpty(nation.getText().toString())) {

                        nation.setError("enter nation");
                    }

                    int isselect = rd.getCheckedRadioButtonId();
                    if (isselect == -1) {
                        Toast.makeText(MainActivity.this, "select gender", Toast.LENGTH_SHORT).show();
                        return;
                    } else {

                        if (!TextUtils.isEmpty(firstname.getText().toString()) && !TextUtils.isEmpty(lastname.getText().toString()) &&

                                !TextUtils.isEmpty(email.getText().toString()) && !TextUtils.isEmpty(printing.getText().toString())

                                && !TextUtils.isEmpty(address.getText().toString()) && !TextUtils.isEmpty(ednumber.getText().toString())
                                && !TextUtils.isEmpty(password.getText().toString()) && !TextUtils.isEmpty(nation.getText().toString())
                                && !TextUtils.isEmpty(editconfirm.getText().toString())) {


                            if (editconfirm.getText().toString().equals(password.getText().toString())) {


                                progressDialog.setMessage("registering user");
                                progressDialog.show();

                                String e = email.getText().toString();
                                String p = password.getText().toString();


                                firebaseAuth.createUserWithEmailAndPassword(e, p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {

                                            Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                            progressDialog.dismiss();
                                            startActivity(new Intent(MainActivity.this, Second_Activity.class));

                                        } else {
                                            Toast.makeText(MainActivity.this, "Couldn't Register", Toast.LENGTH_SHORT).show();
                                            progressDialog.dismiss();
                                        }
                                    }
                                });

                            } else {
                                editconfirm.setError("incorrect password");
                            }
                        }
                    }
                }
            }

        }
    }

package com.arun.mytestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName,etEmail,etHomePhone,etMobilePhone,etAddress,etZipCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText)findViewById(R.id.etName);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etHomePhone = (EditText)findViewById(R.id.etHomePhone);
        etMobilePhone = (EditText)findViewById(R.id.etMobilePhone);
        etAddress = (EditText)findViewById(R.id.etAddress);
        etZipCode = (EditText)findViewById(R.id.etZipCode);


        Button btnSubmit=(Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String hPhone = etHomePhone.getText().toString();
                String mobile = etMobilePhone.getText().toString();
                String address = etAddress.getText().toString();
                String zip = etZipCode.getText().toString();


                if(name.equals("")||email.equals("")){
                    Toast.makeText(getApplicationContext(),"Name and Email are mandatory fields.",Toast.LENGTH_SHORT).show();
                }else if(hPhone.equals("")&&mobile.equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter Home Phone or Mobile Number.",Toast.LENGTH_SHORT).show();

                }else if(!isValidEmail(email)){
                    Toast.makeText(getApplicationContext(),"Please enter valid email.",Toast.LENGTH_SHORT).show();

                }else{

                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name",name);
                    bundle.putString("email",email);
                    bundle.putString("hPhone",hPhone);
                    bundle.putString("mobile",mobile);
                    bundle.putString("address",address);
                    bundle.putString("zip",zip);

                    intent.putExtra("bundle",bundle);
                    startActivity(intent);

                }

            }
        });
    }



    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
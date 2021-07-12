package com.arun.mytestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle bundle = getIntent().getBundleExtra("bundle");

        TextView tvName = (TextView)findViewById(R.id.tvName);
        TextView tvEmail = (TextView)findViewById(R.id.tvEmail);
        TextView tvHomePhone = (TextView)findViewById(R.id.tvHomePhone);
        TextView tvMobilePhone = (TextView)findViewById(R.id.tvMobilePhone);
        TextView tvAddress = (TextView)findViewById(R.id.tvAddress);
        TextView tvZipCode = (TextView)findViewById(R.id.tvZipCode);

        tvName.setText(bundle.getString("name"));
        tvEmail.setText(bundle.getString("email"));
        tvHomePhone.setText(bundle.getString("hPhone"));
        tvMobilePhone.setText(bundle.getString("mobile"));
        tvAddress.setText(bundle.getString("address"));
        tvZipCode.setText(bundle.getString("zip"));
    }
}
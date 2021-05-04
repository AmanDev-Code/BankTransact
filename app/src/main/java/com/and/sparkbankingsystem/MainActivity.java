package com.and.sparkbankingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView customer,transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customer=findViewById(R.id.customer);
        transaction=findViewById(R.id.transaction);

        customer.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Registered_clients.class)));

        transaction.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Clients_history.class)));
    }
}
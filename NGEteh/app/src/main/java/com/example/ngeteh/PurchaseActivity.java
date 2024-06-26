package com.example.ngeteh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PurchaseActivity extends AppCompatActivity {
    private TextView textViewProductName, textViewProductPrice;
    private Button buttonPurchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        textViewProductName = findViewById(R.id.textViewProductName);
        textViewProductPrice = findViewById(R.id.textViewProductPrice);
        buttonPurchase = findViewById(R.id.buttonPurchase);

        // Retrieve product data from intent
        String productName = getIntent().getStringExtra("PRODUCT_NAME");
        double productPrice = getIntent().getDoubleExtra("PRODUCT_PRICE", 0.0);

        textViewProductName.setText(productName);
        textViewProductPrice.setText(String.valueOf(productPrice));

        buttonPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the purchase process here
                Toast.makeText(PurchaseActivity.this, "Purchase Successful", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

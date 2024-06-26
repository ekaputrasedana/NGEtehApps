package com.example.ngeteh;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {
    private ListView listViewCart;
    private Button buttonCheckout;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        listViewCart = findViewById(R.id.listViewCart);
        buttonCheckout = findViewById(R.id.buttonCheckout);

        db = new DatabaseHelper(this);
        loadCartItems();

        buttonCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.clearCart();
                Toast.makeText(CartActivity.this, "Checkout successful", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void loadCartItems() {
        Cursor cursor = db.getCartItems();
        String[] from = {"name", "price", "quantity"};
        int[] to = {R.id.textProductName, R.id.textProductPrice, R.id.textProductQuantity};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.cart_item, cursor, from, to, 0);
        listViewCart.setAdapter(adapter);
    }

}

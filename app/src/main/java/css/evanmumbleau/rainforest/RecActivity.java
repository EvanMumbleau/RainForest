package css.evanmumbleau.rainforest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec);
    }

    //public void bButt(View View) {

        //Toast.makeText(RecActivity.this, "Going to Checkout...", Toast.LENGTH_LONG).show();
        //Intent bc = new Intent (RecActivity.this,CheckoutActivity.class);
       // startActivity(bc);
   // }

    public void homeButt(View View) {

        Toast.makeText(RecActivity.this, "Going to Gaming Laptops...", Toast.LENGTH_LONG).show();
        Intent bp = new Intent (RecActivity.this,MainActivity.class);
        startActivity(bp);
    }


}


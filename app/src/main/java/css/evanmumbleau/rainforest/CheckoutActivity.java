package css.evanmumbleau.rainforest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

        TextView final_text;
        TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        final_text = (TextView)findViewById(R.id.final_result);
    }
}

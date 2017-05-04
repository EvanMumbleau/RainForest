package css.evanmumbleau.rainforest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {


        TextView final_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        final_text = (TextView)findViewById(R.id.final_result);
        Bundle extras = getIntent().getExtras();
        ArrayList<String> selection =  extras.getStringArrayList("SELECT");


        final_text.setText(selection.get(0));
       // final_text.setText(bundle);


    }
}

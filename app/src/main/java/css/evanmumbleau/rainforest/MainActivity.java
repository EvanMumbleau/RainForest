package css.evanmumbleau.rainforest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    Button buttonAddC;

    CheckBox checkbox, checkbox2, checkbox3, checkbox4, checkbox5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkbox = (CheckBox) findViewById(R.id.checkBox);
        checkbox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkbox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkbox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkbox5 = (CheckBox) findViewById(R.id.checkBox5);
    }

   //maybe...??? (checkbox setup)
    public void onClicked(View view){
       //is the view now checked?
       boolean checked = (CheckBox) view).isChecked();

       //Check which checkbox was clicked
       switch(view.getId()){
           if (checked)
       }
   }


    private void setupButtonClickEvents() {

    }

}

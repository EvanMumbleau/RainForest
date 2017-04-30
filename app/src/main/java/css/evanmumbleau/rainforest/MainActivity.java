package css.evanmumbleau.rainforest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button buttonAddC;

    CheckBox checkbox, checkbox2, checkbox3, checkbox4, checkbox5;

    ArrayList<String> selection = new ArrayList<String>();

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
    public void selectItem(View view){
       //is the view now checked?
       boolean checked = ((CheckBox) view).isChecked();

       //Check which checkbox was clicked
       switch(view.getId()){
           case  R.id.checkBox:
                if(checked)
                {selection.add("Dell - Inspiron");}
                        else{
                    selection.remove("Dell - Inspiron");
                }
                    break;
           case  R.id.checkBox2:
               if(checked)
               {selection.add("HP - OMEN");}
               else{
                   selection.remove("HP - OMEN");
               }
               break;
           case  R.id.checkBox3:
               if(checked)
               {selection.add("Alienware");}
               else{
                   selection.remove("Alienware");
               }
               break;
           case  R.id.checkBox4:
               if(checked)
               {selection.add("Asus - ROG GL502VM");}
               else{
                   selection.remove("Asus - ROG GL502VM");
               }
               break;
           case  R.id.checkBox4:
               if(checked)
               {selection.add("MSI");}
               else{
                   selection.remove("MSI");
               }
               break;
       }
       }

    public void finalSelection(View View) {

        String final_laptop_selection = "";

        for(String Selections : selection){
            final_laptop_selection = final_laptop_selection + Selections + "\n";
        }
    }

}

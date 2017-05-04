package css.evanmumbleau.rainforest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button buttonAddC;

    CheckBox checkbox, checkbox2, checkbox3, checkbox4, checkbox5;

    ArrayList<String> selection = new ArrayList<String>();
    ArrayList<String> price = new ArrayList<String>();
    TextView final_text;
    TextView tvTotal;
    DatabaseReference myDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final_text = (TextView)findViewById(R.id.final_result);

        checkbox = (CheckBox) findViewById(R.id.checkBox);
        checkbox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkbox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkbox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkbox5 = (CheckBox) findViewById(R.id.checkBox5);

        int totalPrice = 0;
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myDbRef = database.getReference("Everyone Votes");
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
           case  R.id.checkBox5:
               if(checked)
               {selection.add("MSI");}
               else{
                   selection.remove("MSI");
               }
               break;
       }
       }


    public void finalSelection(View View) {

        Toast.makeText(MainActivity.this, "Item(s) added to your cart!", Toast.LENGTH_LONG).show();

        String final_laptop_selection = "";

        for(String Selections : selection){
            final_laptop_selection = final_laptop_selection + Selections + "\n";
        }

        //final_text.setText(final_laptop_selection);
            //final_text.setEnabled(true);



        //firebase code
        //firebaseReference = new Firebase("https://rainforest-d272b.firebaseio.com/");

        Log.d("CIS3334", "saving Data: ");        // debugging log
        // ---- Get a new database key for the vote
        String key = myDbRef.child("Data").push().getKey();
        // ---- set up the vote
        String voteText = editTextVote.getText().toString();
        Integer voteNum = 0;
        if (voteText.compareToIgnoreCase("Dell - Inspiron")==0) {
            voteNum = 1;
        } else if (voteText.compareToIgnoreCase("CAT")==0) {
            voteNum = 2;
        }
        Vote vote = new Vote(voteText, voteNum);
        // ---- write the vote to Firebase
        myDbRef.child("Data").child(key).setValue(Data);



        Intent i = new Intent (MainActivity.this,CheckoutActivity.class);
        i.putStringArrayListExtra("SELECT", selection);
        startActivity(i);

    }

//firebase code
    myDbRef.child("Data").addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            Log.d("CIS3334", "Starting onDataChange()");        // debugging log
            editTextAllVotes.setText("");           // clear out the all votes text box
            // loop through all the votes returned
            for (DataSnapshot voteDataSnapshot : dataSnapshot.getChildren()) {
                Vote vote = voteDataSnapshot.getValue(Vote.class);          // get the current vote from the data set returned
                editTextAllVotes.append("\n" + vote.toString());            // display the vote in the edit text widget
            }
        }

}
}

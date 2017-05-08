package css.evanmumbleau.rainforest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class CheckoutActivity extends AppCompatActivity {

    DatabaseReference myDbRef;
        TextView final_text;
        //String final_laptop_selection;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myDbRef = database.getReference("Data");

        final_text = (TextView)findViewById(R.id.final_result);
        Bundle extras = getIntent().getExtras();
        ArrayList<String> selection =  extras.getStringArrayList("SELECT");

        String final_laptop_selection = "";
        for(String Selections : selection){
            String key = myDbRef.child("Data").push().getKey();
            final_laptop_selection = final_laptop_selection + Selections + "\n";
            String orderItem = Selections;




            myDbRef.child("Data").child(key).setValue(orderItem);
        }
        final_text.setText(final_laptop_selection);

    }


////firebase code
//    myDbRef.child("Data").addValueEventListener(new ValueEventListener() {
//        @Override
//        public void onDataChange (DataSnapshot dataSnapshot){
//            //Log.d("CIS3334", "Starting onDataChange()");        // debugging log
//            editTextAllVotes.setText("");           // clear out the all votes text box
//            // loop through all the votes returned
//            for (DataSnapshot voteDataSnapshot : dataSnapshot.getChildren()) {
//                Vote vote = voteDataSnapshot.getValue(Vote.class);          // get the current vote from the data set returned
//                editTextAllVotes.append("\n" + vote.toString());            // display the vote in the edit text widget
//            }
//
//        }
//
//    }
public void rec(View View) {

    Toast.makeText(CheckoutActivity.this, "Recommended Items...", Toast.LENGTH_LONG).show();
    Intent o = new Intent (CheckoutActivity.this,RecActivity.class);
    startActivity(o);
}



}

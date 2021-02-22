package v.abhijeet.firebaseregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText email, mobile,name;
    Button btnreg,btnimg;
    FirebaseDatabase database;
    DatabaseReference ref;
    int maxid = 0;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.et_name);
        email = findViewById(R.id.et_email);
        mobile = findViewById(R.id.et_phone);
        btnreg = findViewById(R.id.btnregister);
        btnimg = findViewById(R.id.btnimage);

        member = new Member();

        ref = database.getInstance().getReference().child("Students");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    maxid = (int)dataSnapshot.getChildrenCount();
                }else{
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                member.setName(name.getText().toString());
                member.setMobile(mobile.getText().toString());
                member.setEmail(email.getText().toString());


                ref.child(String.valueOf(maxid + 1)).setValue(member);
                Intent i = new Intent(MainActivity.this, Retrive.class);

                startActivity(i);

            }
        });

        btnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ImageRetrive.class);

                startActivity(i);

            }
        });
    }
}
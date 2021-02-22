package v.abhijeet.firebaseregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Retrive extends AppCompatActivity {
    ListView listView;
    List<Member> memberList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive);

        listView = findViewById(R.id.listview);

        memberList = new ArrayList<>();



        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Students");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                memberList.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    Member member = snapshot.getValue(Member.class);
                    memberList.add(member);
                }
               ListAdapter adapter = new ListAdapter(Retrive.this,memberList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
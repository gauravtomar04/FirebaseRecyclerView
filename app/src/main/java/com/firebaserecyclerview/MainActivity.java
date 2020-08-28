package com.firebaserecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    List<NameList> nameLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView=findViewById(R.id.text);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        nameLists = new ArrayList<>();

        DatabaseReference db=FirebaseDatabase.getInstance().getReference("String");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String data=snapshot.child("ok").getValue(String.class);
                textView.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        DatabaseReference db= FirebaseDatabase.getInstance().getReference("Team");
//        db.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()){
//                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
//                       NameList s=dataSnapshot.getValue(NameList.class);
//                       nameLists.add(s);
//                    }
//
//                    adapter = new Adapter(MainActivity.this, nameLists);
//                    recyclerView.setAdapter(adapter);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
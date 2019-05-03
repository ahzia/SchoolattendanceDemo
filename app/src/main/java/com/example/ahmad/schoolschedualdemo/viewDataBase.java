package com.example.ahmad.schoolschedualdemo;
//for firebase connection ...
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewDataBase extends AppCompatActivity {
    private static final String tag="viewDB";
    private static final String TAG ="" ;
    //fireBase data base stuff
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    //view items
    private ListView mListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_database_layout);
        mListView =(ListView) findViewById(R.id.listView);
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        myRef=mFirebaseDatabase.getReference("Student");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //StudentAttendance stuAttend=dataSnapshot.getValue(StudentAttendance.class);
                //showData(dataSnapshot);
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());

                // ...
            }
        });
    }

    private void showData(DataSnapshot dataSnapshot) {
        //DataBase is in test mode, no need for authentication.
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            StudentAttendance stuAttend =new StudentAttendance();
            stuAttend.setName(ds.child("Student").child("01").getValue(StudentAttendance.class).getName()); //set the name
            stuAttend.setPhone(ds.child("Student").child("01").getValue(StudentAttendance.class).getPhone()); //set the Date

            //display
            Log.d(TAG,"show Data:NAme"+stuAttend.getName());
            //show in list view
            ArrayList <String> array =new ArrayList<>();
            array.add(stuAttend.getName());
            array.add(stuAttend.getPhone());
            ArrayAdapter adapter =new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
            mListView.setAdapter(adapter);
        }
    }
}

package com.example.taskmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class updatedata extends AppCompatActivity {


    public int uid=0;
    EditText fname, lname;
    Button btn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedata);


        fname=findViewById(R.id.editfname);
        lname=findViewById(R.id.editlname);
        btn=findViewById(R.id.btn);

        //uid=Integer.parseInt(getIntent().getStringExtra("uid"));
        //uid=getIntent().getStringExtra("uid");

        //uid=Integer.parseInt(getIntent().getStringExtra("uid"));

       // uid= Integer.parseInt(getIntent().getStringExtra("uid"));

        uid=Integer.parseInt(getIntent().getStringExtra("uid"));

        //if(uid!=-1){


        //}

        fname.setText(getIntent().getStringExtra("ufname"));
        lname.setText(getIntent().getStringExtra("ulname"));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "room_db").allowMainThreadQueries().build();
                UserDao userDao = db.userDao();
                userDao.updateById(uid,fname.getText().toString(),lname.getText().toString());
                startActivity(new Intent(getApplicationContext(),fetchdata.class));
                finish();
            }
        });
    }
}

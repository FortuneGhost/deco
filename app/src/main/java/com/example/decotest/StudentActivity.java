package com.example.decotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity {
    Button stdbtn;
    TextView sysno;
    EditText complaint;
    public static String bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        stdbtn =(Button)findViewById(R.id.Studentbtn);
        sysno =(TextView)findViewById(R.id.SystemNo);
        complaint =(EditText)findViewById(R.id.Complaint);
        sysno.setText(bd);
        Toast.makeText(getApplicationContext(), "To"+bd, Toast.LENGTH_SHORT).show();

    }
}

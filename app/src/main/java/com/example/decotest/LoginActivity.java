package com.example.decotest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    public static Integer pas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        /*if (firebaseAuth.getCurrentUser() != null) {
            //finish();
            startActivity(new Intent(this, BarcodeScanActivity.class));
        }*/
    }

    public void login(View view) {
        String email = ((EditText) findViewById(R.id.editTextEmail)).getText().toString();
        String password = ((EditText) findViewById(R.id.editTextPassword)).getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //finish();
                            ScannedBarcodeActivity.btn3.setVisibility(View.GONE);
                            ScannedBarcodeActivity.usr="success";
                            Intent idy=new Intent(getApplicationContext(),ScannedBarcodeActivity.class);
                            //idy.putExtra("pas",2);
                            startActivity(idy);
                            finish();
                            //startActivity(new Intent(getApplicationContext(), ScannedBarcodeActivity.class));
                        } else {
                            ScannedBarcodeActivity.usr="failed";
                            Toast.makeText(getApplicationContext(), "Invalid username/password", Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                });
    }
}

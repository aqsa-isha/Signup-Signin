package com.example.signupactivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class loginActivity extends AppCompatActivity {
    int loginAttempt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bundle b = getIntent().getExtras();
        EditText usernametxt = (EditText) findViewById(R.id.usernametxt);
        EditText passwordtxt = (EditText) findViewById(R.id.passwordtxt);
        Button login = (Button) findViewById(R.id.signin_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usernametxt.getText().toString().isEmpty()) {
                    usernametxt.requestFocus();
                    Toast.makeText(getApplicationContext(), "Please Input Username", Toast.LENGTH_LONG).show();
                } else if (passwordtxt.getText().toString().isEmpty()) {
                    passwordtxt.requestFocus();
                    Toast.makeText(getApplicationContext(), "Please Input Password", Toast.LENGTH_LONG).show();
                } else {
                    if (usernametxt.getText().toString().equals(b.getCharSequence("username")) && passwordtxt.getText().toString().equals(b.getCharSequence("password"))) {
                        Intent intent = new Intent(getApplicationContext(), dashboard.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_LONG).show();
                        loginAttempt++;
                        if (loginAttempt == 2) {
                            Toast.makeText(getApplicationContext(), "Failed Login Attempts", Toast.LENGTH_LONG).show();
                            login.setEnabled(false);
                        }
                    }
                }
            }
        });
    }
}
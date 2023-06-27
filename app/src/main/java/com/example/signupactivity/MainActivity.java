package com.example.signupactivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    String user, pass;
    boolean valid, upper, lower, digit = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Signup, Signin (02, 14, 43)");
        EditText username = (EditText) findViewById(R.id.Usernametxt);
        EditText password = (EditText) findViewById(R.id.Passwordtxt);
        Button signup = (Button) findViewById(R.id.signup_btn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                    if (username.getText().toString().isEmpty()) {
                        username.requestFocus();
                        Toast.makeText(getApplicationContext(), "Please Input Username", Toast.LENGTH_LONG).show();
                    } else {
                        password.requestFocus();
                        Toast.makeText(getApplicationContext(), "Please Input Password", Toast.LENGTH_LONG).show();
                    }
                } else if (password.getText().length() < 8) {
                    password.requestFocus();
                    Toast.makeText(getApplicationContext(), "Password must contain atleast 8 characters", Toast.LENGTH_SHORT).show();
                } else {
                    upper = digit = lower = false;
                    for (int i = 0; i < password.getText().length(); i++) {
                        if (Character.isUpperCase(password.getText().charAt(i))) {
                            upper = true; }
                        if (Character.isDigit(password.getText().charAt(i))) {
                            digit = true; }
                        if (Character.isLowerCase(password.getText().charAt(i))) {
                            lower = true; }
                    }
                    if (upper == true && lower == true && digit == true) {
                        valid = true;
                    } else {
                        valid = false;
                    }
                    if (valid == true) {
                        pass = password.getText().toString();
                        user = username.getText().toString();
                        Bundle b = new Bundle();
                        b.putString("username", user);
                        b.putString("password", pass);
                        Toast.makeText(getApplicationContext(), "Account Successfully Created!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), loginActivity.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Password should contain atleast 1 Uppercase character, lowercase character, digit and symbol", Toast.LENGTH_SHORT).show();
                        password.requestFocus();
                    }
                }
            }
        });
    }
}
package com.example.sih_rcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/*import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
*/
public class RegistrationActivity extends AppCompatActivity {

    private EditText RegUsername;
    private EditText RegEmail;
    private EditText RegPassword;
    private Button Register;
    private TextView UserLogin;
    private FirebaseAuth mAuth;
    private static final String TAG = "EmailPassword";
    //private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
        setupUIViews();
        mAuth = FirebaseAuth.getInstance();

        //firebaseAuth = FirebaseAuth.getInstance();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount(RegEmail.getText().toString(),RegPassword.getText().toString());

            }
        });

        UserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
            }
        });

    }

    private void setupUIViews(){
        RegUsername=(EditText)findViewById(R.id.etRegName);
        RegEmail=(EditText)findViewById(R.id.etRegEmail);
        RegPassword=(EditText)findViewById(R.id.etRegPassword);
        Register=(Button)findViewById(R.id.btnRegister);
        UserLogin=(TextView)findViewById(R.id.tvUserLogin);
    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);

        // Ye Validate vala function bna dena which checks for empty user and password fields

        if (!validateForm()) {
            return;
        }

        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(RegistrationActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrationActivity.this,Dashboard.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());

                            Toast.makeText(RegistrationActivity.this,"Registration Failure",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
        // [END create_user_with_email]
    }

    private boolean validateForm() {
        boolean valid = true;

        String email =RegEmail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            RegEmail.setError("Required.");
            valid = false;
        } else {
            RegEmail.setError(null);
        }

        String password = RegPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            RegPassword.setError("Required.");
            valid = false;
        } else {
            RegPassword.setError(null);
        }

        return valid;
    }

}

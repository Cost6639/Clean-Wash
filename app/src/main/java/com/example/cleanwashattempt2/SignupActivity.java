package com.example.cleanwashattempt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cleanwashattempt2.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {
    ActivitySignupBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);
        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.signupEmail.getText().toString();
                String password = binding.signupPassword.getText().toString();
                String confirmPassword = binding.signupConfirm.getText().toString();
                if(email.equals("")||password.equals("")||confirmPassword.equals(""))
                    Toast.makeText(SignupActivity.this, "Tidak boleh kosong", Toast.LENGTH_SHORT).show();
                else{
                    if(password.equals(confirmPassword)){
                        Boolean checkUserEmail = databaseHelper.checkEmail(email);
                        if(checkUserEmail == false){
                            Boolean insert = databaseHelper.insertData(email, password);
                            if(insert == true){
                                Toast.makeText(SignupActivity.this, "Akun berhasil dibuat", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SignupActivity.this, "Akun gagal dibuat", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignupActivity.this, "Akun ini sudah ada", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignupActivity.this, "Password tidak sah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
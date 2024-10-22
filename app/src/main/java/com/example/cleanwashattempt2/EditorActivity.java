package com.example.cleanwashattempt2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EditorActivity extends AppCompatActivity {
    EditText editnama, edithp, editcucian, edittgl, editberat, editharga, editstatus;
    Button btn_save;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        editnama = findViewById(R.id.nama);
        edithp = findViewById(R.id.hp);
        editcucian = findViewById(R.id.jeniscucian);
        edittgl = findViewById(R.id.tglmasuk);
        editberat = findViewById(R.id.berat);
        editharga = findViewById(R.id.harga);
        editstatus = findViewById(R.id.status);
        btn_save = findViewById(R.id.btn_save);

        btn_save.setOnClickListener(view -> {
            if (editnama.getText().length()>0 && edithp.getText().length()>0 && editcucian.getText().length()>0 && edittgl.getText().length()>0
                    && editberat.getText().length()>0 && editharga.getText().length()>0 && editstatus.getText().length()>0){
                saveData(editnama.getText().toString(), edithp.getText().toString(), editcucian.getText().toString(), edittgl.getText().toString(),
                        editberat.getText().toString(), editharga.getText().toString(), editstatus.getText().toString());
            }else {
                Toast.makeText(getApplicationContext(), "Silahkan isi semua data!", Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = getIntent();
        if (intent!=null){
            id = intent.getStringExtra("id");
            editnama.setText(intent.getStringExtra("nama"));
            edithp.setText(intent.getStringExtra("hp"));
            editcucian.setText(intent.getStringExtra("cucian"));
            edittgl.setText(intent.getStringExtra("tglmasuk"));
            editberat.setText(intent.getStringExtra("berat"));
            editharga.setText(intent.getStringExtra("harga"));
            editstatus.setText(intent.getStringExtra("status"));
        }
    }

    private void saveData(String nama, String hp, String jeniscucian, String tglmasuk, String berat, String harga, String status){
        Map<String, Object> user = new HashMap<>();
        user.put("Nama", nama);
        user.put("No HP", hp);
        user.put("Jenis Cucian", jeniscucian);
        user.put("Tanggal Masuk", tglmasuk);
        user.put("Berat", berat);
        user.put("Harga", harga);
        user.put("Status", status);

        if (id!=null){
            db.collection("users").document(id)
                    .set(user)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Berhasil!", Toast.LENGTH_SHORT).show();
                                finish();
                            }else{
                                Toast.makeText(getApplicationContext(), "Gagal!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }else {
            db.collection("users")
                    .add(user)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(getApplicationContext(), "Berhasil!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Gagal!", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
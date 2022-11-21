package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Add_list extends AppCompatActivity {
    Button btn_save,btn_back;
    EditText edt_tencay,edt_dactinh,edt_address_image;

    public static boolean status = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);


        Anhxa();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserData();
                clearAll();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Add_list.this,MainActivity.class);
                status = true;
                startActivity(intent);

            }
        });

    }

    private void Anhxa() {
        btn_save=(Button) findViewById(R.id.btn_save);
        btn_back=(Button) findViewById(R.id.btn_back);

        edt_tencay = findViewById(R.id.edt_tencay);
        edt_dactinh = findViewById(R.id.edt_dactinh);
        edt_address_image = findViewById(R.id.edt_address_image);
    }

    private void inserData(){

        Map<String,Object> map = new HashMap<>();
        map.put("tencay",edt_tencay.getText().toString());
        map.put("dactinh",edt_dactinh.getText().toString());
        map.put("image",edt_address_image.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Cay").push()
                .setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Add_list.this,"Successfully completed",Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Add_list.this,"Failure addition",Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private  void clearAll(){
        edt_tencay.setText("");
        edt_dactinh.setText("");
        edt_address_image.setText("");
    }

}
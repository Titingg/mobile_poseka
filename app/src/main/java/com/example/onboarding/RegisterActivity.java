package com.example.onboarding;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.model.Progress;

import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    Button btnreg;
    EditText etuser,etemail,etpass;
    String Suser,Semail,Spass;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etuser = findViewById(R.id.inputUsername);
        etemail = findViewById(R.id.inputEmail);
        etpass = findViewById(R.id.inputPassword);
        btnreg = findViewById(R.id.btnRegister);
        progressDialog = new ProgressDialog(this);


        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setMessage("Menambahkan data");
                progressDialog.setCancelable(false);
                progressDialog.show();

                Suser = etuser.getText().toString();
                Semail = etemail.getText().toString();
                Spass = etpass.getText().toString();

                kirimData();


            }
        });

        TextView btn=findViewById(R.id.alreadyHaveAccount);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }


    void kirimData(){
        AndroidNetworking.post("https://tkjbpnup.com/kelompok_11/poseka/register.php")
                .addBodyParameter("username",""+Suser)
                .addBodyParameter("email",""+Semail)
                .addBodyParameter("password",""+Spass)
                .setPriority(Priority.MEDIUM)
                .setTag("Tambah Data")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        Log.d("cekTambah", "" + response);
                        try {
                            Boolean status = response.getBoolean("status");
                            String pesan = response.getString("result");
                            Toast.makeText(RegisterActivity.this, "" + pesan, Toast.LENGTH_SHORT).show();
                            Log.d("status", "" + status);
                            if (status) {
                                new AlertDialog.Builder(RegisterActivity.this)
                                        .setMessage("Berhasil Menambahkan Data !")
                                        .setCancelable(false)
                                        .setPositiveButton("Kembali", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent page;
                                                page = new Intent(RegisterActivity.this, LoginActivity.class);
                                                startActivity(page);
                                            }
                                        })
                                        .show();
                            } else {
                                new AlertDialog.Builder(RegisterActivity.this)
                                        .setMessage("Gagal Menambahkan Data !")
                                        .setPositiveButton("Kembali", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                //Intent i = getIntent();
                                                //setResult(RESULT_CANCELED,i);
                                                //add_mahasiswa.this.finish();
                                            }
                                        })
                                        .setCancelable(false)
                                        .show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }


                    @Override
                    public void onError(ANError anError) {
                        Log.d("ErrorTambahData", "" + anError.getErrorBody());
                    }
                });
         }

}
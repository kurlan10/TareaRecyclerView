package com.example.coursera.tarearecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coursera.tarearecyclerview.utilities.SendMailTask;

import java.util.Arrays;
import java.util.List;

public class ContactoActivity extends AppCompatActivity {
    private Button btnSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar mascotarToolBar= (Toolbar)findViewById(R.id.mascotasActionBar);
        setSupportActionBar(mascotarToolBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnSiguiente= (Button)findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try {
                String fromEmail = "";
                String fromPassword = "";

                String toEmails = ((TextView) findViewById(R.id.editTextEmail)).getText().toString();
                List<String> toEmailList = Arrays.asList(toEmails.split("\\s*,\\s*"));
                String emailSubject = ((TextView) findViewById(R.id.editTextNombre)).getText().toString();
                String emailBody = ((TextView) findViewById(R.id.editTextMensaje)).getText().toString();

                if(fromEmail.equals("") || fromPassword.equals("")){
                    Toast.makeText(v.getContext(),"Ingresar en ContactoActivity cuenta de gmail con seguridad baja" , Toast.LENGTH_SHORT).show();
                }
                else{
                    new SendMailTask(ContactoActivity.this).execute(fromEmail,
                            fromPassword, toEmailList, emailSubject, emailBody);
                }

            } catch (Exception e) {
                Log.e("ContactoMail::", e.getMessage(), e);
            }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }
}

package br.com.senaijandira.controlefinanceiro;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class mudar_tela_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mudar_tela);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void categoria (View view) {

        Intent intent = new Intent(this, activity_adicionar_categoria.class);
        startActivity(intent);

    }

    public void ganho (View view) {

        Intent intent = new Intent(this, cadastrar_ganho_Activity.class);
        startActivity(intent);


    }

}

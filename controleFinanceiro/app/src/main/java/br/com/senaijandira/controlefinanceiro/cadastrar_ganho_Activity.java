package br.com.senaijandira.controlefinanceiro;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class cadastrar_ganho_Activity extends AppCompatActivity {

    EditText txt_ganho, txt_descricao, txt_data;
    RadioButton rb_investimento, rb_salario, rb_poupanca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_ganho);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        txt_ganho = (EditText) findViewById(R.id.txt_ganho);
        txt_descricao = (EditText) findViewById(R.id.txt_descricao);
        txt_data = (EditText) findViewById(R.id.txt_data);

        rb_investimento = (RadioButton) findViewById(R.id.rb_investimento);
        rb_salario = (RadioButton) findViewById(R.id.rb_salario);
        rb_poupanca = (RadioButton) findViewById(R.id.rb_poupanca);




    }

    public void confirmar(View view) {

        Informacao i = new Informacao();

        i.setGanho(txt_ganho.getText().toString());

        i.setDescricao(txt_descricao.getText().toString());

        i.setData(txt_data.getText().toString());

        if (rb_poupanca.isChecked()){
            i.setCategoria(rb_poupanca.getText().toString());
        }else
        if (rb_investimento.isChecked()){
            i.setCategoria(rb_investimento.getText().toString());
        }else
        if (rb_salario.isChecked()){
            i.setCategoria(rb_salario.getText().toString());
        }

        informacaoDAO.getInstance().inserir(this, i);





    }


}

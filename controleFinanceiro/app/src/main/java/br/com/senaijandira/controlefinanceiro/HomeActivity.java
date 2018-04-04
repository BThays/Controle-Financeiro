package br.com.senaijandira.controlefinanceiro;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    informacaoDAO dao;
    TextView valor_atual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dao = informacaoDAO.getInstance();


        valor_atual = (TextView) findViewById(R.id.valor_atual);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Double receber = dao.selecionarGanho(this);
        valor_atual.setText(receber.toString());

    }

    public void mudarTela(View view) {

        Intent intent = new Intent(getApplicationContext(), mudar_tela_Activity.class);

        startActivity(intent);
    }

    public Double selecionarGanho(Context context){

        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();

        String sql = "select sum(ganho) from tbl_valores;";

        Cursor cursor = db.rawQuery(sql,new String[]{});
        cursor.moveToFirst();


        cursor.close();
        return cursor.getDouble(0);

    }
}

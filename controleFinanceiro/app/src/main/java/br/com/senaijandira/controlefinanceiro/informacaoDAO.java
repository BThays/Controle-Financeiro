package br.com.senaijandira.controlefinanceiro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by 17170076 on 03/04/2018.
 */

public class informacaoDAO {

    ArrayList<Informacao> lstInformacao = new ArrayList<>();

    private Integer idGanho = 0;

    private static informacaoDAO instance;

    public static informacaoDAO getInstance() {
        if(instance == null)
            instance = new informacaoDAO();

        return instance;
    }


    public Boolean inserir (Context context, Informacao c) {
        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("categoria", c.getCategoria());
        valores.put("ganho", c.getGanho());
        valores.put("descricao", c.getDescricao());
        valores.put("data", c.getData());

        Long id = db.insert("tbl_valores", null, valores);

        if(id != -1)
            return true;
        else
            return false;
    }

    //Somar os valores que forem adicionados no campo ''GANHO''
    public Double selecionarGanho(Context context){

        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();

        String sql = "select sum(ganho) from tbl_valores;";

        Cursor cursor = db.rawQuery(sql,new String[]{});
        cursor.moveToFirst();


        Double r = cursor.getDouble(0);

        cursor.close();

        return r;

    }

}


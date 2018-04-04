package br.com.senaijandira.controlefinanceiro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 17170076 on 03/04/2018.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static String DB_VALORES = "valores.db";

    private static int DB_VERSION = 1;

    public DbHelper (Context ctx) {super(ctx, DB_VALORES, null, DB_VERSION);}


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table tbl_valores( " +
        "_id INTEGER primary key autoincrement, " +
        "categoria TEXT, " +
        "ganho TEXT, " +
        "descricao TEXT, "+
        "data INTEGER);";


        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table tbl_valores;");
        onCreate(db);

    }

}

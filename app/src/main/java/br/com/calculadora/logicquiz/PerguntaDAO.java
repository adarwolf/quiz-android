package br.com.calculadora.logicquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by andre on 12/08/16.
 */
public class PerguntaDAO extends SQLiteOpenHelper{

    public PerguntaDAO(Context context) {
        super(context, "Questao", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Pergunta (id INTEGER PRIMARY KEY," +
                                            " pergunta TEXT NOT NULL," +
                                            " alterA TEXT," +
                                            " alterB TEXT," +
                                            " alterC TEXT," +
                                            " alterD TEXT," +
                                            " resposta TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<String> busca(int id) {
        String sql = "SELECT * FROM Pergunta WHERE id = " + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        ArrayList<String> pergunta = new ArrayList<String>();

        while(c.moveToNext()){

            pergunta.add(c.getString(c.getColumnIndex("pergunta")));
            pergunta.add(c.getString(c.getColumnIndex("alterA")));
            pergunta.add(c.getString(c.getColumnIndex("alterB")));
            pergunta.add(c.getString(c.getColumnIndex("alterC")));
            pergunta.add(c.getString(c.getColumnIndex("alterD")));
            pergunta.add(c.getString(c.getColumnIndex("resposta")));
        }
        return pergunta;
    }
}

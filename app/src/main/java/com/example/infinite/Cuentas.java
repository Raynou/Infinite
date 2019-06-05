package com.example.infinite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.infinite.utilidades.Utilidades;


public class Cuentas extends SQLiteOpenHelper {
    public Cuentas(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase cuentas) {
        cuentas.execSQL(Utilidades.CREATE_TABLE_CUENTAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Utilidades.UPDATE_TABLE_CUENTAS);
        onCreate(db);
    }
}

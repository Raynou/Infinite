package com.example.infinite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.infinite.utilidades.Utilidades;


public class MainActivity extends AppCompatActivity {
    EditText Nick, Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        Nick = (EditText)findViewById(R.id.edt_Nick);
        Pass = (EditText)findViewById(R.id.edt_Pass);
    }

    //Método para abrir el resgistro.
    public void AbrirRegistro(View view) {
        try {
            Intent i = new Intent(this, Registro.class);
            startActivity(i);
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    //Entrar
    public void Entrar(View view){
        try
        {
            Intent i = new Intent(this, MainMenu.class);
            Cuentas admin = new Cuentas(this, "Cuentas", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();

            //Variables.
            String nickname = Nick.getText().toString();
            String contraseña = Pass.getText().toString();

            Cursor fila = db.rawQuery(
                    "select " + Utilidades.NICKNAME + "," + Utilidades.CONTRASEÑA + " from "
                            + Utilidades.TABLA_CUENTAS + " where "+Utilidades.NICKNAME+"='" +
                            nickname + "'" + "and "+Utilidades.CONTRASEÑA+"='" +contraseña +"'", null);

            if (fila.moveToFirst())
            {
                String ValidacionN = fila.getString(0);
                String ValidacionC = fila.getString(1);
                if (ValidacionN.equals(nickname) && ValidacionC.equals(contraseña))
                {
                    Toast.makeText(this, "Sesión iniciada", Toast.LENGTH_SHORT).show();
                    startActivity(i);
                }

            }
            else
            {
                Toast.makeText(this, "Usuario/contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}

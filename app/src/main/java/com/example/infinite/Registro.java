package com.example.infinite;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.infinite.utilidades.Utilidades;


import java.util.ArrayList;


public class Registro extends AppCompatActivity {

    EditText Email, Nickname, Contraseña, Nombre, apellido;
    Button close;
    Spinner dia,mes,año;

    /*String nombre = Nombre.getText().toString();
    String nick = Nickname.getText().toString();
    String password = Contraseña.getText().toString();
    String email = Email.getText().toString();*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registro);
            init();
            LlenarSpinner();


    }
    //init
    public void init(){

        close = (Button)findViewById(R.id.btn_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Close();
            }
        });
        Email = (EditText)findViewById(R.id.edt_Email);
        Nickname = (EditText)findViewById(R.id.edt_Nickname);
        Contraseña = (EditText)findViewById(R.id.edt_Password);
        Nombre = (EditText)findViewById(R.id.edt_Name);
        dia = (Spinner)findViewById(R.id.spin_dia);
        mes = (Spinner)findViewById(R.id.spin_mes);
        año = (Spinner)findViewById(R.id.spin_año);
        apellido = (EditText)findViewById(R.id.edt_Apelido);
    }

    //close
    public void Close(){
        this.finish();
    }

    //Método para registrarse. Base de datos: Cuentas.
    public void Registrar(View view) {
        try
        {
            Cuentas admin = new Cuentas(this, "Cuentas", null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();

            //Variables del spinner.
            String Dia = dia.getSelectedItem().toString();
            String Mes = mes.getSelectedItem().toString();
            String Año = año.getSelectedItem().toString();

            //Variables para la database.
            String nickname = Nickname.getText().toString();
            String contraseña = Contraseña.getText().toString();
            String email = Email.getText().toString();
            String nombre = Nombre.getText().toString();
            String nacimiento = Dia + "/"+ Mes + "/" + Año;

            if (!nickname.equals("") && !contraseña.equals("") && !email.equals("") && !nombre.equals("") && !nacimiento.equals("") || email.contains("@gmail.com") || email.contains("@yahoo.com" ) || email.contains("@yahoo.mx")
                    ||email.contains("@outlook.com")||email.contains("@hotmail.com") && apellido.equals(""))
            {
                Cursor fila = db.rawQuery(
                        "select "+Utilidades.NICKNAME+", "+Utilidades.EMAIL+" from "+Utilidades.TABLA_CUENTAS+" where "+
                                Utilidades.NICKNAME+"='"+nickname+"'",null);
                if (fila.moveToFirst())
                {
                    String nickVal = fila.getString(0);
                    Toast.makeText(this, "El nombre " + nickVal + " ya está en uso", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    ContentValues Registro = new ContentValues();
                    Registro.put(Utilidades.NOMBRE, nombre);
                    Registro.put(Utilidades.EMAIL, email);
                    Registro.put(Utilidades.CONTRASEÑA, contraseña);
                    Registro.put(Utilidades.NACIMIENTO, nacimiento);
                    Registro.put(Utilidades.NICKNAME, nickname);
                    db.insert(Utilidades.TABLA_CUENTAS, null, Registro);
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    db.close();

                    this.finish();
                }


            }
            else
            {
                if (!email.contains("@") || !email.contains(".com")
                        ||!email.contains(".mx") || !email.contains("yahoo") || !email.contains("hotmail")||
                        !email.contains("gmail"))
                {
                    if(email.equals("") || nombre.equals("")||contraseña.equals("")||nickname.equals("")||apellido.equals("")){

                    }
                    else {Toast.makeText(this, "Ingrese una dirección de correo electrónico válida", Toast.LENGTH_SHORT).show();}


                }
                if(email.equals("") || nombre.equals("")||contraseña.equals("")||nickname.equals("")||apellido.equals("")){
                    Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show();
            }
                else {
                    Toast.makeText(this, "Error en el registro", Toast.LENGTH_SHORT).show();
                }

                db.close();
            }


        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
  }

    //Llenado de los spinner
    public void LlenarSpinner(){


        try{
            ArrayList<Integer> diaList = new ArrayList<Integer>();
       ;
            for (int i=1; i<=31; i++){
                diaList.add(i);
            }

            ArrayList<Integer> añosList = new ArrayList<Integer>();

            for (int ia=1940; ia<=2020; ia++){
                añosList.add(ia);
            }

            ArrayList<Integer> mesList = new ArrayList<Integer>();

            for (int im=1; im<=12; im++)
            {
                mesList.add(im);
            }

            ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, diaList);
            ArrayAdapter<CharSequence> adapter2 = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, añosList);
            ArrayAdapter<CharSequence> adapter3 = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, mesList);

            dia.setAdapter(adapter);
            mes.setAdapter(adapter3);
            año.setAdapter(adapter2);





        }
        catch (Exception e){Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();}

    }



    //Ocultar teclado.
    public void HideKeyBoard()
    {
        View view = this.getCurrentFocus();
        if (view !=null)
        {
            InputMethodManager im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}


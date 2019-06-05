package com.example.infinite.utilidades;

public class Utilidades {

    //Variables de la tabla: Cuentas
    public static final String TABLA_CUENTAS ="cuentas_infinite";
    public static final String NOMBRE ="nombre";
    public static final String EMAIL ="email";
    public static final String CONTRASEÑA ="contraseña";
    public static final String NACIMIENTO ="nacimiento";
    public static final String NICKNAME ="nickname";


    //Constante para crear tablas.
    public static final String CREATE_TABLE_CUENTAS =
            "create table "+TABLA_CUENTAS +"("+NOMBRE+ " string, "+EMAIL+" string, "+CONTRASEÑA+
                    " string, "+NACIMIENTO+" string, "+NICKNAME+" string)";
    //Constante para updrage.
    public static final String UPDATE_TABLE_CUENTAS="DROP TABLE IF EXISTS " + TABLA_CUENTAS;



}

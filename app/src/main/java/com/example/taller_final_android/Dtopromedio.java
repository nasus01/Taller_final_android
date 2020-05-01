package com.example.taller_final_android;

public class Dtopromedio {


    private String idunico;
    private String codigo;
    private String nombre;
    private String resultado;

    public Dtopromedio(String idunico,String codigo, String nombre, String resultado ){
        this.idunico=idunico;
        this.codigo=codigo;
        this.nombre=nombre;
        this.resultado=resultado;

    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String re) {
        this.resultado = resultado;
    }

    public String getIdunico() {
        return idunico;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }








}

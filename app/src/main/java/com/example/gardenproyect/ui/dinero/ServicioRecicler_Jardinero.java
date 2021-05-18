package com.example.gardenproyect.ui.dinero;

import com.example.gardenproyect.ui.service.ServiceFragment_Cliente;


//Mensaje
public class ServicioRecicler_Jardinero {

    private String text;

    public ServicioRecicler_Jardinero(){}

    public ServicioRecicler_Jardinero(String texto){
        this.text = texto;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

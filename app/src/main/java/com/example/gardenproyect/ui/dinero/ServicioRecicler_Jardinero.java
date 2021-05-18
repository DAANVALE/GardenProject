package com.example.gardenproyect.ui.dinero;

import com.example.gardenproyect.ui.service.ServiceFragment_Cliente;


//Mensaje
public class ServicioRecicler_Jardinero {

    private String textTime;
    private String textDay;
    private String textPlace;

    public ServicioRecicler_Jardinero(){}

    public ServicioRecicler_Jardinero(String textohora, String textodia, String textolugar){
        this.textTime = textohora;
        this.textDay = textodia;
        this.textPlace = textolugar;
    }

    public String getTextTime() { return textTime; }

    public void setTextTime(String textohora) { this.textTime = textohora; }

    public String getTextDay() {
        return textDay;
    }

    public void setTextDay(String textDay) {
        this.textDay = textDay;
    }

    public String getTextPlace() {
        return textPlace;
    }

    public void setTextPlace(String textPlace) {
        this.textPlace = textPlace;
    }
}

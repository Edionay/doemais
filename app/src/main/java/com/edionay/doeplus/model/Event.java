package com.edionay.doeplus.model;

import android.location.Location;

public class Event {

	String titulo;
	String dataInicio;
	String dataFim;
	String local;
	String itens[];
	//Location location;
	String horaInicio;
	String horaFim;

	public Event(){

    }

    public Event(String titulo, String dataInicio, String dataFim, String local, String[] itens, Location location, String horaInicio, String horaFim) {
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.local = local;
        this.itens = itens;
        //this.location = location;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String[] getItens() {
        return itens;
    }

    public void setItens(String[] itens) {
        this.itens = itens;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }
}

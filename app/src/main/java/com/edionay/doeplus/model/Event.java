package com.edionay.doeplus.model;

public class Event {

	String title;
	String date;
	String location;

	public Event(){

    }

    public Event(String title, String date, String local) {
        this.title = title;
        this.date = date;
        this.location = local;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getLocation() {
        return location;
    }

    public void setLocal(String local) {
        this.location = location;
    }


}

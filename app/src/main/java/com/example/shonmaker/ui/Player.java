package com.example.shonmaker.ui;

public class Player {

    private String name;
    private String position;
    private String rate;

    public Player(String name) {
        this.name = name;
    }



    public Player(String name, String position, String rate) {
        this.name = name;
        this.position = position;
        this.rate = rate;
    }



    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String  getRate() {
        return rate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}

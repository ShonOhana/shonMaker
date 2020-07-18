package com.example.shonmaker.ui;

public class Player {

    private String name;
    private String position;
    private int rate;

    public Player(String name) {
        this.name = name;
    }



    public Player(String name, String position, int rate) {
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

    public int getRate() {
        return rate;
    }


}

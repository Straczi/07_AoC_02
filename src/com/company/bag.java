package com.company;

import java.util.ArrayList;

public class bag {
    private final String color;
    private final ArrayList<String> containedBagsList = new ArrayList<>();

    public bag(String color){   //constructor
        this.color = color;
    }


    //setter

    public void addContainedBag(String addedBag){
        this.containedBagsList.add(addedBag);
    }


    //getter
    public String getColor() {
        return this.color;
    }


    public ArrayList<String> getContainedBagsList() {
        return containedBagsList;
    }
}

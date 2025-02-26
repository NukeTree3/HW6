package com.nuketree3.example;

public class Main {
    public static void main(String[] args) {
        MontyHallSimulator montyHallSimulator = new MontyHallSimulator(3,1000);
        System.out.println("со сменной дверей");
        montyHallSimulator.start(true);
        System.out.println("без смены");
        montyHallSimulator.start(false);
    }
}
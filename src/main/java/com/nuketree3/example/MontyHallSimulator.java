package com.nuketree3.example;

import lombok.Data;

import java.util.HashMap;
import java.util.Random;

@Data
public class MontyHallSimulator {
    private int countOfDoors;
    private HashMap<Integer, Boolean> result;
    private Random rand;
    private int countOfIteration;

    public MontyHallSimulator(int countOfDoors, int countOfIteration) {
        rand = new Random();
        result = new HashMap<>();
        this.countOfIteration = countOfIteration;
        this.countOfDoors = countOfDoors;
    }

    public void start(boolean flag){
        result.clear();
        if(flag){
            withChange();
        }else{
            withoutChange();
        }
        printResult();
    }

    private void withoutChange() {
        for(int i = 0; i < countOfIteration; i++) {
            int win = rand.nextInt(0,countOfDoors);
            int playerChoice = rand.nextInt(0,countOfDoors);
            if(win == playerChoice){
                result.put(i, true);
            }else {
                result.put(i, false);
            }
        }
    }

    private void withChange() {
        for (int i = 0; i < countOfIteration; i++) {
            int win = rand.nextInt(0,countOfDoors);
            int playerChoice = rand.nextInt(0,countOfDoors);
            int montyChoice;
            do {
                montyChoice = rand.nextInt(0, countOfDoors);
            } while (montyChoice == win || montyChoice == playerChoice);

            int finalChoice;
            do {
                finalChoice = rand.nextInt(0, countOfDoors);
            } while (finalChoice == playerChoice || finalChoice == montyChoice);

            if (finalChoice == win) {
                result.put(i, true);
            } else {
                result.put(i, false);
            }
        }
    }

    private void printResult() {
        int wins = 0;
        int losses = 0;
        for(int inter : result.keySet()){
            if(result.get(inter)){
                wins++;
            }else{
                losses++;
            }
        }
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }
}

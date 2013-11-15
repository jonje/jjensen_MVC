package model;

import java.io.Serializable;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 11/15/13
 * Time: 8:17 AM
 */
public class Game implements Serializable {
    private int number;
    private int numberGuesses;

    public Game() {


    }

    public int getNumber() {
        return number;
    }

    public int getNumberGuesses() {
        return numberGuesses;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public int guess(int guess) {
        numberGuesses++;
        int returnValue;

        if(guess == number) {
            returnValue = 0;

        } else if(guess < number) {
            returnValue = -1;

        } else {
            returnValue = 1;

        }

        return returnValue;
    }


}

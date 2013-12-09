package model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 12/9/13
 * Time: 7:35 AM
 */
public class DataObject implements Serializable {
    private int number;
    private int numberOfGuesses;

    public DataObject (int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    public void setNumberOfGuesses(int numberOfGuesses) {
        this.numberOfGuesses = numberOfGuesses;
    }
}

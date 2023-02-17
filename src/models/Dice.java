package models;
import java.lang.Math.*;
public class Dice {

int val;

    public int getValDice() {
        int val =  1 + (int)(Math.random() * 5) ;

        return val;
    }
}

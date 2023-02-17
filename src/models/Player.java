package models;

public class Player {
    private   int prevPosition;
    private  int currPosition;
    private String name;

    private char symbol;

    private int playerNumber;

    // private int position;


    public Player(String name, char symbol, int prevPosition, int currPosition,int playerNumber) {
        this.name = name;
        this.symbol = symbol;
        this.prevPosition = prevPosition;
        this.currPosition = currPosition;
        this.playerNumber = playerNumber;
    }

    public int getPrevPosition() {
        return prevPosition;
    }

    public void setPrevPosition(int prevPosition) {
        this.prevPosition = prevPosition;
    }

    public int getCurrPosition() {
        return currPosition;
    }

    public int setCurrPosition(int currPosition) {
        this.currPosition = currPosition;
        return currPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
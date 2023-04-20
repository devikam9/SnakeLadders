package models;

import java.util.Scanner;
import java.util.Stack;

public class Game {
    static int m , n;

//    public Game(int m, int n) {
//        this.m = m;
//        this.n = n;
//    }


    Player player;
    Dice dice;
    Snakes snakes;
    Ladders ladder;
   // static int prevPosition = 0;


    Snakes snake1 = new Snakes(25,5);
    Snakes snake2 = new Snakes(37,1);
    Snakes snake3 = new Snakes(47,9);
    Snakes snake4 = new Snakes(65,59);
    Snakes snake5 = new Snakes(87,54);
    Snakes snake6 = new Snakes(99,2);




    Ladders ladder1 = new Ladders(3,60);
    Ladders ladder2 = new Ladders(6,27);
    Ladders ladder3 = new Ladders(11,70);
    Ladders ladder4 = new Ladders(35,56);
    Ladders ladder5 = new Ladders(68,93);
    Ladders ladder6 = new Ladders(63,96);

    static Stack<Integer> player1Stack = new Stack();
    static Stack<Integer> player2Stack = new Stack();
    static Stack<Integer> player3Stack = new Stack();

    // Conditions for start and end of the game


    public  void move(Player player, int dice, int prevPosition, int playerNo ) throws Exception {

        //check for exception cases (end cases)

        System.out.println("please enter the moves");
        
        



        if(player.getPrevPosition() == m*n){
            throw new Exception(" game has ended for the player" + player.getName());
        }

       System.out.println(" prevposition of player : "+ player.getName() + " is :" + player.getPrevPosition());

       // take the prev position and add it to the dice val to get current position.

        player.setCurrPosition(dice + player.getPrevPosition());
        int checkValue = player.getCurrPosition();

        //check for the winner

         if(checkWinner(player)){
             System.out.println( player.getName() + " YoU WoN ThE GaMe ");
             return;
         }

        //check the curr position encounters a snake & ladders or not.

        player.setCurrPosition(checkForSnakes(player));
        player.setCurrPosition(checkForLadders(player));



        System.out.println(" curr position of "+ player.getName()+" is : " + player.getCurrPosition());

        System.out.println(player.getCurrPosition());
        player.setPrevPosition(player.getCurrPosition());

        System.out.println(" printing prevposition of player : "+ player.getName() + " is :" + player.getPrevPosition());


    // create a stack and push to stack to perform undo operations.

        if( playerNo == 1) {

            player1Stack.push(player.getCurrPosition());
            //top of the stack is
            System.out.println(" top of the stack is: " + player1Stack.peek());
        } else if ( playerNo == 2) {

            player2Stack.push(player.getCurrPosition());
            //top of the stack is
            System.out.println(" top of the stack is: " + player2Stack.peek());
        } else if( playerNo == 3) {

            player3Stack.push(player.getCurrPosition());
            //top of the stack is
            System.out.println(" top of the stack is: " + player3Stack.peek());
        }


    }

    public boolean checkWinner(Player player) throws Exception{

        if(player.getCurrPosition() == m*n){
            System.out.println(" YOU REACHED THE FINAL GOAL ");
            return true;
        } else if(player.getCurrPosition() > m*n){
            throw new Exception(" please try again to reach the final goal");
        } else{
            System.out.println(" yet to reach the goal");
        }
        return false;
    }

   public int checkForLadders(Player player){
//    , Snakes snake1,Snakes snake2,Snakes snake3,Snakes snake4,Snakes snake5
//    ,Snakes snake6){
        int checkValue = player.getCurrPosition();
        int position = 0;

        if(ladder1.startPosition == checkValue){
            System.out.println("CONGRATS you encountered ladder1 ");
            position = ladder1.endPosition;
            return player.setCurrPosition(position);
        } else if(ladder2.startPosition == checkValue){
            System.out.println("CONGRATS you encountered ladder2 ");
            position = ladder2.endPosition;
            return player.setCurrPosition(position);
        } else if(ladder3.startPosition == checkValue){
            System.out.println("CONGRATS you encountered ladder3 ");
            position = ladder3.endPosition;
            return player.setCurrPosition(position);
        } else if(ladder4.startPosition == checkValue){
            System.out.println("CONGRATS you encountered ladder4 ");
            position = ladder4.endPosition;
            return player.setCurrPosition(position);
        } else if(ladder5.startPosition == checkValue){
            System.out.println("CONGRATS you encountered ladder5 ");
            position = ladder5.endPosition;
            return player.setCurrPosition(position);
        }else if(ladder6.startPosition == checkValue){
            System.out.println("CONGRATS you encountered ladder6 ");
            position = ladder6.endPosition;
            return player.setCurrPosition(position);
        }

        return checkValue;
    }

    public int checkForSnakes(Player player){

        int checkValue = player.getCurrPosition();
        int position = 0;

        if(snake1.startPosition == checkValue){
            System.out.println(" OH! encountered snake1 ");
            position = snake1.endPosition;
            return player.setCurrPosition(position);
        } else if(snake2.startPosition == checkValue){
            System.out.println(" OH! encountered snake2 ");
            position = snake2.endPosition;
            return player.setCurrPosition(position);
        } else if(snake3.startPosition == checkValue){
            System.out.println("OH! encountered snake3 ");
            position = snake3.endPosition;
            return player.setCurrPosition(position);
        } else if(snake4.startPosition == checkValue){
            System.out.println("OH! encountered snake4 ");
            position = snake4.endPosition;
            return player.setCurrPosition(position);
        } else if(snake5.startPosition == checkValue){
            System.out.println("OH! encountered snake5 ");
            position = snake5.endPosition;
            return player.setCurrPosition(position);
        } else if(snake6.startPosition == checkValue){
            System.out.println("OH! encountered snake6 ");
            position = snake6.endPosition;
            return player.setCurrPosition(position);
        }

        return checkValue;
    }

    public void undo(Player player, Stack<Integer> stack, int playerPosition) throws Exception{

        if(playerPosition == 1) {

            if (!player1Stack.isEmpty()) {
                int popValue = (int) player1Stack.pop();
                int position = player.getCurrPosition() - popValue;
                player.setCurrPosition(position);
            } else {
                throw new Exception(" player1 doesnot have moves");
            }
        } else if(playerPosition == 2) {

            if (!player2Stack.isEmpty()) {
                int popValue = (int) player2Stack.pop();
                int position = player.getCurrPosition() - popValue;
                player.setCurrPosition(position);
            } else {
                throw new Exception(" player2 doesnt have moves");
            }
        } else if(playerPosition == 3) {

            if (!player3Stack.isEmpty()) {
                int popValue = (int) player3Stack.pop();
                int position = player.getCurrPosition() - popValue;
                player.setCurrPosition(position);
            } else {
                throw new Exception(" player3 doesnt have moves");
            }
        }
    }


    public static void main(String[] args) throws Exception {


        System.out.println(" ----- THE GAME SNAKE AND LADDERS ------");

        System.out.println(" enter the value of m ");
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        System.out.println(" enter the value of n ");
        n = sc.nextInt();
        System.out.println(" initialising the board");
        int[][] board = new int[m][n];
        System.out.println(" the max element on the board is " + board.length * board[0].length);

        System.out.println(" loading the player details");
        System.out.println(" \n");

        Dice dice = new Dice();

        Player player1 = new Player("rohith",'*',0 , dice.val,1);
        Player player2 = new Player("devika",'o',0,dice.val,2);
        Player player3 = new Player("sandhya",'@',0,dice.val,3);


        System.out.println(" the game starts ..3..2..1..0 ");

        System.out.println(" ...making the moves...");

        System.out.println(player1.getPrevPosition());
        System.out.println(player2.getPrevPosition());
        System.out.println(player3.getPrevPosition());


        Game game = new Game();

        //PLAYER1
        System.out.println(dice.getValDice() + " value of dice is");
        game.move(player1, dice.getValDice(), player1.getPrevPosition(),1);
        System.out.println(dice.getValDice() + " value of dice is");
       game.move(player1, dice.getValDice(), player1.getPrevPosition(),1);
        System.out.println( "  " + dice.getValDice() + " value of dice is");
       game.move(player1, dice.getValDice(), player1.getPrevPosition(),1);
       game.move(player1, dice.getValDice(), player1.getPrevPosition(),1);
       game.move(player1, dice.getValDice(), player1.getPrevPosition(),1);
       game.move(player1, dice.getValDice(), player1.getPrevPosition(),1);
       game.move(player1, dice.getValDice(), player1.getPrevPosition(),1);
       game.move(player1, dice.getValDice(), player1.getPrevPosition(),1);


        //PLAYER2
        System.out.println(player2.getPrevPosition());
        game.move(player2,73, player2.getPrevPosition(),2);
        game.move(player2,26, player2.getPrevPosition(),2);


        System.out.println(" position of " + player1.getName() + " is at : " + player1.getCurrPosition());
        System.out.println(" position of " + player2.getName() + " is at : " + player2.getCurrPosition());


        game.undo(player1, player1Stack,1);
    }
}

/*
    Jack Defay
    CPU.java
    5/6/2018
*/

import java.util.Random;

public class CPU {

    private Board computerBoard;  //this might be an issue cuz this isn't currently updated as the computer board takes hits from the player

    private int[] listOfShipLengths;

    //private int difficulty;

    public CPU(Board computerBoard, int[] listOfShipLengths){
        this.computerBoard = computerBoard;
        this.listOfShipLengths = listOfShipLengths;
    }

    public String pickTarget(Board userBoard, int numDestroyedShips){
        int numShipsOnBoard = numShipsOnBoard(userBoard);

        if(numDestroyedShips == userBoard.size() - numShipsOnBoard){  //changed this without thinking is it right?
            return randomSelection();
        }

        else{
            return selectNextToShip(userBoard);
        }
    }

    public int numShipsOnBoard(Board userBoard){  //what syntax are we gonna use for the board? periods and x's? 0's and 1's?
        int numShipsOnBoard = 0;

        //searches board for number of ships

        return numShipsOnBoard;
    }

    private String randomSelection(){
        Random rand = new Random();

        int[] intCoords = {rand.nextInt(this.computerBoard.size()), rand.nextInt(this.computerBoard.size())};

        return convertCoordinates(intCoords); //return a random coordinate in the form {capital letter,number}
    }

    private String convertCoordinates(int[] intCoordinates){
        int firstCoord = intCoordinates[0] + 'A';

        char firstCoordChar = (char) firstCoord;

        String stringCoords = firstCoordChar + Integer.toString(intCoordinates[1]);

        return stringCoords; //reads in two integer coordinates and converts to the form {capital letter, number}
    }

    private String selectNextToShip(Board userBoard){
        return convertCoordinates(new int[] {0,0});  //searches the board for likely incomplete ships, then selects a space in line that is most likely to hit
    }
}

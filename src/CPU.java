/*
    Jack Defay
    CPU.java
    5/6/2018
*/

public class CPU {

    private Board computerBoard;

    private int[] listOfShipLengths;

    //private int difficulty;

    public CPU(Board computerBoard, int[] listOfShipLengths){
        this.computerBoard = computerBoard;
        this.listOfShipLengths = listOfShipLengths;
    }

    public String pickTarget(Board userBoard, int numDestroyedShips){
        int numShipsOnBoard = numShipsOnBoard(userBoard);

        if(numDestroyedShips == numShipsOnBoard){
            return randomSelection();
        }

        else{
            return selectNextToShip(userBoard);
        }
    }

    public int numShipsOnBoard(Board userBoard){
        int numShipsOnBoard = 0;

        //searches board for number of ships

        return numShipsOnBoard;
    }

    private String randomSelection(){
        return convertCoordinates(new int[] {0,0}); //return a random coordinate in the form {capital letter,number}
    }

    private String convertCoordinates(int[] intCoordinates){
        return " "; //reads in two integer coordinates and converts to the form {capital letter, number}
    }

    private String selectNextToShip(Board userBoard){
        return convertCoordinates(new int[] {0,0});  //searches the board for likely incomplete ships, then selects a space in line that is most likely to hit
    }
}

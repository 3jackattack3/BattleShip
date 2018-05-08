/*
    Jack Defay and Yuval Amitay
    Main.java
    5/4/2018
*/

public class Main {
    public static void main(String args[]) {
        Board myBoard = new Board("ships");

        System.out.println(myBoard.getShipName(0));

        int choice = 0;

        //gui prompts user for ship locations and directions
        //modifies the file accordingly
        //cpu randomly places ships

        Board userBoard = new Board("userShips");
        Board computerBoard = new Board("computerShips");

        String location = "";

        while(choice > -1){
            //asks user for target location
            if(computerBoard.checkHit(location)) System.out.println("Hit!");
            else System.out.println("Miss!");
            //displays in gui
            //checks if any ships have been destroyed and updates score
            //checks if anyone has won

            //prompts cpu for target location
            //userBoard.checkHit
            //tells the user if it was a hit or a miss
            //display in gui?
            //checks if any ships have been destroyed and updates scores
            //checks if anyone has won
        }
    }
}

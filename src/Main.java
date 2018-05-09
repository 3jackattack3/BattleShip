/*
    Jack Defay and Yuval Amitay
    Main.java
    5/4/2018
*/

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
//        Board myBoard = new Board("ships");
//
//        System.out.println(myBoard.getShipName(0));
//
        int choice = 0;

        //gui prompts user for ship locations and directions
        //modifies the file accordingly
        //cpu randomly places ships

        int[] currentNumDestroyed = new int[2];

        currentNumDestroyed[0] = 0;  //userBoard
        currentNumDestroyed[1] = 0;  //computerBoard

        Board userBoard = new Board("userShips.txt", 6);
        Board computerBoard = new Board("computerShips.txt", 6);

        Scanner in = new Scanner(System.in);

        CPU cpu = new CPU(computerBoard);

        String location = "";

        while(true){
            System.out.print("Where would you like to attack? ");
            location = in.next();
            if(computerBoard.checkHit(location)) System.out.println("Hit!");
            else System.out.println("Miss!");
            //displays in gui
            if(computerBoard.numDestroyed() > currentNumDestroyed[1]){
                System.out.println("You destroyed a ship!");
                currentNumDestroyed[1] = computerBoard.numDestroyed();
            }
            if(computerBoard.size() == computerBoard.numDestroyed()){
                System.out.println("You won!");
                break;
            }

            location = cpu.pickTarget(userBoard, currentNumDestroyed[0]);
            System.out.println("The cpu attacked at location: " + location);
            if(userBoard.checkHit(location)) System.out.println("It hit!");
            else System.out.println("It missed!");
            //display in gui?
            if(computerBoard.numDestroyed() > currentNumDestroyed[1]){
                System.out.println("Your ship was destroyed!");
                currentNumDestroyed[0] = computerBoard.numDestroyed();
            }
            if(userBoard.size() == userBoard.numDestroyed()){
                System.out.println("You lost :(");
                break;
            }
        }
    }
}

/*
    Jack Defay
    Board.java
    5/3/2018
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {

    private ArrayList<Ship> ships;

    private String fileName;

    public Board(String filename){
        Scanner in = null;
        String[] temp;

        //this.fileName = filename;

        this.ships = new ArrayList<Ship>(1);

        try{
            in = new Scanner(new File(filename));
        }
        catch (FileNotFoundException e){
            System.out.println("Could not read file!");
        }

        while(in.hasNextLine()){
            temp = in.nextLine().split("/", -2);
            ships.add(new Ship(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3]));
        }
    }

    public String getShipName(int index){
        return ships.get(index).getName();
    }
}

/*
    Jack Defay and Yuval Amitay
    Board.java
    5/4/2018
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

        this.fileName = filename;

        this.ships = new ArrayList<Ship>(1);

        try{
            in = new Scanner(new File(this.fileName));
        }
        catch (FileNotFoundException e){
            System.out.println("Could not read file!");
        }

        while(in.hasNextLine()){
            temp = in.nextLine().split("/", -2);
            this.ships.add(new Ship(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3]));
        }
    }

    public String getShipName(int index){
        return ships.get(index).getName();
    }

    public int size(){
        return this.ships.size();
    }

    public boolean checkHit(String location){
        for(Ship ship : ships){
            if(ship.checkHit(location)) return true;
        }

        return false;
    }

    public int numDestroyed(){

        int numDestroyed = 0;

        for(Ship ship : ships){
            if(ship.destroyed()) numDestroyed++;
        }

        return numDestroyed;
    }
}

/*
    Jack Defay and Yuval Amitay
    Ship.java
    5/4/2018
*/

public class Ship {
        private int length;  //stores the length of the ship, used together with the location and direction to place the ship
        private String name;  //stores the ship name, this might be used later when displaying which ship was desroyed
        private int[] location;  //stores the ship's location as coordinate {x,y}. We store the coordinates of the ship rather than storing them in a 2d matrix point by point
        private int[] lives;  //which locations on the ship have been hit
        private int totalLives;  //a sumtotal of the lives left. This should be refreshed everytime the lives array is messed with
        private int[] direction;  //this is the other critical piece of information that allows the gui to place the ships. The "location" is the starting place, and the direction says which way to build the ship of length "length"
                                    //this is stored as {i,j} where i and j are the x and y unit vectors. for example, {1,0} would be right, and {0,-1} would be down

        public Ship(int length, String name, String coordinates, String directionString){  //constructor, needs all this basic info to generate the ship
            this.length = length;  //sets the basic information
            this.name = name;
            this.location = new int[2];

            this.location[0] = (int) (coordinates.charAt(0) - 'A');  //takes the coordinates in battleship fashion as {letter, number}, so must convert that to an int[]
            this.location[1] = (int) (coordinates.charAt(1));
            this.lives = new int[length];

            for(int i = 0; i < this.length; i++){  //at first the ship has all of its lives
                this.lives[i] = 1;
            }

            this.totalLives = length;  //and the total is equal to the length of the ship

            this.direction = new int[2];

            this.direction[0] = Integer.parseInt(directionString.substring(0,1));  //this will be read in as a string as well, in the form "numbernumber" (for example 01) and must be converted to an int[]
            this.direction[1] = Integer.parseInt(directionString.substring(1));

        }

        public boolean checkHit(String coordinates){  //checks if the target location would hit the ship
            int[] coords = convertCoords(coordinates);

            for(int i = 0; i < this.length; i++) {  //loops through the length, adding the direction vector to the base coordinates to obtain the coordinates of each space on the ship
                if (this.location[0] + i * direction[0] == coords[0] && this.location[1] + i * direction[1] == coords[1]) {  //checks if these specific coordinates are the same as the supplied target coordinates
                    this.lives[i] = 0;  //if it is, then adjusts lives
                    this.totalLives--;
                    return true;
                }
            }

            return false;  //if the target location isn't any of the coordinates of the ship, then return false
        }

        private int[] convertCoords(String coordinates){  //just a method to convert coordinates from string to int[]
                int[] coords = new int[2];

                coords[0] = (int) (coordinates.charAt(0) - 'A');
                coords[1] = (int) (coordinates.charAt(1));

                return coords;
        }

        public String getName(){
            return this.name;
        }

        public boolean destroyed(){  //checks if this ship has been destroyed by looping through its lives array to check if it is all zeros
            int livesLeft = this.length;
            for(int i = 0; i < this.length; i++){
                if(this.lives[i] == 0) livesLeft--;
            }
            if(livesLeft == 0) return true;
            else return false;
        }
}

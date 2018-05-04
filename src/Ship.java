/*
    Jack Defay
    Ship.java
    5/2/2018
*/

public class Ship {
        private int length;
        private String name;
        private int[] location;
        private int[] lives;
        private int totalLives;
        private int[] direction;

        public Ship(int length, String name, String coordinates, String directionString){
            this.length = length;
            this.name = name;
            this.location = new int[2];

            this.location[0] = (int) (coordinates.charAt(0) - 'A');
            this.location[1] = (int) (coordinates.charAt(1));
            this.lives = new int[length];

            for(int i = 0; i < this.length; i++){
                this.lives[i] = 1;
            }

            this.totalLives = length;

            this.direction = new int[2];

            this.direction[0] = Integer.parseInt(directionString.substring(0,1));
            this.direction[1] = Integer.parseInt(directionString.substring(1));

        }

        public int checkHit(String coordinates){
            int[] coords = convertCoords(coordinates);

            for(int i = 0; i < this.length; i++)
                if(this.location[0] + i * direction[0] == coords[0] && this.location[1] + i * direction[1] == coords[1]) {
                    this.lives[i] = 0;
                    this.totalLives--;
                    return 1;
                }

            return 0;
        }

        private int[] convertCoords(String coordinates){
                int[] coords = new int[2];

                coords[0] = (int) (coordinates.charAt(0) - 'A');
                coords[1] = (int) (coordinates.charAt(1));

                return coords;
        }

        public String getName(){
            return this.name;
        }
}

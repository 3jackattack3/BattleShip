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

        public Ship(int length, String name, String coordinates, int[] direction){
            this.length = length;
            this.name = name;
            this.location = new int[2];

            int x = (int) (coordinates.charAt(0) - 'A');
            int y = (int) (coordinates.charAt(1));
            this.location[0] = x;
            this.location[1] = y;
            this.lives = new int[length];

            for(int i = 0; i < this.length; i++){
                this.lives[i] = 1;
            }

            this.totalLives = length;

            for(int j = 0; j < 2; j++){ {
                this.direction[j] = direction[j];
            }
        }

        public static int checkHit(int x, int y){

        }
}

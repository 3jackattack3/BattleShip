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

            for(int j = 0; j < 2; j++){
                this.direction[j] = direction[j];
            }
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
}

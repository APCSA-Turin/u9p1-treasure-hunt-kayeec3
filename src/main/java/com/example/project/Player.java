package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite {
    private int treasureCount;
    private int numLives;
    private boolean win;

    public Player(int x, int y) {
        super(x, y);
        treasureCount = 0;
        numLives = 2;
    }
    @Override
    public String getCoords(){
        return "Player:" + super.getCoords(); //coordinates of player 
    }
    @Override
    public String getRowCol(int size){
        return "Player:" + super.getRowCol(size); //row and col of player
    }

    public int getTreasureCount(){return treasureCount;}
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}

  
    //move method should override parent class, sprite
    public void move(String direction) { //moves the (x,y)
        if (direction.equals("w") && isValid(10, "w")) { // checks if the player can move foward
            setY(getY() + 1);
        }
         else if (direction.equals("d") && isValid(10, "d")) {// checks if the player can move right
            setX(getX() + 1);
        } 
        else if (direction.equals("s") && isValid(10, "s")) {// checks if the player can move backwards
            setY(getY() - 1);
        } 
        else if (direction.equals("a") && isValid(10, "a")) {// checks if the player can left
            setX(getX() - 1);
        }
    }


    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
    //numTreasures is the total treasures at the beginning of the game
        if (isValid(size, direction)){ //checks if the player is able to move
            if (obj instanceof Treasure && !(obj instanceof Trophy)){ //checks if the object is a treasure and not a trophy 
                treasureCount++; //increases treasure
            }
    
            if (obj instanceof Trophy && numTreasures == treasureCount){ //checks if the object is a trophy and the amount of treasures the player has 
                win = true;  //sets win to be true 
            }

            if (obj instanceof Enemy){ //if the object is an enemy 
                numLives--; //decrements the amount of lives by 1 
            }
        }
    }


    public boolean isValid(int size, String direction){ //checks if the movement is valid
        if (direction.equals("w")) {
            return getY() < size - 1; // moves up
        } 
        else if (direction.equals("s")) {
            return getY() > 0; //down
        }
         else if (direction.equals("a")) {
            return getX() > 0; //left
        } 
        else if (direction.equals("d")) {
            return getX() < size - 1; //right
        }
        return false;//if not w,a,s,d
    }


   
}




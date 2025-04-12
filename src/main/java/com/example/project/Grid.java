package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        this.size = size;
        grid = new Sprite[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Dot(i, j); // dot in every cell
            }
        }
    }

 
    public Sprite[][] getGrid(){return grid;}



    public void placeSprite(Sprite s){ //puts the sprite in a new spot
        grid[size - 1 - s.getY()][s.getX()] = s;
    }

    public void placeSprite(Sprite s, String direction) { //puts the sprite in a new spot based on the direction
        grid[size - 1 - s.getY()][s.getX()] = s;
        Dot empty = new Dot(0,0); //new dot 
        empty.setY(direction.equals("w") ? s.getY() - 1 : direction.equals("s") ? s.getY() + 1 : s.getY()); //if the direction is "w" the y position gets increased by 1, and if the direction equals "s", the y postition gets decreased by 1
        empty.setX(direction.equals("a") ? s.getX() + 1 : direction.equals("d") ? s.getX() - 1 : s.getX()); //if the direction equals "a", the x position gets decreased by 1, and if the direction is "d", the x position gets increased by 1
        placeSprite(empty); //sprite in new sport
    }


    public void display() {//current grid to the screen 
        for(Sprite[] row :grid){ //goes through the row in the grid 
            for(Sprite sprite : row){ //goes through the sprite in the row 
                if(sprite instanceof Dot){ //if the sprite is a dot object 
                    System.out.print("🐍"); //prints out dot 
                } else if(sprite instanceof Player){ //if the spite is a player object 
                    System.out.print("👍"); //prints a thumbs up 
                } else if(sprite instanceof Enemy){ //if the sprite is an enemy 
                    System.out.print("🪳"); //prints out enemy 
                } else if (sprite instanceof Treasure && !(sprite instanceof Trophy)){ //if the sprite is a treasure but not a trophy 
                    System.out.print("🪙"); //prints a coin 
                } else{ //the sprite is a trophy 
                    System.out.print("🏆"); //print a trophy 
                }
            }
            System.out.println(); //next line 
        }
    }
    
    public void gameover(){//use this method to display a loss
    }

    public void win(){//use this method to display a win 
    }


}
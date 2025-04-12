package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    public Game(int size){ //the constructor should call initialize() and play()
        this.size = size;
        initialize();
        play();
    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Grid getGrid(){ 
        return grid; 
    }

    public void play(){ //write your game logic here
        boolean isPlaying = true;
        Game a = new Game(10); //create a new game
        Object interact = new Dot(0, 0); 
        int y = player.getY();
            System.out.println("Coordinates: " + player.getCoords());
            System.out.println("Treasure Count: " + player.getTreasureCount());
            System.out.println("Player Lives: " + player.getLives());
            System.out.print("Enter a direction (w ,a ,s ,d ) or q to quit: ");
    }

    public void initialize(){

        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
        player = new Player(2, 3);  //create new player
        grid = new Grid(size);   //create new grid 
        trophy = new Trophy(size- 1, size -1);  //create new trophy
        grid.placeSprite(player); //place the player on the grid 
        grid.placeSprite(trophy); //place the trophy on the grid 
    }

    public static void main(String[] args) {
        Game a = new Game(10); //create a new game 
        a.getGrid().display();
        
    }
}
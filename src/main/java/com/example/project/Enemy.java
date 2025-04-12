package com.example.project;

//Enemy only need constructor and getCoords() getRowCol()
public class Enemy extends Sprite{ //from sprite
    
    public Enemy(int x, int y) {
        super(x, y);
    }


    //the methods below should override the super class 

    @Override
    public String getCoords(){ //"Enemy:" + coordinates
        return "Enemy:" + super.getCoords(); // from sprite class
    }

    @Override
    public String getRowCol(int size){ //"Enemy:" + row col
    return "Enemy:" + super.getRowCol(size);
    }
}
package com.example.hirokishinoda.mazusearchgame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Stage extends Task{
    MazeMap map;
    ArrayList<Character> characters;

    public Stage(Player player,int enemy_num){
        map = new MazeMap(41,41);

        initCharacters(player,enemy_num);
    }

    private void initCharacters(Player player,int enemy_num){
        characters = new ArrayList<>();

        setCharacterPosition(player);
        characters.add(player);
        for(int i = 0;i < enemy_num;i++){
            //characters.add(new Enemy());
        }
    }

    private void setCharacterPosition(Player player){
        if(map.maze_map[1][1].getType() == Block.blockType.START){
            player.setCharacterPoint(1,1);
        }else if(map.maze_map[1][map.map_y - 2].getType() == Block.blockType.START){
            player.setCharacterPoint(map.map_x -2,1);
        }else if(map.maze_map[1][1].getType() == Block.blockType.GOAL){
            player.setCharacterPoint(map.map_y - 2 ,map.map_x - 2);
        }else if(map.maze_map[1][map.map_x - 2].getType() == Block.blockType.GOAL){
            player.setCharacterPoint(1,map.map_y - 2);
        }
    }

    private void collision() {
    }

    private void drawCharacters(Canvas c){
        for(int i = 0;i < characters.size();i++){
            characters.get(i).onDraw(c);
        }
    }

    @Override
    public boolean onUpdate() {
        map.onUpdate();
        return true;
    }

    @Override
    public void onDraw(Canvas c) {
        map.onDraw(c);
        drawCharacters(c);
    }

    public void move(int x,int y){
        Player player = (Player)characters.get(0);

        if(isArea(player.character_x+x,player.character_y+y)){
            if(!isBlock(player.character_x+x,player.character_y+y)){
                player.move(x,y);
            }
        }
    }

    private boolean isArea(int x,int y){
        if(x > 0 && x < map.map_x){
            if(y > 0 && y < map.map_y){
                return true;
            }
        }
        return false;
    }

    private boolean isBlock(int x,int y){
        if(map.maze_map[y][x].getType() == Block.blockType.WALL){
            return true;
        }
        return false;
    }
}

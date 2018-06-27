package com.example.hirokishinoda.mazusearchgame;

import android.graphics.Canvas;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MazeMap extends Task{
    Block [][]maze_map;
    int map_x,map_y;

    public  MazeMap(int map_x,int map_y){
        this.map_x = map_x;
        this.map_y = map_y;
        maze_map = new Block[map_y][map_x];

        initMazeMap();
    }

    private void initMazeMap(){
        Random rnd = new Random();

        for(int i = 0;i < map_y;i++){
            for(int j = 0;j < map_x;j++){
                maze_map[i][j] = new Block();
                if(i == 0 || i == map_y-1 || j == 0 || j == map_x-1) {
                    maze_map[i][j].setType(Block.blockType.WALL);
                }else if(i % 2 == 0 && j % 2 == 0){
                    maze_map[i][j].setType(Block.blockType.WALL);
                }
            }
        }

       for(int i = 1;i < map_y-1;i++){
            for(int j = 1;j < map_x-1;j++){
                    if(i == 2 && j % 2 == 0 ){
                        switch(rnd.nextInt(4)){
                            case 0:
                                maze_map[i-1][j].setType(Block.blockType.WALL);
                                break;
                            case 1:
                                maze_map[i+1][j].setType(Block.blockType.WALL);
                                break;
                            case 2:
                                maze_map[i][j-1].setType(Block.blockType.WALL);
                                break;
                            case 3:
                                maze_map[i][j+1].setType(Block.blockType.WALL);
                                break;
                        }
                    }else if(i % 2 == 0 && j % 2 == 0){
                        boolean flag = true;
                        while(flag) {
                            switch (rnd.nextInt(3)) {
                                case 0:
                                    if (maze_map[i][j + 1].getType() != Block.blockType.WALL) {
                                        maze_map[i][j + 1].setType(Block.blockType.WALL);
                                        flag = false;
                                    }
                                    break;
                                case 1:
                                    if (maze_map[i + 1][j].getType() != Block.blockType.WALL) {
                                        maze_map[i + 1][j].setType(Block.blockType.WALL);
                                        flag = false;
                                    }
                                    break;
                                case 2:
                                    if (maze_map[i][j - 1].getType() != Block.blockType.WALL) {
                                        maze_map[i][j - 1].setType(Block.blockType.WALL);
                                        flag = false;
                                    }
                                    break;
                            }
                        }
                }
            }
        }
        setPosition();
    }

    /*
    * スタートとゴールの位置を決めるメソッド
    * */
    private void setPosition(){
        final int LISTMAX = 4;
        ArrayList<Integer> list = new ArrayList<>();

        // 位置を決める乱数を作るために
        // リストを作成し、シャフルする
        for(int i = 0;i < LISTMAX;i++){
            list.add(i);
        }
        Collections.shuffle(list);

        // 乱数に応じたスタート、ゴールの位置を決定
        switch(list.get(0)){
            case 0:
                maze_map[1][1].setType(Block.blockType.START);
                maze_map[map_y-2][map_x-2].setType(Block.blockType.GOAL);
                break;
            case 1:
                maze_map[1][map_x-2].setType(Block.blockType.START);
                maze_map[map_y-2][1].setType(Block.blockType.GOAL);
                break;
            case 2:
                maze_map[1][1].setType(Block.blockType.GOAL);
                maze_map[map_y-2][map_x-2].setType(Block.blockType.START);
                break;
            case 3:
                maze_map[1][map_x-2].setType(Block.blockType.GOAL);
                maze_map[map_y-2][1].setType(Block.blockType.START);
                break;
        }
    }

    @Override
    public boolean onUpdate() {
        return super.onUpdate();
    }

    @Override
    public void onDraw(Canvas c) {
        super.onDraw(c);
        for(int y = 0;y < map_y;y++){
            for (int x = 0;x < map_x;x++){
                maze_map[y][x].onDraw(c,x ,y);
            }
        }
    }
}

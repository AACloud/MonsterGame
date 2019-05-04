package com.AhmedAbdulla;

import java.io.IOException;

public class Room {
    private int roomIndex;
    private String description;
    private Monster monster;

    public Room(int roomIndex, String description, Monster monster) {
        this.roomIndex = roomIndex;
        this.description = description;
        this.monster = monster;
    }

//    public Room(String description, Monster monster){




    public int getRoomIndex() {
        return roomIndex;
    }

    public String getDescription() {
        return description;
    }

    public Monster getMonster() {
        return monster;
    }

    public boolean isComplete(){ //This method returns true if the Monster in this Room has died.
        if(monster.isAlive()){
            return false;
        }
        else return true;
    }

    public void enter(Player player){ //"player name" "This Room is this.description, and has this.monster"
        if(monster.isAlive()){
            System.out.println(player.getName() + " This room is " + this.description + " and has a " + this.monster.getName());

        Battle battle = new Battle(player ,getMonster());
        try {
            battle.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }


    public String toString(){
        return String.format("Room index %2d, description %20s, monster name %20s",getRoomIndex(),getDescription(),getMonster());
    }


}


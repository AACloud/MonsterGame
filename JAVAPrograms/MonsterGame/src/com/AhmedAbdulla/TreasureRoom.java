package com.AhmedAbdulla;

import java.io.IOException;

public class TreasureRoom extends Room {
    private String treasure;

    public TreasureRoom(int roomIndex, String description, Monster monster, String treasure) {
        super(roomIndex ,description, monster);
        this.treasure = treasure;
    }


    public void enter(Player player){
        //System.out.println(getMonster());
        super.enter(player);
        if(getMonster().isAlive() && player.isAlive()){
            System.out.println(player.getName() + " This room is " + getDescription() +" and has " + getMonster());
            Battle battle = new Battle(player ,getMonster());
        try {
            battle.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

        } if(player.isAlive() && !getMonster().isAlive()) {
            System.out.println("You explored the room and found the hidden" + this.treasure + "!");
        }

    }

}


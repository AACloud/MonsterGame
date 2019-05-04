package com.AhmedAbdulla;
public class Creature  {
    private String name;
    private String description;
    private int hitPoints;
    private int damage;
    private Room room;

    public Creature() {
        this.name = "";
        this.description = "";
        this.hitPoints = 0;
        this.damage = 0;
        this.room = null;
    }

    public Creature(String name, String description, int hitPoints, int damage) {
        this.name = name;
        this.description = description;
        this.hitPoints = hitPoints;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getDamage() {
        return damage;
    }

    public Object getRoom() {
        return room;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    public void attack(Creature creature){
       if(this.hitPoints > 0){
           System.out.print(this.name + " attacks " + creature.name + ", dealing " + this.damage  + " damage \n");
       }
       else System.out.println("");
    }
    public boolean isAlive(){ //This method return true if this Creature has positive hitPoints.
        if(this.hitPoints > 0){
            return true;
        }
        else return false;
    }

    public void takeDamage(int damage){ //This method subtracts the specified amount of damage from hitPoints.
        //Please note that hitPoints cannot go below zero.
//        this.hitPoints = this.hitPoints - damage;
//        System.out.println("Testing wahmeds damage: " + damage);
        setHitPoints(getHitPoints() - damage);

        if(this.hitPoints <= 0){
            System.out.println("FINISH HIM");
        }

    }
    public String toString(){
        return String.format("name %15s, description %20s, hitPoints %03d, damage %02d \n", getName(), getDescription(),getHitPoints(),getDamage());
    }
}

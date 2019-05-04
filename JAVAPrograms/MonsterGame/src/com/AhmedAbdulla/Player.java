package com.AhmedAbdulla;

public class Player extends Creature {
    private int healAmount;

    public Player(String name, String description, int hitPoints, int damage, int healAmount) {
        super(name, description, hitPoints, damage);
        this.healAmount = healAmount;
    }

    public void heal(){ //This method will increase the hitPoints for this Player by this.healAmount.
        //"this.name is healed by this.healAmount"
        setHitPoints(getHitPoints() + healAmount);
        System.out.println(getName() + " is healed by " + this.healAmount + " amount");
    }

}


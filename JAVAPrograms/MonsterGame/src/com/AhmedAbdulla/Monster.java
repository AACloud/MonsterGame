package com.AhmedAbdulla;

public class Monster extends Creature {
    private boolean isEnraged;
    private int enrageThreshold;

    public Monster(String name, String description, int hitPoints, int damage, int enrageThreshold) {
        super(name, description, hitPoints, damage);
        this.enrageThreshold = enrageThreshold;
    }

    public void enrage() {
        if(this.isAlive() && !this.isEnraged ) {
            isEnraged=true;//set to true so it will not get re-enraged
            System.out.println(this.getName() + " has been enraged");
            int doubleDamage = (this.getDamage()*2);
            this.setDamage(doubleDamage);

        }

    }

    public boolean canEnrage() {
        //System.out.println("Enrage Threshold is: " + this.enrageThreshold + " !isEnraged is: " + !this.isEnraged + " getDamage" + getDamage());
        return this.getHitPoints() <= this.enrageThreshold && !this.isEnraged;
    }
}

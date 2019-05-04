package com.AhmedAbdulla;

import java.io.*;

import java.util.Scanner;

public class Battle {
    private Player player;
    private Monster monster;

    public Battle(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }
    public void run() throws IOException{

//        System.out.println("Battle Begins: " + player.getName() + " Versus " + monster.getName());

        while(player.isAlive() && monster.isAlive()) {
            char playerTurn;
            System.out.println("Battle Begins: " + player.getName() + " Versus " + monster.getName());

            Scanner scnr = new Scanner(System.in);

//            System.out.println("Battle Begins: " + player.getName() + " Versus " + monster.getName());
            System.out.println("Player turn: " + "\n" + player.getName() +  "'s HP: " + player.getHitPoints()
                    + "\n" + monster.getName() + "'s HP: " + monster.getHitPoints());
            System.out.println("                 ");
            System.out.println("Do you want to attack or heal?" + "\nPress [a] to attack \nor Press [h] to heal");
            playerTurn = scnr.next().charAt(0);
            if(monster.canEnrage() && monster.isAlive()){
                System.out.println("\nThe Monster has some mysterious Aura surrounding it. " +
                        "Its power feels twice as strong");
                monster.enrage();



            }

            if((playerTurn =='a') || (playerTurn == 'A')) {
                monster.takeDamage(player.getDamage());
                player.attack(monster);
                if(monster.isAlive()) {
                    player.takeDamage(monster.getDamage());
                    monster.attack(player);
                }
//                if(monster.canEnrage() && monster.isAlive()){
//                    System.out.println("\nThe Monster has some mysterious Aura surrounding it. " +
//                        "Its power feels twice as strong");
//                    monster.enrage();
//
//
//
//                }

                if (player.isAlive() && !monster.isAlive()) {
                    System.out.println(monster.getName() + " has been defeated");
                    System.out.println("YOU WIN!!");
                    System.out.println("FATALITY!!!!");
                    BufferedWriter mario = new BufferedWriter(new FileWriter("GameLog.txt", true));
                    mario.append("\n" + monster.getName() +" has been Defeated");
                    mario.close();
                    System.out.println();
                }


//            System.out.println(monster.getName() + " Attacks");
//            player.takeDamage(monster.getDamage());
//            monster.attack(player);
            if(!player.isAlive()){
                System.out.println(player.getName() + " Has been Killed. How pathetic");
                System.out.println("Game Over");
                }
            }
            else if((playerTurn =='h') || (playerTurn == 'H')) {
                player.heal();
                System.out.println(monster.getName() + " Attacks");
                System.out.println("\n");
                player.takeDamage(monster.getDamage());
                monster.attack(player);
                if (!player.isAlive()) {
                    System.out.println(player.getName() + " Has been Killed. How pathetic");
                }
            }

            else {
                System.out.println("\n");
                System.out.println("Wrong Button, Press A to Attack or H to heal");
            }




        }

    }
}


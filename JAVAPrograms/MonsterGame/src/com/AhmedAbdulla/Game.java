package com.AhmedAbdulla;

import java.io.*;

public class Game {
    public Player player;
    public Monster orc;
    public Monster skeleton;
    public Monster fireDragon;
    public Room [] dungeon;
    private Room room1;
    private Room room2;
    private Room room3;
    private TreasureRoom treasureRoom;


    public Game() throws IOException {
        BufferedReader br;
        File playerInfo = new File("PlayerInfo.txt");
        br = new BufferedReader(new FileReader("PlayerInfo.txt"));
        playerInfo.canRead();

        String name = br.readLine();
        String description = br.readLine();
        int hitPoints = Integer.parseInt(br.readLine());
        int damage = Integer.parseInt(br.readLine());
        int healAmount =Integer.parseInt(br.readLine());

        player = new Player("Luigi", "A powerful Warrior", 100, 15, 30);

        orc = new Monster("Orc", "covered with green blood", 20, 5, 0);

        room1 = new Room(0, "a room with an unbearable smell" , orc);

        skeleton = new Monster("Skeleton","funny how it moves", 40, 10, 10 );

        room2 = new Room(1, "dark and cold", skeleton);

        fireDragon = new Monster("FireDragon","spouts fire with each breath", 100, 20, 40);
        //null
        System.out.println("\n");
        treasureRoom = new TreasureRoom(2,"A giant hall with something shiny on the other end ",fireDragon, " A large pile of Gold");


        dungeon = new Room[] { room1, room2, treasureRoom };

        //File dungeonDetails = new File("DungeonDetails.txt");
          //File dungeonDetails = new File("DungeonDetails.txt");
          BufferedReader br2 = new BufferedReader(new FileReader("DungeonDetails.txt"));
          //dungeonDetails.canRead();

          String orcName = br2.readLine();
          String orcDescription = br2.readLine();
          int orcHP = Integer.parseInt(br2.readLine());
          int orcAttack = Integer.parseInt(br2.readLine());
          int orcEnrageThreshold = Integer.parseInt(br2.readLine());
          int orcRoomIndex = Integer.parseInt(br2.readLine());
          boolean orcIsEnraged = Boolean.parseBoolean(br2.readLine());
          String orcRoomDescription = br2.readLine();


          String skeletonName = br2.readLine();
          String skeletonDescription = br2.readLine();
          int skeletonHP = Integer.parseInt(br2.readLine());
          int skeletonAttack = Integer.parseInt(br2.readLine());
          int skeletonEnrageThreshold = Integer.parseInt(br2.readLine());
          int skeletonRoomIndex = Integer.parseInt(br2.readLine());
          boolean skeletonIsEnraged = Boolean.parseBoolean(br2.readLine());
          String skeletonRoomDescription = br2.readLine();



          String fireDragonName = br2.readLine();
          String fireDragonDescription = br2.readLine();
          int fireDragonHP = Integer.parseInt(br2.readLine());
          int fireDragonAttack = Integer.parseInt(br2.readLine());
          int fireDragonEnrageThreshold = Integer.parseInt(br2.readLine());
          int fireDragonRoomIndex = Integer.parseInt(br2.readLine());
          boolean fireDragonIsEnraged = Boolean.parseBoolean(br2.readLine());
          String dragonRoomDescription = br2.readLine();








//        try { br = new BufferedReader(new FileReader("PlayerInfo.txt"));
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                br.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }


    }

    void play()throws IOException{
        File logFile = new File("GameLog.txt");
        if(logFile.createNewFile()) {
            System.out.println("File is Created");
        } else{
            System.out.println("File Already Exists");

        }
        FileWriter writer = new FileWriter(logFile);
        writer.write(player.getName());
//        writer.write();
        writer.close();


        try {
            File a = new File("DungeonDetails.txt");
        //(PrintStream a = new (new File("DungeonDetails.txt"))) {
        //(PrintStream log = new PrintStream(new File("DungeonDetails.txt")))
            //while(player.isAlive()) {
            for(int i = 0 ; i<1; i++){

                if (orc.isAlive()) {
                    room1.enter(player);
                }
                if (skeleton.isAlive()) {
                    room2.enter(player);
                }
                if (fireDragon.isAlive()) {
                    treasureRoom.enter(player);
                }
//                if (!(orc.isAlive() && skeleton.isAlive() && fireDragon.isAlive()) || !player.isAlive()) {
//                    this.running = false;

//                if(!(orc.isAlive() && skeleton.isAlive() && fireDragon.isAlive()) || !player.isAlive()){
//                    player.isAlive();
//                }

            }
            BufferedWriter mario = new BufferedWriter(new FileWriter("GameLog.txt", true));
            mario.append("\n" + "THE END");
            mario.close();

            System.out.println("THE END");

        }catch (Error e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    }

}
}
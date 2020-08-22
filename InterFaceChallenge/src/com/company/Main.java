package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player jamie = new Player("Jamie",20,80);
        System.out.println(jamie);
        saveObject(jamie);

        jamie.setHitPoints(50);
        System.out.println(jamie);
        jamie.setWeapon("Shotgun");
        saveObject(jamie);
//        loadObject(jamie);
        System.out.println(jamie);

        Monster wereWolf = new Monster("WereWolf",20,80);


        System.out.println(wereWolf);

        saveObject(wereWolf);
        loadObject(wereWolf);
        System.out.println(wereWolf);

    }

    public static ArrayList<String> readValues(){
        ArrayList<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println( "Choose\n"+
                            "1 - to enter a string\n"+
                            "0 - to quit");
        while (!quit){
            System.out.println("Choose option");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0  :   quit = true;break;

                case 1  :
                    System.out.println("Enter a string");
                    String stringInput = scanner.nextLine();
                    values.add(index,stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISavable objectToSave){
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device." );
        }
    }

    public static void loadObject(ISavable loadObject){
        ArrayList<String> values = readValues();
        loadObject.read(values);
    }
}

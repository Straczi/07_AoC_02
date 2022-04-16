package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<String> inputList = getInputData("inputData.txt");
        ArrayList<bag> bagArrayList = new ArrayList<>();
        int shinyGoldIndex =0;
        for (int i = 0; i < inputList.size(); i++) {
            String tempString = inputList.get(i);
            String tempBagName = tempString.split(" ")[0] +  tempString.split(" ")[1];
            if(tempBagName.equals("shinygold")){
                shinyGoldIndex = i;
            }
            bagArrayList.add(new bag( tempBagName ));
            for (int j = 4; j < (tempString.split(" ").length-3)  ; j+=4) {
                String tempContainingBagName = tempString.split(" ")[j]+ " " + tempString.split(" ")[j+1] + tempString.split(" ")[j+2];
                bagArrayList.get(i).addContainedBag(tempContainingBagName);
            }
        }
        //jetzt haben wir ne List mit Bag-Elementen, und mit wlechen Bags die gefüllt sind

        ArrayList<String> bagsContainedInShinyGoldList = new ArrayList<>(bagArrayList.get(shinyGoldIndex).getContainedBagsList());

        for (int i = 0; i < bagsContainedInShinyGoldList.size(); i++) {
            String tempBagName = bagsContainedInShinyGoldList.get(i).substring(2);
            int tempBagCount = Integer.parseInt(bagsContainedInShinyGoldList.get(i).substring(0,1));
            for (com.company.bag bag : bagArrayList) {
                if (tempBagName.equals(bag.getColor())) {
                    for (int j = 0; j < tempBagCount ; j++) {
                        bagsContainedInShinyGoldList.addAll(bag.getContainedBagsList());
                    }
                }
            }
        }

        int bagCount =0;

        for (String s : bagsContainedInShinyGoldList) {
            System.out.println(s);
            bagCount += Integer.parseInt(s.substring(0, 1));
        }
        System.out.println(bagCount);

    }


    //standard method for file Input
    public static ArrayList<String> getInputData (String filename) throws Exception{
        File inputData = new File(filename);
        Scanner scanner = new Scanner(inputData);
        ArrayList<String> dataList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            dataList.add(scanner.nextLine());
        }
        return dataList;
    }
}

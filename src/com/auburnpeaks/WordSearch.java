package com.auburnpeaks;

import java.io.*;

public class WordSearch {
    private String[] wordsToFind = new String[]{};

    public void readTestPuzzle(String pathToTestPuzzle){

        try{
            BufferedReader in = new BufferedReader(new FileReader(pathToTestPuzzle));
            wordsToFind = in.readLine().split(",");
        }
        catch(Exception e){
            System.out.println("Error Reading File:" + pathToTestPuzzle);
        }
    }

    public String[] getWordsToFind(){
        return wordsToFind;
    }

}

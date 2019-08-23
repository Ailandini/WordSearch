package com.auburnpeaks;

import java.io.*;

public class WordSearch {

    public String[] readTestPuzzle(String pathToTestPuzzle){
        String[] wordsToFind = new String[]{};

        try{
            BufferedReader in = new BufferedReader(new FileReader(pathToTestPuzzle));
            wordsToFind = in.readLine().split(",");
            return wordsToFind;
        }
        catch(Exception e){
            return wordsToFind;
        }
    }

}

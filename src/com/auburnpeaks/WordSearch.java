package com.auburnpeaks;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;

public class WordSearch {
    private String[] wordsToFind = new String[]{};
    private ArrayList<ArrayList<String>> wordSearchPuzzle = new ArrayList<>();
    private String[] foundWords = new String[]{};

    public void readTestPuzzle(String pathToTestPuzzle){

        try{
            BufferedReader in = new BufferedReader(new FileReader(pathToTestPuzzle));
            wordsToFind = in.readLine().split(",");
            String nextLine = in.readLine();
            while(nextLine != null){
                String[] wordSearchStringArray = nextLine.split(",");

                ArrayList<String> wordSearchRow = new ArrayList<String>(Arrays.asList(wordSearchStringArray));
                wordSearchPuzzle.add(wordSearchRow);

                nextLine = in.readLine();
            }
        }
        catch(Exception e){
            System.out.println("Error Reading File:" + pathToTestPuzzle);
        }
    }

    public String[] getWordsToFind(){
        return wordsToFind;
    }

    public ArrayList<ArrayList<String>> getPuzzle(){
        return wordSearchPuzzle;
    }

    public String[] getFoundWords(){
        return foundWords;
    }

    public Boolean puzzleIsSquare(){
        return wordSearchPuzzle.size() == wordSearchPuzzle.get(0).size();
    }

    public Boolean checkIfRowContainsWordHorizontally(String[] wordToFind, int puzzleRowToCheck){
        return true;
    }

    public void findWords(){
        if(!puzzleIsSquare()){
            System.out.println("Input Puzzle is not square");
            return;
        }
        String[] findThisWord = "RICE".split("");
        int puzzleSize = wordSearchPuzzle.size();

    }

}

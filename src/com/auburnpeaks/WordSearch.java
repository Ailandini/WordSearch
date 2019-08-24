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

                ArrayList<String> wordSearchRow = new ArrayList<>(Arrays.asList(wordSearchStringArray));
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

    public Boolean checkIfRowContainsWordBackwards(String[] wordToFind, int puzzleRowToCheck){
        int wordToFindLetterIndex = 0;
        ArrayList<String> rowToCheck = wordSearchPuzzle.get(puzzleRowToCheck);
        for(int i = rowToCheck.size() - 1; i >= 0; i--){
            System.out.println(wordToFind[wordToFindLetterIndex] + " : " + rowToCheck.get(i));
            if(wordToFind[wordToFindLetterIndex].equals(rowToCheck.get(i))){
                if(wordToFindLetterIndex == wordToFind.length - 1){
                    return true;
                }
                wordToFindLetterIndex++;
            }
            else {
                wordToFindLetterIndex = 0;
            }
        }
        return false;
    }

    public Boolean checkIfRowContainsWord(String[] wordToFind, int puzzleRowToCheck){
        int wordToFindLetterIndex = 0;
        ArrayList<String> rowToCheck = wordSearchPuzzle.get(puzzleRowToCheck);
        for (String puzzleLetter : rowToCheck) {
            if (wordToFind[wordToFindLetterIndex].equals(puzzleLetter)) {
                if(wordToFindLetterIndex == wordToFind.length - 1){
                    return true;
                }
                wordToFindLetterIndex++;
            } else {
                wordToFindLetterIndex = 0;
            }
        }
        return false;
    }

    public Boolean checkIfColumnContainsWord(String[] wordToFind, int puzzleColumnToCheck){
        int wordToFindLetterIndex = 0;
        for (ArrayList<String> puzzleRow : wordSearchPuzzle) {
            if (wordToFind[wordToFindLetterIndex].equals(puzzleRow.get(puzzleColumnToCheck))) {
                if (wordToFindLetterIndex == wordToFind.length - 1) {
                    return true;
                }
                wordToFindLetterIndex++;
            } else {
                wordToFindLetterIndex = 0;
            }
        }
        return false;
    }

    public Boolean checkIfColumnContainsWordBackwards(String[] wordToFind, int puzzleColumnToCheck){
        int wordToFindLetterIndex = 0;
        for(int i=wordSearchPuzzle.size()-1; i >=0;i--){
            if(wordToFind[wordToFindLetterIndex].equals(wordSearchPuzzle.get(i).get(puzzleColumnToCheck))){
                if(wordToFindLetterIndex == wordToFind.length - 1){
                    return true;
                }
                wordToFindLetterIndex++;
            }
            else {
                wordToFindLetterIndex = 0;
            }
        }
        return false;
    }

    public Boolean checkIfForwardSlashContainsWord(String[] wordToFind, int puzzleRowToCheck, int puzzleColumnToCheck){
        int wordToFindLetterIndex = 0;
        int wordToFindLength = wordToFind.length - 1;
        if(puzzleRowToCheck - wordToFindLength < 0 || puzzleColumnToCheck + wordToFindLength >= wordSearchPuzzle.size()){
            return false;
        }
        for(int i=0; i < wordToFind.length; i++){

            if (wordSearchPuzzle.get(puzzleRowToCheck - i).get(puzzleColumnToCheck + i).equals(wordToFind[wordToFindLetterIndex])){
                if(wordToFindLetterIndex == wordToFindLength){
                    return true;
                }
                wordToFindLetterIndex++;
            }
            else {
                wordToFindLetterIndex = 0;
            }
        }
        return false;
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

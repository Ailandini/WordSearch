package com.auburnpeaks;

import java.util.ArrayList;

public class FindWordMethods {

    public Boolean checkIfRowContainsWordBackwards(ArrayList<ArrayList<String>> wordSearchPuzzle, String[] wordToFind, int puzzleRowToCheck){
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

    public Boolean checkIfRowContainsWord(ArrayList<ArrayList<String>> wordSearchPuzzle, String[] wordToFind, int puzzleRowToCheck){
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

    public Boolean checkIfColumnContainsWord(ArrayList<ArrayList<String>> wordSearchPuzzle, String[] wordToFind, int puzzleColumnToCheck){
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

    public Boolean checkIfColumnContainsWordBackwards(ArrayList<ArrayList<String>> wordSearchPuzzle, String[] wordToFind, int puzzleColumnToCheck){
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

    public Boolean checkIfForwardSlashContainsWord(ArrayList<ArrayList<String>> wordSearchPuzzle, String[] wordToFind, int puzzleRowToCheck, int puzzleColumnToCheck){
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

    public Boolean checkIfForwardSlashContainsWordBackwards(ArrayList<ArrayList<String>> wordSearchPuzzle, String[] wordToFind, int puzzleRowToCheck, int puzzleColumnToCheck){
        int wordToFindLetterIndex = 0;
        int wordToFindLength = wordToFind.length - 1;
        if(puzzleRowToCheck + wordToFindLength >= wordSearchPuzzle.size() || puzzleColumnToCheck - wordToFindLength < 0){
            return false;
        }
        for(int i=0; i < wordToFind.length; i++){

            if (wordSearchPuzzle.get(puzzleRowToCheck + i).get(puzzleColumnToCheck - i).equals(wordToFind[wordToFindLetterIndex])){
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

    public Boolean checkIfBackSlashContainsWord(ArrayList<ArrayList<String>> wordSearchPuzzle, String[] wordToFind, int puzzleRowToCheck, int puzzleColumnToCheck){
        int wordToFindLetterIndex = 0;
        int wordToFindLength = wordToFind.length - 1;
        if(puzzleRowToCheck + wordToFindLength >= wordSearchPuzzle.size() || puzzleColumnToCheck + wordToFindLength >= wordSearchPuzzle.size()){
            return false;
        }
        for(int i=0; i < wordToFind.length; i++){

            if (wordSearchPuzzle.get(puzzleRowToCheck + i).get(puzzleColumnToCheck + i).equals(wordToFind[wordToFindLetterIndex])){
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

    public Boolean checkIfBackSlashContainsWordBackwards(ArrayList<ArrayList<String>> wordSearchPuzzle, String[] wordToFind, int puzzleRowToCheck, int puzzleColumnToCheck){
        int wordToFindLetterIndex = 0;
        int wordToFindLength = wordToFind.length - 1;
        if(puzzleRowToCheck - wordToFindLength < 0 || puzzleColumnToCheck - wordToFindLength < 0){
            return false;
        }
        for(int i=0; i < wordToFind.length; i++){

            if (wordSearchPuzzle.get(puzzleRowToCheck - i).get(puzzleColumnToCheck - i).equals(wordToFind[wordToFindLetterIndex])){
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
}

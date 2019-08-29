import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;

public class WordSearch {
    private String[] wordsToFind = new String[]{};
    private ArrayList<ArrayList<String>> wordSearchPuzzle = new ArrayList<>();
    private String foundWords = "";
    private StringBuilder foundWordSoFar = new StringBuilder();

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

    public String getFoundWords(){
        return foundWords.trim();
    }

    public Boolean puzzleIsSquare(){
        return wordSearchPuzzle.size() == wordSearchPuzzle.get(0).size();
    }

    private StringBuilder createInitialWordToFind(String[] wordToFind){
        StringBuilder initialWord = new StringBuilder();
        for(String letter : wordToFind){ initialWord.append(letter);}
        initialWord.append(": ");
        return initialWord;
    }

    private int checkIfWordHelperAndStringWriter(String[] wordToFind, int wordToFindLetterIndex, int row, int column){
        if(wordToFind[wordToFindLetterIndex].equals(wordSearchPuzzle.get(row).get(column))){
            foundWordSoFar.append("(").append(column).append(",").append(row).append("),");
            if(wordToFindLetterIndex == wordToFind.length - 1){
                foundWords += foundWordSoFar.substring(0, foundWordSoFar.length() - 1) + "\n";
            }
            return wordToFindLetterIndex + 1;
        }
        else {

            foundWordSoFar = createInitialWordToFind(wordToFind);
            return 0;
        }
    }

    public Boolean checkIfRowContainsWordBackwards(String[] wordToFind, int puzzleRowToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        foundWordSoFar = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        for(int i = wordSearchPuzzle.size() - 1; i >= 0; i--){
            wordToFindLetterIndex = checkIfWordHelperAndStringWriter(wordToFind, wordToFindLetterIndex, puzzleRowToCheck, i);
            if(wordToFind.length == wordToFindLetterIndex) {
                return true;
            }
        }
        return false;
    }

    public Boolean checkIfRowContainsWord(String[] wordToFind, int puzzleRowToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        foundWordSoFar = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        for (int i=0; i < wordSearchPuzzle.size(); i++) {
            wordToFindLetterIndex = checkIfWordHelperAndStringWriter(wordToFind, wordToFindLetterIndex, puzzleRowToCheck, i);
            if(wordToFind.length == wordToFindLetterIndex) {
                return true;
            }
        }
        return false;
    }

    public Boolean checkIfColumnContainsWord(String[] wordToFind, int puzzleColumnToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        foundWordSoFar = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        for(int i=0; i < wordSearchPuzzle.size(); i++){
            wordToFindLetterIndex = checkIfWordHelperAndStringWriter(wordToFind, wordToFindLetterIndex, i, puzzleColumnToCheck);
            if(wordToFind.length == wordToFindLetterIndex) {
                return true;
            }
        }
        return false;
    }

    public Boolean checkIfColumnContainsWordBackwards(String[] wordToFind, int puzzleColumnToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        foundWordSoFar = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        for(int i=wordSearchPuzzle.size()-1; i >=0;i--){
            wordToFindLetterIndex = checkIfWordHelperAndStringWriter(wordToFind, wordToFindLetterIndex, i, puzzleColumnToCheck);
            if(wordToFind.length == wordToFindLetterIndex) {
                return true;
            }
        }
        return false;
    }

    public Boolean checkIfForwardSlashContainsWord(String[] wordToFind, int puzzleRowToCheck, int puzzleColumnToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        foundWordSoFar = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        int wordToFindLength = wordToFind.length - 1;
        if(puzzleRowToCheck - wordToFindLength < 0 || puzzleColumnToCheck + wordToFindLength >= wordSearchPuzzle.size()){
            return false;
        }
        for(int i=0; i < wordToFind.length; i++){
            wordToFindLetterIndex = checkIfWordHelperAndStringWriter(wordToFind, wordToFindLetterIndex, puzzleRowToCheck - i, puzzleColumnToCheck + i);
            if(wordToFind.length == wordToFindLetterIndex) {
                return true;
            }
        }
        return false;
    }

    public Boolean checkIfForwardSlashContainsWordBackwards(String[] wordToFind, int puzzleRowToCheck, int puzzleColumnToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        foundWordSoFar = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        int wordToFindLength = wordToFind.length - 1;
        if(puzzleRowToCheck + wordToFindLength >= wordSearchPuzzle.size() || puzzleColumnToCheck - wordToFindLength < 0){
            return false;
        }
        for(int i=0; i < wordToFind.length; i++){

            wordToFindLetterIndex = checkIfWordHelperAndStringWriter(wordToFind, wordToFindLetterIndex, puzzleRowToCheck + i, puzzleColumnToCheck - i);
            if(wordToFind.length == wordToFindLetterIndex) {
                return true;
            }
        }
        return false;
    }

    public Boolean checkIfBackSlashContainsWord(String[] wordToFind, int puzzleRowToCheck, int puzzleColumnToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        foundWordSoFar = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        int wordToFindLength = wordToFind.length - 1;
        if(puzzleRowToCheck + wordToFindLength >= wordSearchPuzzle.size() || puzzleColumnToCheck + wordToFindLength >= wordSearchPuzzle.size()){
            return false;
        }
        for(int i=0; i < wordToFind.length; i++){

            wordToFindLetterIndex = checkIfWordHelperAndStringWriter(wordToFind, wordToFindLetterIndex, puzzleRowToCheck + i, puzzleColumnToCheck + i);
            if(wordToFind.length == wordToFindLetterIndex) {
                return true;
            }
        }
        return false;
    }

    public Boolean checkIfBackSlashContainsWordBackwards(String[] wordToFind, int puzzleRowToCheck, int puzzleColumnToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        foundWordSoFar = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        int wordToFindLength = wordToFind.length - 1;
        if(puzzleRowToCheck - wordToFindLength < 0 || puzzleColumnToCheck - wordToFindLength < 0){
            return false;
        }
        for(int i=0; i < wordToFind.length; i++){

            wordToFindLetterIndex = checkIfWordHelperAndStringWriter(wordToFind, wordToFindLetterIndex, puzzleRowToCheck - i, puzzleColumnToCheck - i);
            if(wordToFind.length == wordToFindLetterIndex) {
                return true;
            }
        }
        return false;
    }



    public void findWords(){
        if(Arrays.asList(wordsToFind).contains("")){
            System.out.println("Words to find contains a null value");
            return;
        }
        if(wordSearchPuzzle.isEmpty()){
            System.out.println("Puzzle is empty (size = 0)");
            return;
        }
        if(!puzzleIsSquare()){
            System.out.println("Puzzle is not square");
            return;
        }
        if(wordSearchPuzzle.contains(null)){
            System.out.println("Puzzle contains a null row");
            return;
        }

        int puzzleSize = wordSearchPuzzle.size();
        for(String wordToFind : wordsToFind){
            boolean foundWord = false;
            String[] wordToFindArray = wordToFind.split("");
            for(int i = 0; i < puzzleSize; i++){
                if(foundWord){
                    break;
                }
                if(checkIfRowContainsWord(wordToFindArray, i) || checkIfRowContainsWordBackwards(wordToFindArray, i)){
                    break;
                }
                for(int j = 0; j < puzzleSize; j++){
                    if(checkIfColumnContainsWord(wordToFindArray, j) || checkIfColumnContainsWordBackwards(wordToFindArray, j)){

                        foundWord = true;
                        break;
                    }
                    if(checkIfForwardSlashContainsWord(wordToFindArray, i, j) || checkIfForwardSlashContainsWordBackwards(wordToFindArray, i, j)
                    || checkIfBackSlashContainsWord(wordToFindArray, i, j) || checkIfBackSlashContainsWordBackwards(wordToFindArray, i, j)){
                        foundWord = true;
                        break;
                    }
                }
            }
        }

    }

}

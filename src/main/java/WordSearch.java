import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;

public class WordSearch {
    private String[] wordsToFind = new String[]{};
    private ArrayList<ArrayList<String>> wordSearchPuzzle = new ArrayList<>();
    private String foundWords = "";

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

    public Boolean checkIfRowContainsWordBackwards(String[] wordToFind, int puzzleRowToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        StringBuilder outputIfWordFound = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        ArrayList<String> rowToCheck = wordSearchPuzzle.get(puzzleRowToCheck);
        for(int i = rowToCheck.size() - 1; i >= 0; i--){
            if(wordToFind[wordToFindLetterIndex].equals(rowToCheck.get(i))){
                outputIfWordFound.append("(").append(i).append(",").append(puzzleRowToCheck).append("),");
                if(wordToFindLetterIndex == wordToFind.length - 1){
                    foundWords += outputIfWordFound.substring(0, outputIfWordFound.length() - 1) + "\n";
                    return true;
                }
                wordToFindLetterIndex++;
            }
            else {
                wordToFindLetterIndex = 0;
                outputIfWordFound = new StringBuilder(initialWord.toString());
            }
        }
        return false;
    }

    public Boolean checkIfRowContainsWord(String[] wordToFind, int puzzleRowToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        StringBuilder outputIfWordFound = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        ArrayList<String> rowToCheck = wordSearchPuzzle.get(puzzleRowToCheck);
        for (int i=0; i < wordSearchPuzzle.size(); i++) {
            if (wordToFind[wordToFindLetterIndex].equals(rowToCheck.get(i))) {
                outputIfWordFound.append("(").append(i).append(",").append(puzzleRowToCheck).append("),");
                if(wordToFindLetterIndex == wordToFind.length - 1){
                    foundWords += outputIfWordFound.substring(0, outputIfWordFound.length() - 1) + "\n";
                    return true;
                }
                wordToFindLetterIndex++;
            } else {
                wordToFindLetterIndex = 0;
                outputIfWordFound = new StringBuilder(initialWord.toString());
            }
        }
        return false;
    }

    public Boolean checkIfColumnContainsWord(String[] wordToFind, int puzzleColumnToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        StringBuilder outputIfWordFound = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        for(int i=0; i < wordSearchPuzzle.size(); i++){
            if (wordToFind[wordToFindLetterIndex].equals(wordSearchPuzzle.get(i).get(puzzleColumnToCheck))) {
                outputIfWordFound.append("(").append(puzzleColumnToCheck).append(",").append(i).append("),");
                if (wordToFindLetterIndex == wordToFind.length - 1) {
                    foundWords += outputIfWordFound.substring(0, outputIfWordFound.length() - 1) + "\n";
                    return true;
                }
                wordToFindLetterIndex++;
            } else {
                wordToFindLetterIndex = 0;
                outputIfWordFound = new StringBuilder(initialWord.toString());
            }
        }
        return false;
    }

    public Boolean checkIfColumnContainsWordBackwards(String[] wordToFind, int puzzleColumnToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        StringBuilder outputIfWordFound = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        for(int i=wordSearchPuzzle.size()-1; i >=0;i--){
            if(wordToFind[wordToFindLetterIndex].equals(wordSearchPuzzle.get(i).get(puzzleColumnToCheck))){
                outputIfWordFound.append("(").append(puzzleColumnToCheck).append(",").append(i).append("),");
                if(wordToFindLetterIndex == wordToFind.length - 1){
                    foundWords += outputIfWordFound.substring(0, outputIfWordFound.length() - 1) + "\n";
                    return true;
                }
                wordToFindLetterIndex++;
            }
            else {
                wordToFindLetterIndex = 0;
                outputIfWordFound = new StringBuilder(initialWord.toString());
            }
        }
        return false;
    }

    public Boolean checkIfForwardSlashContainsWord(String[] wordToFind, int puzzleRowToCheck, int puzzleColumnToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        StringBuilder outputIfWordFound = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        int wordToFindLength = wordToFind.length - 1;
        if(puzzleRowToCheck - wordToFindLength < 0 || puzzleColumnToCheck + wordToFindLength >= wordSearchPuzzle.size()){
            return false;
        }
        for(int i=0; i < wordToFind.length; i++){

            if (wordSearchPuzzle.get(puzzleRowToCheck - i).get(puzzleColumnToCheck + i).equals(wordToFind[wordToFindLetterIndex])){
                outputIfWordFound.append("(").append(puzzleColumnToCheck + i).append(",").append(puzzleRowToCheck - i).append("),");
                if(wordToFindLetterIndex == wordToFindLength){
                    foundWords += outputIfWordFound.substring(0, outputIfWordFound.length() - 1) + "\n";
                    return true;
                }
                wordToFindLetterIndex++;
            }
            else {
                wordToFindLetterIndex = 0;
                outputIfWordFound = new StringBuilder(initialWord.toString());
            }
        }
        return false;
    }

    public Boolean checkIfForwardSlashContainsWordBackwards(String[] wordToFind, int puzzleRowToCheck, int puzzleColumnToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        StringBuilder outputIfWordFound = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        int wordToFindLength = wordToFind.length - 1;
        if(puzzleRowToCheck + wordToFindLength >= wordSearchPuzzle.size() || puzzleColumnToCheck - wordToFindLength < 0){
            return false;
        }
        for(int i=0; i < wordToFind.length; i++){

            if (wordSearchPuzzle.get(puzzleRowToCheck + i).get(puzzleColumnToCheck - i).equals(wordToFind[wordToFindLetterIndex])){
                outputIfWordFound.append("(").append(puzzleColumnToCheck - i).append(",").append(puzzleRowToCheck + i).append("),");
                if(wordToFindLetterIndex == wordToFindLength){
                    foundWords += outputIfWordFound.substring(0, outputIfWordFound.length() - 1) + "\n";
                    return true;
                }
                wordToFindLetterIndex++;
            }
            else {
                wordToFindLetterIndex = 0;
                outputIfWordFound = new StringBuilder(initialWord.toString());
            }
        }
        return false;
    }

    public Boolean checkIfBackSlashContainsWord(String[] wordToFind, int puzzleRowToCheck, int puzzleColumnToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        StringBuilder outputIfWordFound = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        int wordToFindLength = wordToFind.length - 1;
        if(puzzleRowToCheck + wordToFindLength >= wordSearchPuzzle.size() || puzzleColumnToCheck + wordToFindLength >= wordSearchPuzzle.size()){
            return false;
        }
        for(int i=0; i < wordToFind.length; i++){

            if (wordSearchPuzzle.get(puzzleRowToCheck + i).get(puzzleColumnToCheck + i).equals(wordToFind[wordToFindLetterIndex])){
                outputIfWordFound.append("(").append(puzzleColumnToCheck + i).append(",").append(puzzleRowToCheck + i).append("),");
                if(wordToFindLetterIndex == wordToFindLength){
                    foundWords += outputIfWordFound.substring(0, outputIfWordFound.length() - 1) + "\n";
                    return true;
                }
                wordToFindLetterIndex++;
            }
            else {
                wordToFindLetterIndex = 0;
                outputIfWordFound = new StringBuilder(initialWord.toString());
            }
        }
        return false;
    }

    public Boolean checkIfBackSlashContainsWordBackwards(String[] wordToFind, int puzzleRowToCheck, int puzzleColumnToCheck){
        StringBuilder initialWord = createInitialWordToFind(wordToFind);
        StringBuilder outputIfWordFound = new StringBuilder(initialWord.toString());

        int wordToFindLetterIndex = 0;
        int wordToFindLength = wordToFind.length - 1;
        if(puzzleRowToCheck - wordToFindLength < 0 || puzzleColumnToCheck - wordToFindLength < 0){
            return false;
        }
        for(int i=0; i < wordToFind.length; i++){

            if (wordSearchPuzzle.get(puzzleRowToCheck - i).get(puzzleColumnToCheck - i).equals(wordToFind[wordToFindLetterIndex])){
                outputIfWordFound.append("(").append(puzzleColumnToCheck - i).append(",").append(puzzleRowToCheck - i).append("),");
                if(wordToFindLetterIndex == wordToFindLength){
                    foundWords += outputIfWordFound.substring(0, outputIfWordFound.length() - 1) + "\n";
                    return true;
                }
                wordToFindLetterIndex++;
            }
            else {
                wordToFindLetterIndex = 0;
                outputIfWordFound = new StringBuilder(initialWord.toString());
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

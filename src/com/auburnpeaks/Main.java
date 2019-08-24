package com.auburnpeaks;

public class Main {

    public static void main(String[] args) {
        WordSearch wordsearchSingle = new WordSearch();
        wordsearchSingle.readTestPuzzle("Inputs/WordSearchSingleWord");
        wordsearchSingle.findWords();
        System.out.println(wordsearchSingle.getFoundWords());
    }
}

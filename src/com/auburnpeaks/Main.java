package com.auburnpeaks;

public class Main {

    public static void main(String[] args) {
	    WordSearch wordsearch = new WordSearch();
	    wordsearch.readTestPuzzle("Inputs/WordSearchTestPuzzle3");
	    wordsearch.checkIfRowContainsWordBackwards("SQUASH".split(""), 9);
    }
}

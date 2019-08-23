package com.auburnpeaks;

public class Main {

    public static void main(String[] args) {
	    WordSearch wordsearch = new WordSearch();
	    wordsearch.readTestPuzzle("Inputs/WordSearchTestPuzzle3");
	    wordsearch.checkIfRowContainsWordHorizontallyBackwards("SQUASH".split(""), 9);
    }
}

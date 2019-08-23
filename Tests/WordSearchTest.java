import com.auburnpeaks.WordSearch;
import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class WordSearchTest {
    private WordSearch wordsearch;
    private WordSearch wordsearch2;
    private WordSearch wordsearch3;

    @Before
    public void setUp(){
        wordsearch  = new WordSearch();
        wordsearch2 = new WordSearch();
        wordsearch3 = new WordSearch();
        wordsearch.readTestPuzzle("Inputs/WordSearchTestPuzzle1");
        wordsearch2.readTestPuzzle("Inputs/WordSearchTestPuzzle2");
        wordsearch3.readTestPuzzle("Inputs/WordSearchTestPuzzle3");
    }

    @Test
    public void CheckThatFirstWordFromTest1IsBanana(){
        assertEquals("BANANA", wordsearch.getWordsToFind()[0]);
    }

    @Test
    public void CheckThatAllWordsFromTest1AreRead(){
        assertArrayEquals(new String[]{"BANANA", "CAT", "OWL", "PANTHER"}, wordsearch.getWordsToFind());
    }

    @Test
    public void CheckThatAllPuzzleLinesFromTest1AreRead(){
        assertEquals(9, wordsearch.getPuzzle().size());
    }

    @Test
    public void CheckThatAllPuzzleLinesAreRead(){
        assertEquals(12, wordsearch2.getPuzzle().size());
        assertEquals(10, wordsearch3.getPuzzle().size());
    }

    @Test
    public void CheckThatPuzzleIsSquare(){
        assertEquals(wordsearch.getPuzzle().size(), wordsearch.getPuzzle().get(0).size());
        assertEquals(wordsearch2.getPuzzle().size(), wordsearch2.getPuzzle().get(0).size());
        assertEquals(wordsearch3.getPuzzle().size(), wordsearch3.getPuzzle().get(0).size());
    }

    @Test
    public void PuzzleIsSquareCorrectOutput(){
        WordSearch wordsearch4 = new WordSearch();
        wordsearch4.readTestPuzzle("Inputs/WordSearchTestPuzzle4");
        assertTrue(wordsearch.puzzleIsSquare());
        assertTrue(wordsearch2.puzzleIsSquare());
        assertFalse(wordsearch4.puzzleIsSquare());
    }

    @Test
    public void PuzzleCanFindHorizontalWords(){
        assertTrue(wordsearch3.checkIfRowContainsWordHorizontally("RICE".split(""), 9));
        assertTrue(wordsearch3.checkIfRowContainsWordHorizontally("ZUCCHINI".split(""), 8));
    }



}

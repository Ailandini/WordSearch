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
        assertFalse(wordsearch3.checkIfRowContainsWordHorizontally("RICE".split(""), 8));
        assertTrue(wordsearch3.checkIfRowContainsWordHorizontally("ZUCCHINI".split(""), 8));
        assertFalse(wordsearch3.checkIfRowContainsWordHorizontally("SQUASH".split(""), 9));
        assertFalse(wordsearch2.checkIfRowContainsWordHorizontally("ASTRONAUT".split(""), 5));
        assertTrue(wordsearch2.checkIfRowContainsWordHorizontally("CITRUS".split(""), 8));
    }

    @Test
    public void PuzzleCanFindHorizontalWordsBackwards(){
        assertTrue(wordsearch3.checkIfRowContainsWordHorizontallyBackwards("SQUASH".split(""), 9));
        assertTrue(wordsearch.checkIfRowContainsWordHorizontallyBackwards("BANANA".split(""), 6));
        assertFalse(wordsearch2.checkIfRowContainsWordHorizontallyBackwards("ASTRONAUT".split(""), 5));
    }

    @Test
    public void PuzzleCanFindVerticalWords(){
        String[] wordsToFindInPuzzle1 = wordsearch.getWordsToFind();
        String[] wordsToFindInPuzzle2 = wordsearch2.getWordsToFind();
        String[] wordsToFindInPuzzle3 = wordsearch3.getWordsToFind();
        assertTrue(wordsearch.checkIfColumnContainsWord(wordsToFindInPuzzle1[2].split(""), 8));
        assertTrue(wordsearch2.checkIfColumnContainsWord(wordsToFindInPuzzle2[7].split(""), 11));
        assertTrue(wordsearch3.checkIfColumnContainsWord(wordsToFindInPuzzle3[5].split(""), 7));
        assertFalse(wordsearch.checkIfColumnContainsWord(wordsToFindInPuzzle1[0].split(""), 3));
        assertFalse(wordsearch3.checkIfColumnContainsWord(wordsToFindInPuzzle3[3].split(""), 6));
    }


}

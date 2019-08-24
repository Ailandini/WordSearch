import com.auburnpeaks.WordSearch;
import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class WordSearchTest {
    private WordSearch wordsearch;
    private WordSearch wordsearch2;
    private WordSearch wordsearch3;
    private String[] wordsToFindInPuzzle1;
    private String[] wordsToFindInPuzzle2;
    private String[] wordsToFindInPuzzle3;

    @Before
    public void setUp(){
        wordsearch  = new WordSearch();
        wordsearch2 = new WordSearch();
        wordsearch3 = new WordSearch();
        wordsearch.readTestPuzzle("Inputs/WordSearchTestPuzzle1");
        wordsearch2.readTestPuzzle("Inputs/WordSearchTestPuzzle2");
        wordsearch3.readTestPuzzle("Inputs/WordSearchTestPuzzle3");
        wordsToFindInPuzzle1 = wordsearch.getWordsToFind();
        wordsToFindInPuzzle2 = wordsearch2.getWordsToFind();
        wordsToFindInPuzzle3 = wordsearch3.getWordsToFind();
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
        assertTrue(wordsearch3.checkIfRowContainsWord("RICE".split(""), 9));
        assertFalse(wordsearch3.checkIfRowContainsWord("RICE".split(""), 8));
        assertTrue(wordsearch3.checkIfRowContainsWord("ZUCCHINI".split(""), 8));
        assertFalse(wordsearch3.checkIfRowContainsWord("SQUASH".split(""), 9));
        assertFalse(wordsearch2.checkIfRowContainsWord("ASTRONAUT".split(""), 5));
        assertTrue(wordsearch2.checkIfRowContainsWord("CITRUS".split(""), 8));
    }

    @Test
    public void PuzzleCanFindHorizontalWordsBackwards(){
        assertTrue(wordsearch3.checkIfRowContainsWordBackwards("SQUASH".split(""), 9));
        assertTrue(wordsearch.checkIfRowContainsWordBackwards("BANANA".split(""), 6));
        assertFalse(wordsearch2.checkIfRowContainsWordBackwards("ASTRONAUT".split(""), 5));
    }

    @Test
    public void PuzzleCanFindVerticalWords(){
        assertTrue(wordsearch.checkIfColumnContainsWord(wordsToFindInPuzzle1[2].split(""), 8));
        assertTrue(wordsearch2.checkIfColumnContainsWord(wordsToFindInPuzzle2[7].split(""), 11));
        assertTrue(wordsearch3.checkIfColumnContainsWord(wordsToFindInPuzzle3[5].split(""), 7));
        assertFalse(wordsearch.checkIfColumnContainsWord(wordsToFindInPuzzle1[0].split(""), 3));
        assertFalse(wordsearch3.checkIfColumnContainsWord(wordsToFindInPuzzle3[3].split(""), 6));
    }

    @Test
    public void PuzzleCanFindVerticalWordsBackwards(){
        assertTrue(wordsearch3.checkIfColumnContainsWordBackwards(wordsToFindInPuzzle3[2].split(""), 8));
        assertTrue(wordsearch3.checkIfColumnContainsWordBackwards(wordsToFindInPuzzle3[6].split(""), 9));
        assertTrue(wordsearch2.checkIfColumnContainsWordBackwards(wordsToFindInPuzzle2[5].split(""), 10));
        assertFalse(wordsearch.checkIfColumnContainsWordBackwards(wordsToFindInPuzzle1[2].split(""), 3));
        assertFalse(wordsearch.checkIfColumnContainsWordBackwards(wordsToFindInPuzzle1[0].split(""), 0));
    }

    @Test
    public void PuzzleCanFindForwardSlashWords(){
        assertTrue(wordsearch3.checkIfForwardSlashContainsWord(wordsToFindInPuzzle3[1].split(""), 7, 2));
        assertTrue(wordsearch2.checkIfForwardSlashContainsWord(wordsToFindInPuzzle2[4].split(""), 6, 1));
        assertFalse(wordsearch2.checkIfForwardSlashContainsWord(wordsToFindInPuzzle2[1].split(""), 7, 2));
        assertFalse(wordsearch.checkIfForwardSlashContainsWord(wordsToFindInPuzzle1[0].split(""), 0,0));
    }

    @Test
    public void PuzzleCanFindForwardSlashWordsBackwards(){
        assertTrue(wordsearch3.checkIfForwardSlashContainsWordBackwards(wordsToFindInPuzzle3[9].split(""), 0, 5 ));
        assertTrue(wordsearch2.checkIfForwardSlashContainsWordBackwards(wordsToFindInPuzzle2[6].split(""), 0, 9 ));
        assertTrue(wordsearch.checkIfForwardSlashContainsWordBackwards(wordsToFindInPuzzle1[3].split(""), 1, 6 ));
        assertFalse(wordsearch.checkIfForwardSlashContainsWordBackwards(wordsToFindInPuzzle1[1].split(""), 5, 3 ));
        assertFalse(wordsearch3.checkIfForwardSlashContainsWordBackwards(wordsToFindInPuzzle3[2].split(""), 7, 8 ));
    }
}

import com.auburnpeaks.FindWordMethods;
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
    private FindWordMethods findWordMethods;

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
        findWordMethods = new FindWordMethods();
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
        assertTrue(findWordMethods.checkIfRowContainsWord(wordsearch3.getPuzzle(), "RICE".split(""), 9));
        assertFalse(findWordMethods.checkIfRowContainsWord(wordsearch3.getPuzzle(), "RICE".split(""), 8));
        assertTrue(findWordMethods.checkIfRowContainsWord(wordsearch3.getPuzzle(), "ZUCCHINI".split(""), 8));
        assertFalse(findWordMethods.checkIfRowContainsWord(wordsearch3.getPuzzle(), "SQUASH".split(""), 9));
        assertFalse(findWordMethods.checkIfRowContainsWord(wordsearch2.getPuzzle(), "ASTRONAUT".split(""), 5));
        assertTrue(findWordMethods.checkIfRowContainsWord(wordsearch2.getPuzzle(), "CITRUS".split(""), 8));
    }

    @Test
    public void PuzzleCanFindHorizontalWordsBackwards(){
        assertTrue(findWordMethods.checkIfRowContainsWordBackwards(wordsearch3.getPuzzle(),"SQUASH".split(""), 9));
        assertTrue(findWordMethods.checkIfRowContainsWordBackwards(wordsearch.getPuzzle(), "BANANA".split(""), 6));
        assertFalse(findWordMethods.checkIfRowContainsWordBackwards(wordsearch2.getPuzzle(), "ASTRONAUT".split(""), 5));
    }

    @Test
    public void PuzzleCanFindVerticalWords(){
        assertTrue(findWordMethods.checkIfColumnContainsWord( wordsearch.getPuzzle() ,wordsToFindInPuzzle1[2].split(""), 8));
        assertTrue(findWordMethods.checkIfColumnContainsWord(wordsearch2.getPuzzle(),wordsToFindInPuzzle2[7].split(""), 11));
        assertTrue(findWordMethods.checkIfColumnContainsWord(wordsearch3.getPuzzle(),wordsToFindInPuzzle3[5].split(""), 7));
        assertFalse(findWordMethods.checkIfColumnContainsWord(wordsearch.getPuzzle(),wordsToFindInPuzzle1[0].split(""), 3));
        assertFalse(findWordMethods.checkIfColumnContainsWord(wordsearch3.getPuzzle(),wordsToFindInPuzzle3[3].split(""), 6));
    }

    @Test
    public void PuzzleCanFindVerticalWordsBackwards(){
        assertTrue(findWordMethods.checkIfColumnContainsWordBackwards(wordsearch3.getPuzzle() ,wordsToFindInPuzzle3[2].split(""), 8));
        assertTrue(findWordMethods.checkIfColumnContainsWordBackwards(wordsearch3.getPuzzle() ,wordsToFindInPuzzle3[6].split(""), 9));
        assertTrue(findWordMethods.checkIfColumnContainsWordBackwards(wordsearch2.getPuzzle(), wordsToFindInPuzzle2[5].split(""), 10));
        assertFalse(findWordMethods.checkIfColumnContainsWordBackwards(wordsearch.getPuzzle(), wordsToFindInPuzzle1[2].split(""), 3));
        assertFalse(findWordMethods.checkIfColumnContainsWordBackwards(wordsearch.getPuzzle(), wordsToFindInPuzzle1[0].split(""), 0));
    }

    @Test
    public void PuzzleCanFindForwardSlashWords(){
        assertTrue(findWordMethods.checkIfForwardSlashContainsWord(wordsearch3.getPuzzle(), wordsToFindInPuzzle3[1].split(""), 7, 2));
        assertTrue(findWordMethods.checkIfForwardSlashContainsWord(wordsearch2.getPuzzle(), wordsToFindInPuzzle2[4].split(""), 6, 1));
        assertFalse(findWordMethods.checkIfForwardSlashContainsWord(wordsearch2.getPuzzle(), wordsToFindInPuzzle2[1].split(""), 7, 2));
        assertFalse(findWordMethods.checkIfForwardSlashContainsWord(wordsearch.getPuzzle(), wordsToFindInPuzzle1[0].split(""), 0,0));
    }

    @Test
    public void PuzzleCanFindForwardSlashWordsBackwards(){
        assertTrue(findWordMethods.checkIfForwardSlashContainsWordBackwards(wordsearch3.getPuzzle(), wordsToFindInPuzzle3[9].split(""), 0, 5 ));
        assertTrue(findWordMethods.checkIfForwardSlashContainsWordBackwards(wordsearch2.getPuzzle(), wordsToFindInPuzzle2[6].split(""), 0, 9 ));
        assertTrue(findWordMethods.checkIfForwardSlashContainsWordBackwards(wordsearch.getPuzzle(), wordsToFindInPuzzle1[3].split(""), 1, 6 ));
        assertFalse(findWordMethods.checkIfForwardSlashContainsWordBackwards(wordsearch.getPuzzle(), wordsToFindInPuzzle1[1].split(""), 5, 3 ));
        assertFalse(findWordMethods.checkIfForwardSlashContainsWordBackwards(wordsearch3.getPuzzle(), wordsToFindInPuzzle3[2].split(""), 7, 8 ));
    }

    @Test
    public void PuzzleCanFindBackSlashWords(){
        assertTrue(findWordMethods.checkIfBackSlashContainsWord(wordsearch3.getPuzzle(), wordsToFindInPuzzle3[3].split(""), 2, 0));
        assertTrue(findWordMethods.checkIfBackSlashContainsWord(wordsearch2.getPuzzle(), wordsToFindInPuzzle2[2].split(""), 0, 0));
        assertFalse(findWordMethods.checkIfBackSlashContainsWord(wordsearch2.getPuzzle(), wordsToFindInPuzzle2[0].split(""), 8, 7));
        assertFalse(findWordMethods.checkIfBackSlashContainsWord(wordsearch3.getPuzzle(), wordsToFindInPuzzle2[5].split(""), 4, 2));
    }

    @Test
    public void PuzzleCanFindBackSlashWordsBackwards(){
        WordSearch wordsearch5 = new WordSearch();
        wordsearch5.readTestPuzzle("Inputs/WordSearchTestPuzzle5");
        String[] wordsToFindInPuzzle5 = wordsearch5.getWordsToFind();

        assertTrue(findWordMethods.checkIfBackSlashContainsWordBackwards(wordsearch5.getPuzzle(), wordsToFindInPuzzle5[2].split(""), 3, 3));
        assertFalse(findWordMethods.checkIfBackSlashContainsWordBackwards(wordsearch5.getPuzzle(), wordsToFindInPuzzle5[0].split(""), 2, 0));
    }
}

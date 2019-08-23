import com.auburnpeaks.WordSearch;
import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class WordSearchTest {
    private WordSearch wordsearch;
    private WordSearch wordsearch2;

    @Before
    public void setUp(){
        wordsearch  = new WordSearch();
        wordsearch2 = new WordSearch();
        wordsearch.readTestPuzzle("Inputs/WordSearchTestPuzzle1");
        wordsearch2.readTestPuzzle("Inputs/WordSearchTestPuzzle2");
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
    public void CheckThatTest1PuzzleIsSquare(){
        assertEquals(wordsearch.getPuzzle().size(), wordsearch.getPuzzle().get(0).size());
    }

}

import com.auburnpeaks.WordSearch;
import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class WordSearchTest {
    private WordSearch wordsearch;

    @Before
    public void setUp(){
        wordsearch  = new WordSearch();
        wordsearch.readTestPuzzle("Inputs/WordSearchTestPuzzle1");
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

}

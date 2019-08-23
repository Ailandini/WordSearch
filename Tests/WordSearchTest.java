import com.auburnpeaks.WordSearch;
import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class WordSearchTest {

    @Test
    public void CheckThatFirstWordFromTest1IsBanana(){
        WordSearch wordsearch = new WordSearch();
        assertEquals("BANANA", wordsearch.readTestPuzzle("Inputs/WordSearchTestPuzzle1")[0]);
    }

    @Test
    public void CheckThatAllWordsFromTest1AreRead(){
        WordSearch wordsearch = new WordSearch();
        assertArrayEquals(new String[]{"BANANA", "CAT", "OWL", "PANTHER"}, wordsearch.readTestPuzzle("Inputs/WordSearchTestPuzzle1"));
    }

}

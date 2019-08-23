import com.auburnpeaks.WordSearch;
import org.junit.*;

import static junit.framework.TestCase.assertEquals;

public class WordSearchTest {

    @Test
    public void CheckThatFirstWordFromTest1IsBanana(){
        WordSearch wordsearch = new WordSearch();
        assertEquals("BANANA", wordsearch.readTestPuzzle("Inputs/WordSearchTestPuzzle1")[0]);
    }
}

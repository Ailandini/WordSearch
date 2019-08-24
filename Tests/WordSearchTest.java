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
        assertTrue(wordsearch2.checkIfRowContainsWordBackwards("ASTRONAUT".split(""), 10));
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

    @Test
    public void PuzzleCanFindBackSlashWords(){
        assertTrue(wordsearch3.checkIfBackSlashContainsWord(wordsToFindInPuzzle3[3].split(""), 2, 0));
        assertTrue(wordsearch2.checkIfBackSlashContainsWord(wordsToFindInPuzzle2[2].split(""), 0, 0));
        assertFalse(wordsearch2.checkIfBackSlashContainsWord(wordsToFindInPuzzle2[0].split(""), 8, 7));
        assertFalse(wordsearch3.checkIfBackSlashContainsWord(wordsToFindInPuzzle2[5].split(""), 4, 2));
    }

    @Test
    public void PuzzleCanFindBackSlashWordsBackwards(){
        WordSearch wordsearch5 = new WordSearch();
        wordsearch5.readTestPuzzle("Inputs/WordSearchTestPuzzle5");
        String[] wordsToFindInPuzzle5 = wordsearch5.getWordsToFind();

        assertTrue(wordsearch5.checkIfBackSlashContainsWordBackwards(wordsToFindInPuzzle5[2].split(""), 3, 3));
        assertFalse(wordsearch5.checkIfBackSlashContainsWordBackwards(wordsToFindInPuzzle5[0].split(""), 2, 0));
    }

    @Test
    public void HorizontalWordsReturnString() {
        wordsearch3.checkIfRowContainsWord("RICE".split(""), 9);
        assertEquals("RICE: (9,6),(9,7),(9,8),(9,9)", wordsearch3.getFoundWords());
        wordsearch3.checkIfRowContainsWord("SQUASH".split(""), 9);
        assertEquals("RICE: (9,6),(9,7),(9,8),(9,9)", wordsearch3.getFoundWords());
        wordsearch3.checkIfRowContainsWord("ZUCCHINI".split(""), 8);
        assertEquals("RICE: (9,6),(9,7),(9,8),(9,9)\nZUCCHINI: (8,0),(8,1),(8,2),(8,3),(8,4),(8,5),(8,6),(8,7)", wordsearch3.getFoundWords());
    }

    @Test
    public void BackwardHorizontalWordsReturnString(){
        wordsearch3.checkIfRowContainsWordBackwards("SQUASH".split(""), 9);
        assertEquals("SQUASH: (9,5),(9,4),(9,3),(9,2),(9,1),(9,0)", wordsearch3.getFoundWords());
    }

    @Test
    public void VerticalWordsReturnString(){
        wordsearch.checkIfColumnContainsWord(wordsToFindInPuzzle1[2].split(""), 8);
        assertEquals("OWL: (6,8),(7,8),(8,8)", wordsearch.getFoundWords());
    }

    @Test
    public void BackwardVerticalWordsReturnString(){
        wordsearch3.checkIfColumnContainsWordBackwards(wordsToFindInPuzzle3[2].split(""), 8);
        assertEquals("BROCCOLI: (7,8),(6,8),(5,8),(4,8),(3,8),(2,8),(1,8),(0,8)", wordsearch3.getFoundWords());
    }
    
    @Test
    public void DiagonalWordsReturnString(){
        wordsearch3.checkIfForwardSlashContainsWord(wordsToFindInPuzzle3[1].split(""), 7, 2);
        assertEquals("BEANS: (7,2),(6,3),(5,4),(4,5),(3,6)", wordsearch3.getFoundWords());
        wordsearch3.checkIfForwardSlashContainsWordBackwards(wordsToFindInPuzzle3[9].split(""), 0, 5 );
        assertEquals("BEANS: (7,2),(6,3),(5,4),(4,5),(3,6)\nTOMATO: (0,5),(1,4),(2,3),(3,2),(4,1),(5,0)", wordsearch3.getFoundWords());
        wordsearch3.checkIfBackSlashContainsWord(wordsToFindInPuzzle3[3].split(""), 2, 0);
        assertEquals("BEANS: (7,2),(6,3),(5,4),(4,5),(3,6)\nTOMATO: (0,5),(1,4),(2,3),(3,2),(4,1),(5,0)\nCARROT: (2,0),(3,1),(4,2),(5,3),(6,4),(7,5)", wordsearch3.getFoundWords());

        WordSearch wordsearch5 = new WordSearch();
        wordsearch5.readTestPuzzle("Inputs/WordSearchTestPuzzle5");
        String[] wordsToFindInPuzzle5 = wordsearch5.getWordsToFind();

        wordsearch5.checkIfBackSlashContainsWordBackwards(wordsToFindInPuzzle5[2].split(""), 3, 3);
        assertEquals("HIKE: (3,3),(2,2),(1,1),(0,0)", wordsearch5.getFoundWords());
    }

    @Test
    public void InvalidStringsAndPuzzlesReturnNUll(){
        WordSearch wordsearch6 = new WordSearch();
        WordSearch wordsearch4 = new WordSearch();
        WordSearch wordsearch0 = new WordSearch();
        wordsearch0.readTestPuzzle("Inputs/WordSearchEmpty");
        wordsearch6.readTestPuzzle("Inputs/WordSearchTestPuzzle6");
        wordsearch4.readTestPuzzle("Inputs/WordSearchTestPuzzle4");
        wordsearch6.findWords();
        assertEquals("", wordsearch6.getFoundWords());
        wordsearch4.findWords();
        assertEquals("", wordsearch4.getFoundWords());
        wordsearch0.findWords();
        assertEquals("", wordsearch0.getFoundWords());
    }

    @Test
    public void findSingleWordInput(){
        WordSearch wordsearchSingle = new WordSearch();
        wordsearchSingle.readTestPuzzle("Inputs/WordSearchSingleWord");
        wordsearchSingle.findWords();
        assertEquals("ASTRONAUT: (10,8),(10,7),(10,6),(10,5),(10,4),(10,3),(10,2),(10,1),(10,0)", wordsearchSingle.getFoundWords());
    }

    @Test
    public void findAllHorizontalWords(){
        wordsearch3.findWords();
        System.out.println(wordsearch3.getFoundWords());
        assertTrue(wordsearch3.getFoundWords().contains("RICE: (9,6),(9,7),(9,8),(9,9)"));
        assertTrue(wordsearch3.getFoundWords().contains("SQUASH: (9,5),(9,4),(9,3),(9,2),(9,1),(9,0)"));
        assertTrue(wordsearch3.getFoundWords().contains("ZUCCHINI: (8,0),(8,1),(8,2),(8,3),(8,4),(8,5),(8,6),(8,7)"));
    }

    @Test
    public void findAllHorizontalAndVerticalWords(){
        wordsearch3.findWords();
        assertTrue(wordsearch3.getFoundWords().contains("RICE: (9,6),(9,7),(9,8),(9,9)"));
        assertTrue(wordsearch3.getFoundWords().contains("SQUASH: (9,5),(9,4),(9,3),(9,2),(9,1),(9,0)"));
        assertTrue(wordsearch3.getFoundWords().contains("ZUCCHINI: (8,0),(8,1),(8,2),(8,3),(8,4),(8,5),(8,6),(8,7)"));
        assertTrue(wordsearch3.getFoundWords().contains("BROCCOLI: (7,8),(6,8),(5,8),(4,8),(3,8),(2,8),(1,8),(0,8)"));
        assertTrue(wordsearch3.getFoundWords().contains("HUMMUS: (1,7),(2,7),(3,7),(4,7),(5,7),(6,7)"));
        assertTrue(wordsearch3.getFoundWords().contains("RADISH: (5,9),(4,9),(3,9),(2,9),(1,9),(0,9)"));

    }

    @Test
    public void findAllHorizontalVerticalAndForwardSlashWords(){
        wordsearch3.findWords();
        assertTrue(wordsearch3.getFoundWords().contains("RICE: (9,6),(9,7),(9,8),(9,9)"));
        assertTrue(wordsearch3.getFoundWords().contains("SQUASH: (9,5),(9,4),(9,3),(9,2),(9,1),(9,0)"));
        assertTrue(wordsearch3.getFoundWords().contains("ZUCCHINI: (8,0),(8,1),(8,2),(8,3),(8,4),(8,5),(8,6),(8,7)"));
        assertTrue(wordsearch3.getFoundWords().contains("BROCCOLI: (7,8),(6,8),(5,8),(4,8),(3,8),(2,8),(1,8),(0,8)"));
        assertTrue(wordsearch3.getFoundWords().contains("HUMMUS: (1,7),(2,7),(3,7),(4,7),(5,7),(6,7)"));
        assertTrue(wordsearch3.getFoundWords().contains("RADISH: (5,9),(4,9),(3,9),(2,9),(1,9),(0,9)"));
        assertTrue(wordsearch3.getFoundWords().contains("BEANS: (7,2),(6,3),(5,4),(4,5),(3,6)"));
        assertTrue(wordsearch3.getFoundWords().contains("CUCUMBER: (7,0),(6,1),(5,2),(4,3),(3,4),(2,5),(1,6),(0,7)"));
        assertTrue(wordsearch3.getFoundWords().contains("TOMATO: (0,5),(1,4),(2,3),(3,2),(4,1),(5,0)"));
    }

    @Test
    public void findAllWords(){
        wordsearch3.findWords();
        assertEquals("ASPARAGUS: (8,8),(7,7),(6,6),(5,5),(4,4),(3,3),(2,2),(1,1),(0,0)\n" +
                "BEANS: (7,2),(6,3),(5,4),(4,5),(3,6)\n" +
                "BROCCOLI: (7,8),(6,8),(5,8),(4,8),(3,8),(2,8),(1,8),(0,8)\n" +
                "CARROT: (2,0),(3,1),(4,2),(5,3),(6,4),(7,5)\n" +
                "CUCUMBER: (7,0),(6,1),(5,2),(4,3),(3,4),(2,5),(1,6),(0,7)\n" +
                "HUMMUS: (1,7),(2,7),(3,7),(4,7),(5,7),(6,7)\n" +
                "RADISH: (5,9),(4,9),(3,9),(2,9),(1,9),(0,9)\n" +
                "RICE: (9,6),(9,7),(9,8),(9,9)\n" +
                "SQUASH: (9,5),(9,4),(9,3),(9,2),(9,1),(9,0)\n" +
                "TOMATO: (0,5),(1,4),(2,3),(3,2),(4,1),(5,0)\n" +
                "ZUCCHINI: (8,0),(8,1),(8,2),(8,3),(8,4),(8,5),(8,6),(8,7)", wordsearch3.getFoundWords());
    }
}

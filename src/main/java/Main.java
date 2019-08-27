public class Main {

    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Must provide a Word Search input file: gradle run -path to file-");
        }
        if(args.length > 1){
            System.out.println("Word Search can only solve one puzzle at a time.");
        }
        WordSearch wordsearchSingle = new WordSearch();
        wordsearchSingle.readTestPuzzle(args[0]);
        wordsearchSingle.findWords();
        System.out.println(wordsearchSingle.getFoundWords());
    }
}

/**exercise 2
*@author: Andrew, Tran
**/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IndexTree {

    private BinarySearchTree<Word> index = new BinarySearchTree<>();

    /**Create constructor of IndexTree class
     * @param filename name of file input
     * @throws FileNotFoundException
     */
    public IndexTree(String filename) throws FileNotFoundException {
        super();
        int count = 0;
        Scanner sc = new Scanner(new File(filename));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            count++;
            StringTokenizer strWord = new StringTokenizer(line); // Split line to single word
          while (strWord.hasMoreTokens()) { // Extract word from a line
              String token = strWord.nextToken().replaceAll("[^\\sa-zA-Z0-9]", "").toLowerCase(); //reformat a word
              if (!token.isEmpty()) // Handle case: "***" -> "" after replaceAll(), only add to record if token is not empty
                addRecord(token, count);
          }
        }
        sc.close();
    }

    
    /** Add word with line number into the index tree
     * @param w word
     * @param line line of word occurrence
     */
    public void addRecord(String w, int line) { // String w instead of Word w
      Word record = new Word(w, line);
        if (index.contains(record)) { //check if the word is already in the index tree
            Word wd = index.find(record); // find reference
            wd.addOccurence(line);	// Add line occurrence to reference node
        } else {
            index.add(record);
        }
    }
  
    /**Print the contents of the index in alphabetical order of the words, 
     * one word per line
     * 
     */
    public void printIndex() {
        index.printOrderedData();
    }
}

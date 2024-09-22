/**exercise 2
*@author: Andrew, Tran
**/
import java.util.ArrayList;

public class Word implements Comparable<Word> {

    private String w;
    private int count;

    private ArrayList<Integer> lines = new ArrayList<Integer>();

    /** Constructor of Word class
     * @param w word
     * @param line line of word occurrence
     */
    public Word(String w, int line) {
        super();
        this.w = w;
        this.count = 1;

        lines.add(line); //add line to array list lines of occurrence

    }

    /**Add the specified line number to the ArrayList only if it’s not already in the list, 
     * and regardless should increase count by 1
     * @param line line of word occurrence
     */
    public void addOccurence(int line) { 
        if (!lines.contains(line)) {
            lines.add(line);
        }
        count++;
    }

    /**Print content of Word class
     *
     */
    @Override
    public String toString() {
        String s = w + " (" + count + "): "; 

        int i = 0;

        for (i = 0; i < lines.size() - 1; i++) {

            s += lines.get(i) + ", ";

        }

        s += lines.get(i) + "\n";
        return s;

    }

    /**Compare String word data field to another Word class 
     *
     */
    @Override

    public int compareTo(Word o) {

        return this.w.compareTo(o.w);

    }

}

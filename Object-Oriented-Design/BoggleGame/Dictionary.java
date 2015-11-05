import java.util.*;
import java.io.*;

public class Dictionary {
    private Dictionary () {}
    private static volatile Dictionary _instance;
    private static Trie wordTrie;
    	/** * Double checked locking code on Dictionary * @return Singelton instance */
    public static Dictionary getInstance() throws Exception {
		if (_instance == null) {
    		synchronized (Dictionary.class) {
    			if (_instance == null) {
    				_instance = new Dictionary();
                    wordTrie = new Trie();
                    initiateTrie();
    			}
    		}
    	}
		return _instance;
	}
    private static void initiateTrie() throws Exception {
        try {
            Scanner sc = new Scanner(new File("./dict.txt"));
            while (sc.hasNext()) {
                wordTrie.insert(sc.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error in scanning file");
        }
    }
    public boolean isWord(String inputString) {
        return wordTrie.search(inputString);
    }
}

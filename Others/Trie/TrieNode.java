import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    private TrieNode parent;
    private TrieNode[] children;
    private boolean isLeaf;
    private boolean isWord;
    private char character;

    public TrieNode() {
        children = new TrieNode[26];
        isLeaf == true;
        isWord = false;
    }
    
}

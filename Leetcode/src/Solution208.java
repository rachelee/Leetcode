import java.util.*;
public class Solution208 {
	class TrieNode {
	    // Initialize your data structure here.
	    char c;
	    Map<Character, TrieNode> children = new HashMap<>();
	    boolean isLeaf = false;
	    
	    
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        Map<Character, TrieNode> children = root.children;
	        for(int i = 0; i < word.length(); i++)
	        {
	            TrieNode t;
	            char c= word.charAt(i);
	            if(children.containsKey(c))
	                t = children.get(c);
	            else
	            {
	                t = new TrieNode();
	                children.put(c, t);
	            }
	            children = t.children;
	            if(i == word.length()-1)
	                    t.isLeaf = true;
	            
	        }
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode t = searchNode(word);
	        if(t != null&&t.isLeaf == true)
	            return true;
	        else 
	            return false;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        TrieNode t = searchNode(prefix);
	        if(t != null)
	            return true;
	        else 
	            return false;
	    }
	    
	    public TrieNode searchNode(String word){
	        Map<Character, TrieNode> children = root.children;
	        TrieNode t = null;
	        for(int i = 0; i < word.length(); i++){
	            char c = word.charAt(i);
	            if(children.containsKey(c))
	                t = children.get(c);
	            else
	                return null;
	            children = t.children;
	        }
	        return t;
	    }
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}

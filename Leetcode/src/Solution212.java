import java.util.*;

public class Solution212 {
	//use string
//	public List<String> findWords(char[][] board, String[] words) {
//        Set<String> res = new HashSet<String>();
//        if(words == null || words.length == 0||board == null || board.length == 0)
//            return new ArrayList<String>();
//    
//        Trie trie = constructTrie(words);
//        String s = new String();
//        boolean[][] visited = new boolean[board.length][board[0].length]; 
//        for(int i = 0; i < board.length; i++)
//        {
//            for(int j = 0; j < board[0].length; j++)
//            {
//                res.addAll(search(board, trie, s, i, j, visited));
//            }
//        }
//        return new ArrayList<String>(res);
//    }
//    private List<String> search(char[][] board, Trie trie, String s, int i, int j, boolean[][] visited){
//        List<String> res= new ArrayList<>();
//        if(i<0 || j<0 || i>=board.length||j>=board[0].length || visited[i][j])
//            return res;
//        char c = board[i][j];
//        s += c;
//        if(!trie.startsWith(s))
//        {
//            return res;
//        }
//        if(trie.search(s))  
//            res.add(s);
//            
//        visited[i][j] = true;
//        res.addAll(search(board, trie, s, i+1, j, visited));
//        res.addAll(search(board, trie, s, i, j+1, visited));
//        res.addAll(search(board, trie, s, i-1, j, visited));
//        res.addAll(search(board, trie, s, i, j-1, visited));
//        visited[i][j] = false;
//        
//        return res;
//    }
//    private Trie constructTrie(String[] words){
//        Trie trie = new Trie();
//        for(String word:words)
//        {
//            trie.insert(word);
//        }
//        
//        return trie;
//    }
//    
//}
	//use StringBuilder
	public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<String>();
        if(words == null || words.length == 0||board == null || board.length == 0)
            return new ArrayList<String>();
    
        Trie trie = constructTrie(words);
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length]; 
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                res.addAll(search(board, trie, sb, i, j, visited));
            }
        }
        return new ArrayList<String>(res);
    }
    private List<String> search(char[][] board, Trie trie, StringBuilder sb, int i, int j, boolean[][] visited){
        List<String> res= new ArrayList<>();
        if(i<0 || j<0 || i>=board.length||j>=board[0].length || visited[i][j])
            return res;
        char c = board[i][j];
        sb.append(c);
        String s = sb.toString();
        if(!trie.startsWith(s))
        {
        	sb.setLength(sb.length()-1);
            return res;
        }
        if(trie.search(s))  
            res.add(s);
            
        visited[i][j] = true;
        res.addAll(search(board, trie, sb, i+1, j, visited));
        res.addAll(search(board, trie, sb, i, j+1, visited));
        res.addAll(search(board, trie, sb, i-1, j, visited));
        res.addAll(search(board, trie, sb, i, j-1, visited));
        visited[i][j] = false;
        sb.setLength(sb.length()-1);
        
        return res;
    }
    private Trie constructTrie(String[] words){
        Trie trie = new Trie();
        for(String word:words)
        {
            trie.insert(word);
        }
        
        return trie;
    }
    class TrieNode {
        // Initialize your data structure here.
        char c;
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf = false;
        
    }
    class Trie {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[1][2];
		board[0][0] = 'a';
		board[0][1] = 'b';
		String[] words = new String[1];
		words[0] = "ba";
		//words[1] = "b";
		Solution212 test = new Solution212();
		System.out.println(test.findWords(board, words));
	}

	}




public class Solution79 {
	public static boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0)
            return true;
        if(board == null || board.length == 0)
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length;j++)
            {
                if(recExist(board, word, i, j , 0, visited))
                    return true;
                
            }
        }
        return false;
        
    }
    public static boolean recExist(char[][] board, String word, int i, int j, int index, boolean[][] visited){
        if(index == word.length())
            return true;
        if(i<0||j<0||i>=board.length||j>=board[0].length)
            return false;
        if(visited[i][j])
        {
            return false;
        }
        if(board[i][j] != word.charAt(index))
            return false;
        
        visited[i][j] = true;
        boolean res = (recExist(board, word, i+1, j, index+1, visited) 
                        ||recExist(board, word, i, j+1, index+1, visited)
                        ||recExist(board, word, i-1, j, index+1, visited)
                        ||recExist(board, word, i, j-1, index+1, visited));
        visited[i][j] = false;
        return res;
            
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[1][1];
		board[0][0] = 'a';
		String word = "ab";
		System.out.println(exist(board, word));
	}

}

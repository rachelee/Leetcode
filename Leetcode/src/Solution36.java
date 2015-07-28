import java.util.HashMap;
public class Solution36 {
	public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
            	char c = board[i][j];
            	if(c == '.')
            		continue;
                if(map.containsKey(c))
                    return false;
                else
                    map.put(c, 1);
            }
            map.clear();
        }
        
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
            	char c = board[j][i];
            	if(c == '.')
            		continue;
                if(map.containsKey(c))
                    return false;
                else
                    map.put(c, 1);
            }
            map.clear();
        }
        
        for(int a = 0; a <= 6; a+=3)
        {
            for(int b = 0; b <= 6; b+=3)
            {
                for(int i = a; i < a+3; i++)
                {
                    for(int j = b; j < b+3; j++)
                    {
                    	char c = board[i][j];
                    	if(c == '.')
                    		continue;
                        if(map.containsKey(c))
                            return false;
                        else
                            map.put(c, 1);
                    }
                }
                map.clear();
            }
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] numbers = {"......5..",".........",".........","93..2.4..","..7...3..",".........","...34....",".....3...",".....52.."};
		
		char[][] board = new char[9][9];
		int a = 0;
		int b = 0;
		for(String s: numbers)
		{
			System.out.println(s);
			for(int i = 0; i < s.length(); i++)
			{
				board[a][b] = s.charAt(i);
				b++;
			}
			a++;
			b=0;
			
		}
		
		Solution36 test = new Solution36();
		System.out.println(test.isValidSudoku(board));
	}

}

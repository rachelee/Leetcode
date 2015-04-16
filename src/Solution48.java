
import java.util.Arrays;

public class Solution48 {
	public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return;
        
        int layer = 0;
        int size = matrix.length;
        int curLen = size-2*layer;
        while(curLen > 1)
        {
            int offset;
            for(offset = 0; offset < curLen-1; offset++)
            {
                
                int temp = matrix[layer][layer+offset];
                
                matrix[layer][layer+offset] = matrix[layer+curLen-1-offset][layer];
                matrix[layer+curLen-1-offset][layer] = matrix[layer+curLen-1][layer+curLen-1-offset];
                matrix[layer+curLen-1][layer+curLen-1-offset] = matrix[layer+offset][layer+curLen-1];
                matrix[layer+offset][layer+curLen-1] = temp;
            }
            
            layer++;
            curLen = size-2*layer;
        }
            
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotate(matrix);
		System.out.println(Arrays.deepToString(matrix));
		
	}

}

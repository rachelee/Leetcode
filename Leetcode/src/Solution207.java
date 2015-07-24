import java.util.*;
import java.util.LinkedList;

public class Solution207 {
	//DFS
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0)
            return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++)
        {
            int pre = prerequisites[i][0];
            if(map.containsKey(pre))
            {
                List<Integer> l = map.get(pre);
                l.add(prerequisites[i][1]);
                map.put(pre, l);
            }
            else
            {
                List<Integer> l = new ArrayList<>();
                l.add(prerequisites[i][1]);
                map.put(pre, l);
            }
        }
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
        {
            if(!helper(map, visited, i))
                return false;
        }
        return true;
    }
    private boolean helper(Map<Integer, List<Integer>> map, int[] visited, int i)
    {
        if(visited[i] == 1)
            return true;
        if(visited[i] == -1)
            return false;
        visited[i] = -1;
        if(map.containsKey(i))
            for(int j: map.get(i))
            {
                if(!helper(map, visited, j))
                    return false;
            }
        visited[i] = 1;
        return true;
        
    }
    
    //BFS
    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
    	if(prerequisites == null)
            return true;
        int len = prerequisites.length;
        if(len == 0)
            return true;
        int[] pCount = new int[numCourses];
        for(int i = 0; i < len; i++)
        {
            pCount[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < pCount.length; i++)
        {
        	if(pCount[i] == 0)
        		queue.add(i);
        }
        int numNoPre = queue.size();
        while(!queue.isEmpty())
        {
            int num = queue.remove();
            for(int i = 0; i < len; i++)
            {
                if (num == prerequisites[i][1])
                {
                    pCount[prerequisites[i][0]]--;
	                if(pCount[prerequisites[i][0]] == 0)
	                {
	                    numNoPre++;
	                    queue.add(prerequisites[i][0]);
	                }
                }
            }
        }
        
        if(numNoPre == numCourses)
            return true;
        else
            return false;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] course = {1,0};
		int[][] pre = {course};
		Solution207 test = new Solution207();
		System.out.println(test.canFinishBFS(3, pre));
	}

}

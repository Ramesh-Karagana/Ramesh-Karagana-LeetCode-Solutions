//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
// User function Template for Java

class Solution {
    int countDistinctIslands(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1 && !visited[i][j])
                {
                    ArrayList<Integer> shape = new ArrayList<>();
                    dfs(i, j, grid, visited, shape, i, j);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] visited, ArrayList<Integer> shape,
            int srcI, int srcJ){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1 || visited[i][j])
            return;

        visited[i][j] = true;
        shape.add(i - srcI);
        shape.add(j - srcJ);

        dfs(i - 1, j, grid, visited, shape, srcI, srcJ);
        dfs(i, j + 1, grid, visited, shape, srcI, srcJ);
        dfs(i, j - 1, grid, visited, shape, srcI, srcJ);
        dfs(i + 1, j, grid, visited, shape, srcI, srcJ);
    }
}
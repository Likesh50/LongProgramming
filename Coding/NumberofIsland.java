

//https://leetcode.com/problems/number-of-islands/

class NumberofIsland {

    int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};

    public int numIslands(char[][] grid) {  
        
        int n=grid.length;
        int m=grid[0].length;

        boolean visited[][]=new boolean[n][m];
        int count=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j] || grid[i][j]=='0')
                    continue;
                
                dfs(i,j,n,m,visited,grid);
                count++;
            }
        }
        return count;
    }

    public boolean valid(int i,int j,int n,int m)
    {
        if(i<0 || i>=n || j<0 || j>=m)
            return false;
        
        return true;
    }

    public void dfs(int i,int j,int n,int m,boolean visited[][],char grid[][])
    {
        visited[i][j]=true;

        for(int k=0;k<4;k++)
        {
            int newi=i+dir[k][0];
            int newj=j+dir[k][1];
                    
            if(valid(newi,newj,n,m) && !visited[newi][newj] && grid[newi][newj]=='1')
            {
                dfs(newi,newj,n,m,visited,grid);
            }
        }        
    }
}
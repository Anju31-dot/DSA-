class Solution {
    class Pair{
        int row ;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int [] dr = {-1,1,0,0};
    int [] dc = {0,0,-1,1};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0;
        boolean [][] vis = new boolean [n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]=='1' && vis [i][j]!= true){
                    count++;
                    bfs(i,j,n,m,grid,vis);
                }
            }
        }
        return count;
    }
    public void bfs(int row, int col ,int n , int m , char[][]grid, boolean[][]vis){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = true;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int i =0;i<4;i++){
                int nr = curr.row + dr[i];
                int nc = curr.col + dc[i];
                if(nr >= 0 && nr <n && nc >=0 && nc <m && vis[nr][nc]!=true && grid[nr][nc]=='1'){
                    q.add(new Pair(nr,nc));
                    vis[nr][nc] = true;
                }
            }
        }

    }
}
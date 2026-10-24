class Solution {

    class Pair {
        int row, col;
        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O' && !vis[0][i]) {
                bfs(board, 0, i, vis);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[n - 1][i] == 'O' && !vis[n - 1][i]) {
                bfs(board, n - 1, i, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                bfs(board, i, 0, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[i][m - 1] == 'O' && !vis[i][m - 1]) {
                bfs(board, i, m - 1, vis);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void bfs(char[][] board, int r, int c, boolean[][] vis) {

        int n = board.length;
        int m = board[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        vis[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            for (int k = 0; k < 4; k++) {

                int nr = cur.row + dr[k];
                int nc = cur.col + dc[k];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    board[nr][nc] == 'O' &&
                    !vis[nr][nc]) {

                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
}

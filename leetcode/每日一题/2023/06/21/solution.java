//LCP 41. 黑白翻转棋
class Solution {
    private final int[] dirX = {-1, -1, 0, 1, 1, 1, 0, -1};
    private final int[] dirY = {0, 1, 1, 1, 0, -1, -1, -1};
    private char[][] board;
    public int flipChess(String[] chessboard) {
        int ans = 0;
        board = Arrays.stream(chessboard).map(String::toCharArray).toArray(char[][]::new);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    int cur = play(i, j);
                    if (cur > 0) {
                        board = Arrays.stream(chessboard).map(String::toCharArray).toArray(char[][]::new);
                        ans = Math.max(ans, cur);
                    }
                }
            }
        }
        return ans;
    }

    private int play(int x, int y) {
        Queue<Integer> q = new ArrayDeque<>();
        int total = 0;
        q.offer(x * 10 + y);
        while (!q.isEmpty()) {
            int p = q.poll();
            int x_p = p / 10;
            int y_p = p % 10;
            for (int d = 0; d < 8; d++) {
                int x_n = x_p + dirX[d];
                int y_n = y_p + dirY[d];
                int count = check(x_n, y_n, d, 0);
                int index = 0;
                while (isValid(x_n, y_n) && board[x_n][y_n] == 'X') {
                    if (count >= 0) {
                        if (index++ >= count) {
                            break;
                        }
                        q.offer(x_n * 10 + y_n);
                    } else if (count == -1) {
                        // 把错误的翻转恢复为O
                        board[x_n][y_n] = 'O';
                    }
                    x_n += dirX[d];
                    y_n += dirY[d];
                }
                if (count > 0) {
                    total += count;
                }
            }
        }
        return total;
    }

    private int check(int x, int y, int d, int count) {
        if (isValid(x, y)) {
            if (board[x][y] == 'O') {
                board[x][y] = 'X';
                return check(x + dirX[d], y + dirY[d], d, count + 1);
            }
            if (board[x][y] == 'X'){
                return count;
            }
        }
        return -1;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
    }

}
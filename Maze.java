
public class Maze {

    public static void main(String[] args) {
        boolean[][] board = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };

        int[][] path = new int[board.length][board[0].length];
        allPathPrint("", board, 0, 0, path, 1);

        System.out.println(count(0, 0));
    }

    static int count(int r, int c) {
        if (r == 2 || c == 2) {
            return 1;
        }
        int down = count(r + 1, c);
        int right = count(r, c + 1);
        return down + right;
    }

    static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {

            System.out.println(p);
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;
        if (r < maze.length - 1) {
            allPathPrint(p + 'D', maze, r + 1, c, path, step + 1);
        }

        if (c < maze[0].length - 1) {
            allPathPrint(p + 'R', maze, r, c + 1, path, step + 1);
        }

        maze[r][c] = true;
        path[r][c] = 0;
    }
}

package lukeass;

import java.util.ArrayList;

public class PuzzleMethod {
    public ArrayList<int[][]> getSuccessors(int[][] state) {
        ArrayList<int[][]> successors = new ArrayList<>();
        int row = 0, col = 0;

        // Find the empty tile (0)
        outerLoop:
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                if (state[i][j] == 0) {
                    row = i;
                    col = j;
                    break outerLoop;
                }
            }
        }

        // Possible directions: up, down, left, right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3) {
                int[][] newState = new int[3][3];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        newState[i][j] = state[i][j];
                    }
                }
                // Swap the empty tile with the adjacent tile
                newState[row][col] = newState[newRow][newCol];
                newState[newRow][newCol] = 0;
                successors.add(newState);
            }
        }
        return successors;
    }
}

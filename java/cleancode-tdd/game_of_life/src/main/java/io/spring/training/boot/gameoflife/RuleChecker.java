package io.spring.training.boot.gameoflife;

public class RuleChecker {
  public static boolean checkCellAlive(Grid grid, int row, int column) {
    int liveNeighbors = liveNeighbors(grid, row, column);

    return isCellAlive(grid.getCell(row, column), liveNeighbors);
  }

  static boolean isCellAlive(Cell cell, int liveNeighbors) {
    if (cell.isAlive()) {
      if (liveNeighbors < 2) {
        return false;
      } else {
        return liveNeighbors == 2 || liveNeighbors == 3;
      }
    } else {
      return liveNeighbors == 3;
    }
  }

  static int liveNeighbors(Grid grid, int row, int column) {
    int neighbors = 0;

    int startRow = row >= 1 ? row - 1 : 0;
    int endRow = row < grid.getCells().length - 1 ? row + 1 : row;
    int startColumn = column >= 1 ? column - 1 : 0;
    int endColumn = column < grid.getCells()[row].length - 1 ? column + 1 : column;

    for (int i = startRow; i <= endRow; i++) {
      for (int j = startColumn; j <= endColumn; j++) {
        if (i == row && j == column) {
          continue;
        }
        if (grid.getCell(i, j).isAlive()) {
          neighbors++;
        }
      }
    }

    return neighbors;
  }
}

package io.spring.training.boot.gameoflife.grid;

import java.util.Arrays;

public class Spielrunde {
  private static final int GOOD = 3;
  private static final int ACCEPTABLE = 2;

  public Cell[][] generateNewGrid(Grid grid) {
    Cell[][] cells = new Cell[grid.getCells().length][grid.getCells()[0].length];

    for (int row = 0; row < grid.getCells().length; row++) {
      for (int column = 0; column < grid.getCells()[row].length; column++) {
        boolean cellALive = checkCellAlive(grid, row, column);
        cells[row][column] = new Cell(cellALive);
      }
    }

    return cells;
  }

  public boolean checkCellAlive(Grid grid, int row, int column) {
    long aliveNeighbors = liveNeighbors(grid, row, column);

    return newStateCell(grid.getCell(row, column), aliveNeighbors);
  }

  boolean newStateCell(Cell cell, long aliveNeighbors) {
    if (cell.isAlive()) {
      return newStateAliveCell(aliveNeighbors);
    } else {
      return newStateDeadCell(aliveNeighbors);
    }
  }

  private static boolean newStateDeadCell(long aliveNeighbors) {
    return aliveNeighbors == GOOD;
  }

  private static boolean newStateAliveCell(long aliveNeighbors) {
    return aliveNeighbors == ACCEPTABLE || aliveNeighbors == GOOD;
  }

  private long liveNeighbors(Grid grid, int row, int column) {
    return Arrays.stream(grid.getNeighborsOfCell(row, column)).filter(Cell::isAlive).count();
  }
}

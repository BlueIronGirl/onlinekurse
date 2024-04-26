package io.spring.training.boot.gameoflife;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class Grid {
  private Cell[][] cells;

  public Grid(Cell[][] cells) {
    this.cells = cells;
  }

  public Cell getCell(int row, int column) {
    return this.cells[row][column];
  }

  public boolean getCellState(int row, int column) {
    if (row < 0 || row >= this.cells.length || column < 0 || column >= this.cells[0].length) {
      return false;
    }

    return cells[row][column].isAlive();
  }

  public void updateCellAlive(int row, int column, boolean alive) {
    this.cells[row][column].setAlive(alive);
  }

  public Cell[] getNeighborsOfCell(int row, int column) {
    Cell[] neighbors = new Cell[(this.cells.length * this.cells[1].length) - 1];

    int zaehler = 0;

    for (int i = row - 1; i <= row + 1; i++) {
      for (int j = column - 1; j <= column + 1; j++) {
        if (i == row && j == column) {
          continue;
        }
        neighbors[zaehler++] = new Cell(getCellState(i, j));
      }
    }

    return neighbors;
  }

  public void printFullGrid() {
    System.out.println("---------------------");

    for (int row = 0; row < cells.length; row++) {
      for (int column = 0; column < cells[row].length; column++) {
        Cell cell = getCell(row, column);
        System.out.print(cell.isAlive() ? "+" : "-");
        System.out.print(" ");
      }
      System.out.println();
    }

    System.out.println("---------------------");
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Grid) {
      Grid s = (Grid) obj;
      if (Arrays.deepEquals(s.cells, this.cells))
        return true;
    }
    return super.equals(obj);
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (Cell[] cell : cells) {
      for (Cell value : cell) {
        if (value.isAlive()) {
          s.append("#");
        } else {
          s.append("~");
        }
      }
      s.append("\n");
    }
    return s.toString();
  }
}

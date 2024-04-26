package io.spring.training.boot.gameoflife;

import lombok.Getter;

import java.util.random.RandomGenerator;

@Getter
public class Grid {
  private Cell[][] cells;

  public Grid(int rows, int columns) {
    this.cells = new Cell[rows][columns];
  }

  public Cell getCell(int row, int column) {
    return this.cells[row][column];
  }

  public void updateCellAlive(int row, int column, boolean alive) {
    this.cells[row][column].setAlive(alive);
  }

  public void fillGridRandomly() {
    RandomGenerator randomGenerator = RandomGenerator.getDefault();
    for (int i = 0; i < this.cells.length; i++) {
      for (int j = 0; j < this.cells[i].length; j++) {
        this.cells[i][j] = new Cell();
        updateCellAlive(i, j, randomGenerator.nextBoolean());
      }
    }
  }

  public void fillWithFixedValues(Cell[][] fixedValues) {
    this.cells = fixedValues;
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

}

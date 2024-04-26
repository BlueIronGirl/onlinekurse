package io.spring.training.boot.gameoflife.grid;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
  @Test
  public void getCellStateOfOneCell() {
    Cell[][] grid = {
        {new Cell(false), new Cell(false), new Cell(false)},
        {new Cell(false), new Cell(true), new Cell(false)},
        {new Cell(false), new Cell(false), new Cell(false)}
    };
    Grid gridToTest = new Grid(grid);

    assertTrue(gridToTest.getCellState(1, 1));
  }

  @Test
  public void getCellStateOfOtherCell() {
    Cell[][] grid = {
        {new Cell(false), new Cell(false), new Cell(false)},
        {new Cell(false), new Cell(true), new Cell(false)},
        {new Cell(false), new Cell(false), new Cell(false)}
    };
    Grid gridToTest = new Grid(grid);

    assertFalse(gridToTest.getCellState(1, 2));
  }

  @Test
  public void getCellStateOfAnotherCell() {
    Cell[][] grid = {
        {new Cell(false), new Cell(false), new Cell(false)},
        {new Cell(false), new Cell(true), new Cell(false)},
        {new Cell(false), new Cell(false), new Cell(false)}
    };
    Grid gridToTest = new Grid(grid);

    assertFalse(gridToTest.getCellState(2, 1));
  }

  private long deadCells(Cell[] cells) {
    return Arrays.stream(cells).filter(cell -> !cell.isAlive()).count();
  }

  private long aliveCells(Cell[] cells) {
    return Arrays.stream(cells).filter(Cell::isAlive).count();
  }

  @Test
  public void getNeighborsOfTheMiddleCell() {
    Cell[][] grid = {
        {new Cell(false), new Cell(false), new Cell(false)},
        {new Cell(false), new Cell(true), new Cell(false)},
        {new Cell(false), new Cell(false), new Cell(false)}
    };
    Grid gridToTest = new Grid(grid);

    Cell[] neighbors = gridToTest.getNeighborsOfCell(1, 1);

    assertEquals(0, aliveCells(neighbors));
    assertEquals(8, deadCells(neighbors));
  }

  @Test
  public void getNeighborsOfTheMiddleCell2() {
    Cell[][] grid = {
        {new Cell(true), new Cell(false), new Cell(false)},
        {new Cell(false), new Cell(true), new Cell(false)},
        {new Cell(false), new Cell(true), new Cell(true)}
    };
    Grid gridToTest = new Grid(grid);

    Cell[] neighbors = gridToTest.getNeighborsOfCell(1, 1);

    assertEquals(3, aliveCells(neighbors));
    assertEquals(5, deadCells(neighbors));
  }

  @Test
  public void getNeighborsOfACellAtTheBorder_AllOtherCellsAreDead() {
    Cell[][] grid = {
        {new Cell(true), new Cell(false), new Cell(false)},
        {new Cell(false), new Cell(true), new Cell(false)},
        {new Cell(false), new Cell(true), new Cell(true)}
    };
    Grid gridToTest = new Grid(grid);

    Cell[] neighbors = gridToTest.getNeighborsOfCell(0, 0);

    assertEquals(1, aliveCells(neighbors));
    assertEquals(7, deadCells(neighbors));
  }

  @Test
  public void getNeighborsOfACellAtTheBorder_AllOtherCellsAreDead_OtherCorner(){
    Cell[][] grid = {
        {new Cell(true), new Cell(false), new Cell(false)},
        {new Cell(false), new Cell(true), new Cell(false)},
        {new Cell(false), new Cell(true), new Cell(true)}
    };
    Grid gridToTest = new Grid(grid);

    Cell[] neighbors = gridToTest.getNeighborsOfCell(2, 2);

    assertEquals(2, aliveCells(neighbors));
    assertEquals(6, deadCells(neighbors));
  }

  @Test
  public void toStringTest(){
    Cell[][] grid = {
        {new Cell(false), new Cell(true), new Cell(false)},
        {new Cell(false), new Cell(true), new Cell(false)},
        {new Cell(false), new Cell(true), new Cell(false)}
    };
    Grid gridToTest = new Grid(grid);

    String actual = gridToTest.toString();
    String expected = """
        ---------------------
        - + -\s
        - + -\s
        - + -\s
        ---------------------
        """;

    assertEquals(expected, actual);
  }
}

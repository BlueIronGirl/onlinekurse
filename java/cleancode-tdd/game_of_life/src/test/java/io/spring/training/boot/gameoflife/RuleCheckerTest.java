package io.spring.training.boot.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RuleCheckerTest {
  private Grid grid;

  @BeforeEach
  void setUp() {
    grid = new Grid(3, 3);

    Cell[][] cells = new Cell[3][3];
    cells[0][0] = new Cell(true);
    cells[0][1] = new Cell(true);
    cells[0][2] = new Cell(true);

    cells[1][0] = new Cell(true);
    cells[1][1] = new Cell(true);
    cells[1][2] = new Cell(true);

    cells[2][0] = new Cell(true);
    cells[2][1] = new Cell(true);
    cells[2][2] = new Cell(true);


    grid.fillWithFixedValues(cells);
  }

  private static Stream<Object> provideTestIsCellAlive() {
    return Stream.of(
        new Object[]{true, 0, false},
        new Object[]{true, 1, false},
        new Object[]{true, 2, true},
        new Object[]{true, 3, true},
        new Object[]{true, 4, false},
        new Object[]{false, 0, false},
        new Object[]{false, 1, false},
        new Object[]{false, 2, false},
        new Object[]{false, 3, true},
        new Object[]{false, 4, false}
    );
  }

  @ParameterizedTest
  @MethodSource("provideTestIsCellAlive")
  public void testIsCellAlive(boolean cellAlive, int liveNeighbors, boolean expectedResult) {
    boolean result = RuleChecker.isCellAlive(new Cell(cellAlive), liveNeighbors);
    assertEquals(expectedResult, result);
  }

  private static Stream<Object> provideTestLiveNeighborsFullAlive() {
    return Stream.of(
        new Object[]{0, 0, 3},
        new Object[]{0, 1, 5},
        new Object[]{0, 2, 3},
        new Object[]{1, 0, 5},
        new Object[]{1, 1, 8},
        new Object[]{1, 2, 5},
        new Object[]{2, 0, 3},
        new Object[]{2, 1, 5},
        new Object[]{2, 2, 3}
    );
  }

  @ParameterizedTest
  @MethodSource("provideTestLiveNeighborsFullAlive")
  public void testLiveNeighborsFullAlive(int row, int col, int expectedResult) {
    int neighbors = RuleChecker.liveNeighbors(this.grid, row, col);
    assertEquals(expectedResult, neighbors);
  }
}

package io.spring.training.boot.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridServiceTest {
  private Grid grid;
  private GridService gridService;

  @BeforeEach
  void setUp() {
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

    gridService = new GridService();
    grid = new Grid(cells);
  }

  private static Stream<Object> provideTestNewStateCell() {
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
  @MethodSource("provideTestNewStateCell")
  public void testNewStateCell(boolean cellAlive, int liveNeighbors, boolean expectedResult) {
    boolean result = gridService.newStateCell(new Cell(cellAlive), liveNeighbors);
    assertEquals(expectedResult, result);
  }
}

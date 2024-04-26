package io.spring.training.boot.gameoflife.grid;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SpielrundeTest {
  private Spielrunde spielrunde = new Spielrunde();

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
    boolean result = spielrunde.newStateCell(new Cell(cellAlive), liveNeighbors);
    assertEquals(expectedResult, result);
  }

}

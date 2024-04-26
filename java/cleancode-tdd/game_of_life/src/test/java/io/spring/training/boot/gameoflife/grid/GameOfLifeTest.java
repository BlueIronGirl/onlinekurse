package io.spring.training.boot.gameoflife.grid;

import io.spring.training.boot.gameoflife.output.Output;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

class GameOfLifeTest {

  private static final Cell[][] cells = {
      {new Cell(false), new Cell(false), new Cell(false)},
      {new Cell(true), new Cell(true), new Cell(true)},
      {new Cell(false), new Cell(false), new Cell(false)}
  };

  private static final Cell[][] expectedCells = {
      {new Cell(false), new Cell(true), new Cell(false)},
      {new Cell(false), new Cell(true), new Cell(false)},
      {new Cell(false), new Cell(true), new Cell(false)}
  };

  @Test
  public void startTheGameWithoutArguments_ExpectsTwoOutputs() {
    Output output = Mockito.mock(Output.class);
    InOrder orderVerifier = Mockito.inOrder(output);

    Grid grid = new Grid(cells);
    GameOfLife gameOfLife = new GameOfLife(grid, output);

    gameOfLife.run();

    orderVerifier.verify(output, Mockito.calls(1)).print(grid);
    orderVerifier.verify(output).print(new Grid(expectedCells));
  }

  @Test
  public void startTheGameWithArguments4_ExpectsFiveOutputs() {
    Output output = Mockito.mock(Output.class);

    Grid grid = new Grid(cells);
    GameOfLife gameOfLife = new GameOfLife(grid, output);

    gameOfLife.run(4);

    Mockito.verify(output, Mockito.times(5)).print(grid);
  }

}

package io.spring.training.boot.gameoflife.output;

import io.spring.training.boot.gameoflife.grid.Grid;

public class ConsoleOutput implements Output {
  @Override
  public void print(Grid grid) {
    System.out.println(grid);
  }
}

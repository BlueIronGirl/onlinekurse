package io.spring.training.boot.gameoflife.grid;

import io.spring.training.boot.gameoflife.output.Output;

public class GameOfLife {
  private Grid grid;
  private Output output;

  public GameOfLife(Grid grid, Output output) {
    this.grid = grid;
    this.output = output;
  }

  public void run() {
    output.print(grid);
    grid.setCells(new Spielrunde().generateNewGrid(grid));
    output.print(grid);
  }

  public void run(int runden) {
    output.print(grid);

    for (int i = 0; i < runden; i++) {
      grid.setCells(new Spielrunde().generateNewGrid(grid));
      output.print(grid);
    }
  }
}

package io.spring.training.boot.gameoflife.output;

import io.spring.training.boot.gameoflife.grid.Grid;

public interface Output {
  void print(Grid grid);
}

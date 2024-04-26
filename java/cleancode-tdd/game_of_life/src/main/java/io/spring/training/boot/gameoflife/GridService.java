package io.spring.training.boot.gameoflife;

import org.springframework.stereotype.Service;

@Service
public class GridService {
  public void updateGrid(Grid grid) {
    for (int row = 0; row < grid.getCells().length; row++) {
      for (int column = 0; column < grid.getCells()[row].length; column++) {
        boolean cellALive = RuleChecker.checkCellAlive(grid, row, column);
        grid.updateCellAlive(row, column, cellALive);
      }
    }
  }
}

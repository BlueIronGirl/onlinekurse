package io.spring.training.boot.gameoflife.grid;

import org.springframework.stereotype.Service;

@Service
public class GridService {

  public void updateGrid(Grid grid) {
    new Spielrunde().updateGrid(grid);
  }
}

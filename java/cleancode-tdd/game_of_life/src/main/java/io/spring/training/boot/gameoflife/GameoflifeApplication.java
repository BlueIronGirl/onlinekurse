package io.spring.training.boot.gameoflife;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.random.RandomGenerator;

@SpringBootApplication
public class GameoflifeApplication implements CommandLineRunner {

	private GridService gridService;
	private Grid grid;

	public GameoflifeApplication(GridService gridService) {
		this.gridService = gridService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GameoflifeApplication.class, args);
	}

	@Override
	public void run(String... args) {
		this.grid = new Grid(getRandomGrid(8, 8));
		this.grid.printFullGrid();

		for (int i = 0; i < 10; i++) {
			gridService.updateGrid(this.grid);
			this.grid.printFullGrid();
		}
	}

	private Cell[][] getRandomGrid(int rows, int columns) {
		Cell[][] cells = new Cell[rows][columns];

		RandomGenerator randomGenerator = RandomGenerator.getDefault();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cells[i][j] = new Cell(randomGenerator.nextBoolean());
			}
		}

		return cells;
	}
}

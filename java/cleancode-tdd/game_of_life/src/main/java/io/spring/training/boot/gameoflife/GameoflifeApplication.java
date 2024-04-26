package io.spring.training.boot.gameoflife;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameoflifeApplication implements CommandLineRunner {

	private GridService gridService;
	private Grid grid;

	public GameoflifeApplication(GridService gridService) {
		this.gridService = gridService;
		this.grid = new Grid(8, 8);
	}

	public static void main(String[] args) {
		SpringApplication.run(GameoflifeApplication.class, args);
	}

	@Override
	public void run(String... args) {
		this.grid.fillGridRandomly();
		this.grid.printFullGrid();

		for (int i = 0; i < 10; i++) {
			gridService.updateGrid(this.grid);
			this.grid.printFullGrid();
		}
	}
}

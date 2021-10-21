package com.game.bowling;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BowlingApplication {

	private final String inputFileName = "input.txt";

	public static void main(String[] args) {
		SpringApplication.run(BowlingApplication.class, args);
	}

	@PostConstruct
	public void getInput() {
		try {
			Path path = Paths.get(getClass().getClassLoader().getResource(inputFileName).toURI());
			BowlingGame game = new BowlingGame();
			try (Stream<String> lines = Files.lines(path)) {

				lines.forEach(line -> {
					String[] bowlingPins = line.split(",");
					for (String bowlingPin : bowlingPins) {
						game.throwBall(Integer.parseInt(bowlingPin));
					}
					System.out.println(game.calculateScore());
				});

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}

	}

}

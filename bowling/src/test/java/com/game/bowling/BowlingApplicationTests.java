package com.game.bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BowlingApplicationTests {

	BowlingGame game = new BowlingGame();

	@Test
	public void testGutterBalls(){

		List<Integer> bowlingList = new ArrayList<>(
    		Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0));

		bowlingList.forEach(bowlingPins -> game.throwBall(bowlingPins));
		assertEquals(0, game.calculateScore());

	}

	
	@Test
	public void testAllThrees(){

		List<Integer> bowlingList = new ArrayList<>(
    		Arrays.asList(3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3));

		bowlingList.forEach(bowlingPins -> game.throwBall(bowlingPins));
		assertEquals(60, game.calculateScore());

	}

	@Test
	public void testAllSpares(){

		List<Integer> bowlingList = new ArrayList<>(
    		Arrays.asList(4,6,4,6,4,6,4,6,4,6,4,6,4,6,4,6,4,6,4,6,4));

		bowlingList.forEach(bowlingPins -> game.throwBall(bowlingPins));
		assertEquals(140, game.calculateScore());

	}


	@Test
	public void testNineStrikes(){

		List<Integer> bowlingList = new ArrayList<>(
    		Arrays.asList(10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,0,0));

		bowlingList.forEach(bowlingPins -> game.throwBall(bowlingPins));
		assertEquals(240, game.calculateScore());

	}

	@Test
	public void testPerfectGame(){

		List<Integer> bowlingList = new ArrayList<>(
    		Arrays.asList(10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,10,10));

		bowlingList.forEach(bowlingPins -> game.throwBall(bowlingPins));
		assertEquals(300, game.calculateScore());

	}

	@Test
	public void testSpareWith0AsStart(){

		List<Integer> bowlingList = new ArrayList<>(
    		Arrays.asList(0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0));

		bowlingList.forEach(bowlingPins -> game.throwBall(bowlingPins));
		assertEquals(100, game.calculateScore());

	}

	@Test
	public void testSpareStrikeMixed(){

		List<Integer> bowlingList = new ArrayList<>(
    		Arrays.asList(10,0,4,3,0,10,10,0,8,1,9,1,10,0,0,10,2,3,4,6,10));

		bowlingList.forEach(bowlingPins -> game.throwBall(bowlingPins));
		assertEquals(149, game.calculateScore());

	}

}

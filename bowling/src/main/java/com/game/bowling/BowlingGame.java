package com.game.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private final int MAX_FRAMES = 10;
    private int score;
    private List<Integer> throwsList = new ArrayList<>();

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void throwBall(int bowlingPins) {
        throwsList.add(bowlingPins);
    }

    public int calculateScore() {

        transformInput();

        int attempt = 0;
        score = 0;

        for (int frame = 1; frame <= MAX_FRAMES; frame++) {

            /** Strike Case */
            if (throwsList.get(attempt) == 10) {
                score += 10 + throwsList.get(attempt + 1) + throwsList.get(attempt + 2);
                attempt++;
            }

            /** Spare Case */
            else if ((throwsList.get(attempt) + throwsList.get(attempt + 1)) == 10) {
                score += 10 + throwsList.get(attempt + 2);
                attempt += 2;
            }

            else {
                score += throwsList.get(attempt) + throwsList.get(attempt + 1);
                attempt += 2;
            }
        }
        throwsList.clear();

        return score;
    }

    private void transformInput() {

        List<Integer> throwsListCopy = new ArrayList<>();
        int attempt = 0;
        boolean changed = false;
        for (int itr = 1; itr <= throwsList.size(); itr++) {
            /** Modifying the list to remove 0s which mean throw was not made */
            if (!(attempt % 2 != 0 && throwsList.get(attempt) == 0 && throwsList.get(attempt - 1) == 10)) {
                throwsListCopy.add(throwsList.get(attempt));
                changed = true;
            }
            attempt++;
        }
        if (changed) {
            throwsList = throwsListCopy;
        }
    }

}

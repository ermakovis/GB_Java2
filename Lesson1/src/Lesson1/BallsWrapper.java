package Lesson1;

import java.awt.*;

//Корректно использовать здесь "Wrapper"?
public class BallsWrapper {
    private final Dimension dimension;
    private static int ballsCapacity = 1;
    public static int ballsCount = 0;
    public static Ball[] balls = new Ball[ballsCapacity];

    BallsWrapper(Dimension dimension) {
        this.dimension = dimension;
    }

    private void addCapacity(int newCapacity) {
        Ball[] newBalls = new Ball[newCapacity];
        for (int i = 0; i < ballsCapacity; i++) {
            newBalls[i] = balls[i];
        }
        balls = newBalls;
        ballsCapacity = newCapacity;
    }

    public void add(int amount) {
        for (int i = 0; i < amount; i++) {
            add();
        }
    }

    public void add() {
        if (ballsCount == ballsCapacity) {
            addCapacity(ballsCapacity * 2);
        }
        balls[ballsCount] = new Ball();
        ballsCount++;
    }

    public void remove() {
        if (ballsCount == 0) {
            return ;
        }
        ballsCount--;
        balls[ballsCount] = null;
    }

    public void update(float deltaTime) {
        for (int i = 0; i < ballsCount; i++) {
            balls[i].update(deltaTime, dimension);
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < ballsCount; i++) {
            balls[i].render(g);
        }

    }

}

package Lesson1;

import java.awt.*;
import java.util.Random;

public class Sprite {
    protected int y;
    protected int x;
    protected int height;
    protected int width;

    Sprite (int y, int x, int height, int width) {
        int random = new Random().nextInt(5) + 1;
        this.y = y;
        this.x = x;
        this.height = height * random;
        this.width = width * random;
    }

    void update(float deltaTime, Dimension dimension) {}

    void render(Graphics g) {}

}
package Lesson1;

import java.awt.*;

public class Ball extends Sprite {

    Color color = new Color((int) (Math.random() * 200),
            (int) (Math.random() * 200),
            (int) (Math.random() * 200));
    private float vX = (float) (100f + (Math.random() * 200f));
    private float vY = (float) (100f + (Math.random() * 200f));

    Ball() {
        super(40,40, 40, 40);
    }

    @Override
    public void update(float deltaTime, Dimension dimension) {
        this.y += vY * deltaTime;
        this.x += vX * deltaTime;

        if (this.y < 0) {
            vY = -vY;
        }
        if (this.y + height > dimension.height) {
            vY = -vY;
        }
        if (this.x  < 0) {
            vX = -vX;
        }
        if (this.x + width > dimension.width) {
            vX = -vX;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillOval(x,y, width, height);
    }
}

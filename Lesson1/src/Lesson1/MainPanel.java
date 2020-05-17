package Lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPanel extends JPanel {

    Background background;
    BallsWrapper balls;
    long lastFrameTime = System.nanoTime();

    MainPanel(Dimension dimension) {
        setPreferredSize(dimension);
        background = new Background(this);
        balls = new BallsWrapper(dimension);
        balls.add(10);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    balls.add();
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    balls.remove();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        background.update(deltaTime);
        balls.update(deltaTime);
        balls.render(g);
        lastFrameTime = currentTime;
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }
}

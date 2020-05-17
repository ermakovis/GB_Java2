package Lesson1;


import java.awt.*;

public class Background {

    private int red = 90;
    private int green = 0;
    private int blue = 0;
    private boolean isAscending = true;
    private final MainPanel mainPanel;

    Background(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        mainPanel.setBackground(new Color(red, green, blue));
    }

    void update(float deltaTime) {
        int offset = (int)(deltaTime * 200);
        if (isAscending) {
            if (red < 150) {
                red += offset;
            } else if (green < 150) {
                green += offset;
            } else if (blue < 150) {
                blue += offset;
            }
        } else {
            if (red > 70) {
                red -= offset;
            } else if (green > 70) {
                green -= offset;
            } else if (blue > 70) {
                blue -= offset;
            }
        }
        if (red >= 150 && green >= 150 && blue >= 150) {
            isAscending = false;
        }
        if (red <= 70 && green <= 70 && blue <= 70) {
            isAscending = true;
        }
        mainPanel.setBackground(new Color(red, green, blue));
    }

}

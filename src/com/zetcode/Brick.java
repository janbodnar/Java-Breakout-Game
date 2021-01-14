package com.zetcode;

import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Brick extends Sprite {

    private boolean destroyed;

    public Brick(int x, int y) {

        initBrick(x, y);
    }

    private void initBrick(int x, int y) {

        this.x = x;
        this.y = y;

        destroyed = false;

        loadImage();
        getImageDimensions();
    }

    private void loadImage() {

        InputStream stream = getClass().getResourceAsStream(Commons.BRICK_IMAGE);
        ImageIcon ii;
        try {
            ii = new ImageIcon(ImageIO.read(stream));
            image = ii.getImage();
        } catch (IOException ex) {
            System.out.println("Unable to load brick.png");
        }
    }

    boolean isDestroyed() {

        return destroyed;
    }

    void setDestroyed(boolean val) {

        destroyed = val;
    }
}

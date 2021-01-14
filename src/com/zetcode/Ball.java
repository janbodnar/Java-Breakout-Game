package com.zetcode;

import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class Ball extends Sprite {

    private int xdir;
    private int ydir;

    public Ball() {

        initBall();
    }

    private void initBall() {

        xdir = 1;
        ydir = -1;

        loadImage();
        getImageDimensions();
        resetState();
    }

    private void loadImage() {
        InputStream stream = getClass().getResourceAsStream(Commons.BALL_IMAGE);
        ImageIcon ii;
        try {
            ii = new ImageIcon(ImageIO.read(stream));
            image = ii.getImage();
        } catch (IOException ex) {
            System.out.println("Unable to load ball.png");
        }
    }

    public static synchronized void playSound() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    InputStream stream = getClass().getResourceAsStream(Commons.BALL_SOUND);
                    AudioInputStream ais = AudioSystem.getAudioInputStream(stream);
                    clip.open(ais);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }

    public void move() {

        x += xdir;
        y += ydir;

        if (x == 0) {

            setXDir(1);
        }

        if (x == Commons.WIDTH - imageWidth) {

            System.out.println(imageWidth);
            setXDir(-1);
        }

        if (y == 0) {

            setYDir(1);
        }
    }

    private void resetState() {

        x = Commons.INIT_BALL_X;
        y = Commons.INIT_BALL_Y;
    }

    void setXDir(int x) {

        xdir = x;
    }

    void setYDir(int y) {

        ydir = y;
    }

    int getYDir() {

        return ydir;
    }
}

package com.zetcode;

import java.awt.Image;
import java.awt.Rectangle;

public class Sprite {

    protected int x;
    protected int y;
    protected int imageWidth;
    protected int imageHeight;
    protected Image image;
    
    protected void setX(int x) {
        this.x = x;
    }

    protected int getX() {
        return x;
    }

    protected void setY(int y) {
        this.y = y;
    }

    protected int getY() {
        return y;
    }

    protected int getImageWidth() {
        return imageWidth;
    }

    protected int getImageHeight() {
        return imageHeight;
    }

    protected Image getImage() {
        return image;
    }

    protected Rectangle getRect() {
        return new Rectangle(x, y,
                image.getWidth(null), image.getHeight(null));
    }

    protected void getImageDimensions() {

        imageWidth = image.getWidth(null);
        imageHeight = image.getHeight(null);
    }
}

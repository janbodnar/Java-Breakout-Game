package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Breakout extends JFrame {

    public Breakout() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        setTitle("Breakout");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Commons.WIDTH, Commons.HEIGTH);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            Breakout game = new Breakout();
            game.setVisible(true);
        });
    }
}

package com.korebit.content;

import javax.swing.*;
import java.awt.*;

public class WritheHeart extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        g.setColor(Color.RED);
        g.fillArc(150, 150, 100, 100, 0, 180);
        g.fillArc(250, 150, 100, 100, 0, 180);
        g.fillPolygon(new int[]{150, 350, 250}, new int[]{200, 200, 350}, 3);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        g.drawString("I LOVE YOU", 150, 100);
    }

    public static void writhe() {
        JFrame frame = new JFrame("Heart");
        WritheHeart panel = new WritheHeart();
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

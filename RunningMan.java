import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunningMan extends JPanel implements ActionListener {
    private int x = 50;
    private final int GROUND_LEVEL = 200;
    private Timer timer;
    private boolean legUp = true;

    public RunningMan() {
        this.setPreferredSize(new Dimension(800, 400));
        this.setBackground(Color.WHITE);
        timer = new Timer(100, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw head
        g.setColor(Color.BLACK);
        g.fillOval(x, GROUND_LEVEL - 50, 30, 30);

        // Draw body
        g.drawLine(x + 15, GROUND_LEVEL - 20, x + 15, GROUND_LEVEL + 20);

        // Draw arms
        g.drawLine(x, GROUND_LEVEL - 10, x + 30, GROUND_LEVEL - 10);

        // Draw legs (alternating positions for animation)
        if (legUp) {
            g.drawLine(x + 15, GROUND_LEVEL + 20, x, GROUND_LEVEL + 40);
            g.drawLine(x + 15, GROUND_LEVEL + 20, x + 30, GROUND_LEVEL + 40);
        } else {
            g.drawLine(x + 15, GROUND_LEVEL + 20, x + 30, GROUND_LEVEL + 40);
            g.drawLine(x + 15, GROUND_LEVEL + 20, x, GROUND_LEVEL + 40);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += 10; // Move forward
        legUp = !legUp; // Alternate leg position
        if (x > getWidth()) {
            x = -30; // Reset position when out of bounds
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Running Man");
        RunningMan runningMan = new RunningMan();
        frame.add(runningMan);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

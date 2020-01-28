import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {
    private Cube cube;
    private Object g;
    Graphics2D g2d = (Graphics2D) g;

    Viewer(Cube c){
        cube = c;

        this.setSize(1000, 1000); // размеры окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // операция закрытия программы вместе с окном
        this.setVisible(true); // задает видимость
    }
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle s = this.getBounds(); // использование размеров окна динамически
        g.translate(s.width/2, s.height/2); // Начало координат в центр

        //cube.draw(g2d);
        cube.perspdraw(g2d);
    }

}

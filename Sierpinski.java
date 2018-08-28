import java.applet.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Sierpinski extends Applet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    Graphics g;

    int deep = 0;

    public void paint() {
        setBackground(new Color(255,255,255));
    }

    public boolean mouseDown(Event ev, int x, int y) {
        if (!ev.metaDown()) deep += 1;
        else if (deep>0) deep -= 1;
        repaint();
        return true;
    }


    public void paint(Graphics g) {
        // Create triangle
        int px[] = {20, 400, 210};
        int py[] = {400, 400, 20};
        
        g.setColor(Color.black);
        g.fillPolygon(px, py, 3);
        
        paintTriangle(g, new Point(20,400),new Point(400,400),new Point(210,20), deep);
    }

    public void paintTriangle(Graphics g, Point a, Point b, Point c, int lvl) {

        Point a1,b1,c1, a2,b2,c2, a3,b3,c3;
        
        if (lvl==0) return;

        lvl -= 1;

        // In the given triangle, amended to include an upside-down triangle
        int px[] = {c.x, (c.x+b.x)/2, (a.x+c.x)/2};
        int py[] = {b.y, (c.y+a.y)/2, (c.y+a.y)/2};

        g.setColor(Color.white);
        g.fillPolygon(px, py, 3);
        g.setColor(Color.red);
        g.drawPolygon(px, py, 3);

        // 3 new triangles 
        a1 = a;
        b1 = new Point(c.x, b.y);
        c1 = new Point((a.x+c.x)/2, (c.y+a.y)/2);
        paintTriangle(g, a1, b1, c1, lvl);

        a2 = new Point(c.x, b.y);
        b2 = b;
        c2 = new Point((c.x+b.x)/2, (c.y+a.y)/2);
        paintTriangle(g, a2, b2, c2, lvl);

        a3 = new Point((a.x+c.x)/2, (c.y+a.y)/2);
        b3 = new Point((c.x+b.x)/2, (c.y+a.y)/2);
        c3 = c;
        paintTriangle(g, a3, b3, c3, lvl);
    }
}

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

/**
 * Created by Dilyana on 20.08.2018.
 */
public class Triangle extends Applet  {


    int a = Integer.parseInt(JOptionPane.showInputDialog("Въведете катет a (в см):"));
    int b = Integer.parseInt(JOptionPane.showInputDialog("Въведете катет b (в см):"));
    int c = Integer.parseInt(JOptionPane.showInputDialog("Въведете хипотенузата (в см):"));

    public void init() {
        checkIfRect(a,b,c);
        //размера на  applet window!
        this.setSize(600,600);
    }

    public int calculateS(int a, int b, int c) {
        int s = (a * b) / 2;
        return s;
    }
    public int calculateP(int a, int b, int c) {
        int p = a + b + c;
        return p;
    }

    public void checkIfRect(int a, int b, int c){

        if ((a * a + b * b) != c * c) {
            JOptionPane.showMessageDialog(null, "триъгълникът не е правоъгълен, моля заменете някоя от стойностите");
            a = Integer.parseInt(JOptionPane.showInputDialog("Въведете катет a (в см):"));
            b = Integer.parseInt(JOptionPane.showInputDialog("Въведете катет b (в см):"));
            c = Integer.parseInt(JOptionPane.showInputDialog("Въведете хипотенузата (в см):"));
            checkIfRect(a,b,c);

        } else {
            setSandP();
        }
    }

        public void paint (Graphics tri){
            int maxWidth = 500;
            float scaleFactor = 500 / (a + b);

            a = (int) (a * scaleFactor);
            b = (int) (b * scaleFactor);
            c = (int) (c * scaleFactor);

          //ако е правоъгълен
            if ((a * a + b * b) == c * c) {
                //начало на координатната система, за да по-добра видимост
                int x = 300;
                int y = 300;

                tri.setColor(new Color(255, 0, 0)); //червен триъгълник

                tri.drawLine(x, y, a + x, y);

                tri.drawLine(x, y, x, b   + x);

                tri.drawLine(x, b  + x, a + x, y);

                tri.setColor(Color.black);

                tri.drawRect(x, y - a, a, a);

                tri.setColor(Color.blue);

                tri.drawRect(x - b, y, b, b);
            }
        }

        public void setSandP(){
            int s = calculateP(a, b, c);
            int p = calculateS(a, b, c);
            TextField S = new TextField("Лицето на триъгълника:  S =  " + s + "m2");
            S.setEditable(false);
            this.add(S);

            TextField P = new TextField("Периметърът на триъгълника: е P =  " + p + "m");
            P.setEditable(false);
            this.add(P);
        }
}

















//        private static final long serialVersionUID = 1L;
//        Graphics g;
//
//        int deep = 0;
////
//        public void paint() {
//        }

//        public boolean mouseDown(Event ev, int x, int y) {
//            if (!ev.metaDown()) deep += 1;
//            else if (deep>0) deep -= 1;
//            repaint();
//            return true;
//        }


//        public void paint(Graphics g) {
//            // Create triangle
//            int a = 50 ;//katet1
//            int b = 400; //katet2
//            int c = 400;//hipotenuza
//            int px[] = {0, c, a};
//            int py[] = {b, c, 0};
//
//            g.setColor(Color.white);
////            g.fillPolygon(px, py, 3);
//            g.drawLine(0,a,b,c);
//            g.drawLine(0,a,b,c);
//            g.drawLine(0,a,b,c);
////            paintTriangle(g, new Point(20,400),new Point(400,400),new Point(210,20), deep);
//        }
//
//        public void paintTriangle(Graphics g, Point a, Point b, Point c, int lvl) {
//
//            Point a1,b1,c1, a2,b2,c2, a3,b3,c3;
//
//            if (lvl==0) return;
//
//            lvl -= 1;
//
//            // In the given triangle, amended to include an upside-down triangle
//            int px[] = {c.x, (c.x+b.x)/2, (a.x+c.x)/2};
//            int py[] = {b.y, (c.y+a.y)/2, (c.y+a.y)/2};
//
//            g.setColor(Color.red);
//            g.fillPolygon(px, py, 3);
//            g.setColor(Color.red);
//
//            g.drawPolygon(px, py, 3);
//
//            // 3 new triangles
//            a1 = a;
//            b1 = new Point(c.x, b.y);
//            c1 = new Point((a.x+c.x)/2, (c.y+a.y)/2);
//            paintTriangle(g, a1, b1, c1, lvl);
//
//            a2 = new Point(c.x, b.y);
//            b2 = b;
//            c2 = new Point((c.x+b.x)/2, (c.y+a.y)/2);
//            paintTriangle(g, a2, b2, c2, lvl);
//
//            a3 = new Point((a.x+c.x)/2, (c.y+a.y)/2);
//            b3 = new Point((c.x+b.x)/2, (c.y+a.y)/2);
//            c3 = c;
//            paintTriangle(g, a3, b3, c3, lvl);
//        }
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

                tri.drawLine(x, y, x, b + x);

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

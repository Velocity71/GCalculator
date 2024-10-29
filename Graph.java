import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Line2D;

import java.lang.Math;


class Graph extends Frame {

    // variables FIX ME PLEASE
    private static int xSize = 500;
    private static int ySize = 500;
    private static int xStep = 10;
    private static int yStep = 10;

    public Graph() {
        super("Graphing Calculator");
        setSize(xSize, ySize);
        setUndecorated(true);
        setVisible(true);
    }

    // extending the base java.awt.Frame.paint() function to paint the function onto the frame
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.lightGray);

        // draw Y lines
        for (int y = 0; y < ySize; y += yStep) {g.drawLine(0, y, xSize, y);}

        // draw X lines
        for (int x = 0; x < xSize; x += xStep) {g.drawLine(x, 0, x, ySize);}

        // draw origin lines
        g.setColor(Color.black);
        g.drawLine(0, ySize/2, xSize, ySize/2); // x=0
        g.drawLine(xSize/2, 0, xSize/2, ySize); // y=0

        // draw the function in red
        g.setColor(Color.red);
        drawFunc(g2d);
    }

    private static double f(double x) {
        return Math.pow(x, 2);
    }

    // draw function f(x)
    private static void drawFunc(Graphics2D g2d) {
        double lastX = (xSize/2) * -1;
        double lastY = f(lastX);

        for (double x = (xSize/2) * -1 + 1; x < xSize/2; x++) {
            Shape l = new Line2D.Double(transformX(lastX), transformY(lastY), transformX(x), transformY(f(x)));
            g2d.draw(l);
            lastX = x;
            lastY = f(x);
        }
    }

    // transform conventional origin coordinate plane to the coordinate plane java.awt.Frames use
    private static double transformX(double x) {return x + xSize/2;}
    private static double transformY(double y) {return (y - (ySize/2)) * -1;}
}
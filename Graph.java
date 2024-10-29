import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Color;


class Graph extends Frame {
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

    public void paint(Graphics g) {

        g.setColor(Color.lightGray);

        // draw Y lines
        for (int y = 0; y < ySize; y += yStep) {g.drawLine(0, y, xSize, y);}

        // draw X lines
        for (int x = 0; x < xSize; x += xStep) {g.drawLine(x, 0, x, ySize);}

        // draw origin lines
        g.setColor(Color.black);
        g.drawLine(0, ySize/2, xSize, ySize/2); // x=0
        g.drawLine(xSize/2, 0, xSize/2, ySize); // y=0

        g.setColor(Color.red);
        drawFunc(g);
    }

    private static int f(int x) {
        return 2*x + 4;
    }

    private static void drawFunc(Graphics g) {
        int lastX = (xSize/2) * -1;
        int lastY = f(lastX);

        for (int x = (xSize/2) * -1 + 1; x < xSize/2; x++) {
            g.drawLine(transformX(lastX), transformY(lastY), transformX(x), transformY(f(x)));

            lastX = x;
            lastY = f(x);
        }
    }

    // transform conventional origin coordinate plane to the coordinate plane java.awt.Frames use
    private static int transformX(int x) {return x + xSize/2;}
    private static int transformY(int y) {return (y - (ySize/2)) * -1;}
}
import java.awt.Frame;
import java.awt.GraphicsConfiguration;

// using adapters instead of listeners to make code cleaner3
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

class DraggableFrame extends Frame {

    // the "volatile" keyword keeps readers (usually threads) from reading non-updated values
    private volatile int mouseOnFrameX = 0;
    private volatile int mouseOnFrameY = 0;
    private volatile int frameX = 0;
    private volatile int frameY = 0;

    // constructors equivalent to java.awt.Frame
    public DraggableFrame() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseOnFrameX = e.getXOnScreen();
                mouseOnFrameY = e.getYOnScreen();
                frameX = getX();
                frameY = getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // delta X and delta Y
                int dX = e.getXOnScreen() - mouseOnFrameX;
                int dY = e.getYOnScreen() - mouseOnFrameY;

                setLocation(frameX + dX, frameY + dY);
            }
        });
    }

    public DraggableFrame(GraphicsConfiguration gc) {
        super(gc);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseOnFrameX = e.getXOnScreen();
                mouseOnFrameY = e.getYOnScreen();
                frameX = getX();
                frameY = getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int dX = e.getXOnScreen() - mouseOnFrameX;
                int dY = e.getYOnScreen() - mouseOnFrameY;

                setLocation(frameX + dX, frameY + dY);
            }
        });
    }

    public DraggableFrame(String title) {
        super(title);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseOnFrameX = e.getXOnScreen();
                mouseOnFrameY = e.getYOnScreen();
                frameX = getX();
                frameY = getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int dX = e.getXOnScreen() - mouseOnFrameX;
                int dY = e.getYOnScreen() - mouseOnFrameY;

                setLocation(frameX + dX, frameY + dY);
            }
        });
    }

    public DraggableFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseOnFrameX = e.getXOnScreen();
                mouseOnFrameY = e.getYOnScreen();
                frameX = getX();
                frameY = getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int dX = e.getXOnScreen() - mouseOnFrameX;
                int dY = e.getYOnScreen() - mouseOnFrameY;

                setLocation(frameX + dX, frameY + dY);
            }
        });
    }
}
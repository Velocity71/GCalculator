import java.awt.Frame;

class ControlFrame extends DraggableFrame {
    public ControlFrame() {
        super("Control");
        setSize(300, 400);
        setUndecorated(true);
        populateFrame();
        setVisible(true);
    }

    private void populateFrame() {}
}
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MainWindow extends JFrame {
    private String iconPath, imagePath = "resources\\images\\javap.jpg";
    private ImageIcon iconFile;
    private JPanel buttonsPanel, labelPanel;
    private JButton start, stop;
    private JLabel canvas;
    private BufferedImage pict;
    private final int width, height;
    public MainWindow(String winTitle, String path, int w, int h) {
        super(winTitle);
        iconPath = path;
        width = w;
        height = h;
        iconFile = new ImageIcon(Objects.requireNonNull(MainWindow.class.getResource(path)));
        setIconImage(iconFile.getImage());
        setSize(width, height);

        buttonsPanel = new JPanel();
        start = new JButton("Старт");
        stop = new JButton("Стоп");
        buttonsPanel.add(start);
        buttonsPanel.add(stop);

        labelPanel = new JPanel();
        canvas = new JLabel("Your image will be here...");
        labelPanel.add(canvas);
        Container clientArea = getContentPane();
        clientArea.add(BorderLayout.NORTH, buttonsPanel);
        clientArea.add(BorderLayout.CENTER, labelPanel);

        try {
            pict = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ActionListener myButtonsListener = new ButtonsListener();
        start.setActionCommand("Show");
        stop.setActionCommand("Hide");
        start.addActionListener(myButtonsListener);
        stop.addActionListener(myButtonsListener);
    }

    private class ButtonsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String command = e.getActionCommand();
            if (command.equals("Show")) {
                var scaledImg = pict.getScaledInstance(pict.getWidth() /2 , pict.getHeight()/2, Image.SCALE_SMOOTH);
                canvas.setText(null);
                canvas.setIcon(new ImageIcon(scaledImg));
            } else {
                canvas.setText("Image Hid");
                canvas.setIcon(null);
            }
        }
    }
}
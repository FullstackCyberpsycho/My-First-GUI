import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow("My First GUI",
                "images\\icons8-финишный-флажок-96.png", 300, 300);

        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }
}
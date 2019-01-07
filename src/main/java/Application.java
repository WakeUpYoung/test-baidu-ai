import gui.MainFrame;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        // 显示应用 GUI
        SwingUtilities.invokeLater(() -> MainFrame.createAndShowGUI());
    }
}

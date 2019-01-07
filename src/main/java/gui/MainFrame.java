package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public static void createAndShowGUI() {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("Baidu AI");
        // Setting the width and height of frame
        frame.setBounds(50, 50, 500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        LoginPanel panel = new LoginPanel();
        panel.init();
        panel.setVisible(true);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        // 添加面板
        /*
         * 调用用户定义的方法并添加组件到面板
         */

        // 设置界面可见
        frame.setVisible(true);
    }

}

package gui;

import javax.swing.*;
import java.awt.*;

public class LogArea extends JPanel {
    private JTextArea log;
    LogArea(){
        this.setLayout(null);
        this.setVisible(true);
        log = new JTextArea();
        log.setLineWrap(true);
        log.setVisible(true);
        log.setEnabled(false);
        log.setBounds(0, 20 ,500, 500);
        log.setBackground(Color.white);
        log.setDisabledTextColor(Color.black);
        JScrollPane pane = new JScrollPane(log);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(log);
    }

    public void append(String s){
        log.append(s + "\n");
    }

}

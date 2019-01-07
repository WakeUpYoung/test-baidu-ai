package gui;


import baidu.ai.SingleHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FilePicker extends JPanel implements ActionListener {
    private JTextField fileName;
    private JButton open;
    private LogArea log;

    public FilePicker(){
        this.setLayout(null);
        fileName = new JTextField(100);
        fileName.setEnabled(false);
        fileName.setDisabledTextColor(Color.black);
        open = new JButton("选择");
        fileName.setBounds(10, 30, 250, 25);
        open.setBounds(280, 30, 80, 25);
        log = new LogArea();
        log.setBounds(10, 55, 400, 500);
        this.add(fileName);
        this.add(open);
        this.add(log);
        this.setVisible(false);
        open.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc=new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
        jfc.showDialog(new JLabel(), "选择");
        File file=jfc.getSelectedFile();
        long start = System.currentTimeMillis();
        if (file != null){
            if(file.isDirectory()){
                fileName.setText(file.getAbsolutePath());
                for (File handleImg : file.listFiles()){
                    if (handleImg.getName().contains(".jpg")){
                        SingleHandler.startHandle(handleImg);
                        log.append("处理 : " + handleImg.getName());
                    }
                }
            }else if(file.isFile()){
                fileName.setText(file.getAbsolutePath());
                SingleHandler.startHandle(file);
                log.append("处理 : " + file.getName());
            }
            log.append("处理完毕，耗时:" + (System.currentTimeMillis() - start));
        }
    }
}

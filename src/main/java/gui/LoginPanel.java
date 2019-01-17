package gui;

import baidu.ai.BaiduAi;

import javax.swing.*;

public class LoginPanel extends JPanel {
    private JLabel appId;
    private JTextField appIdText;
    private JLabel apiKey;
    private JTextField apiKeyText;
    private JLabel secret;
    private JTextField secretText;
    private FilePicker filePicker;
    
    LoginPanel(){
        appId = new JLabel("App Id:");
        appIdText = new JTextField(20);
        apiKey = new JLabel("Api Key");
        apiKeyText = new JTextField(20);
        secret = new JLabel("Secret:");
        secretText = new JTextField(20);
        filePicker = new FilePicker();
    }
    
    public void init(){
        this.setLayout(null);
        this.setVisible(true);
        // 创建 JLabel
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        appId.setBounds(10,20,80,25);
        this.add(appId);

        /*
         * 创建文本域用于用户输入
         */
        appIdText.setBounds(100,20,165,25);
        this.add(appIdText);

        // 输入密码的文本域
        apiKey.setBounds(10,50,80,25);
        this.add(apiKey);

        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        apiKeyText.setBounds(100,50,165,25);
        this.add(apiKeyText);

        secret.setBounds(10,80,80,25);
        this.add(secret);

        secretText.setBounds(100,80,165,25);
        this.add(secretText);

        // 创建登录按钮
        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(10, 110, 80, 25);
        this.add(loginButton);

        filePicker.setBounds(10, 150, 490, 500);
        this.add(filePicker);

        // 点击事件
        loginButton.addActionListener(e -> {
            String appIdInput = appIdText.getText().trim();
            String apiKeyInput = apiKeyText.getText().trim();
            String secretInput = secretText.getText().trim();
            if (!appIdInput.equals("") && !apiKeyInput.equals("") && !secretInput.equals("")){
                BaiduAi.init(appIdInput, apiKeyInput, secretInput);
            }
            filePicker.setVisible(true);

        });
    }
}

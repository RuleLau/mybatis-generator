package com.sinog2c.base.job;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SwingComponent {

    private JFrame frame = new JFrame("Mybatis逆向工程");
    private JLabel dbUrlLabel = new JLabel("url:");
    private JTextField dbUrl = new JTextField(20);
    private JLabel usernameLabel = new JLabel("username:");
    private JTextField usernameText = new JTextField(20);
    private JLabel passwordLabel = new JLabel("password:");
    private JPasswordField passwordText = new JPasswordField(20);
    private JButton testButton = new JButton("测试连接");


    private void initPanel() {
        // 创建 JFrame 实例
        frame.setSize(550, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    private static JLabel buildJLabel(String name, int x, int y, int width, int height) {
        JLabel label = new JLabel(name);
        label.setBounds(x, y, width, height);
        return label;
    }

    private JComboBox<String> buildJComboBox(Object selectedItem, String name, String[] elements, int selectedIndex, int x, int y, int width, int height) {
        DefaultComboBoxModel<String> codeTypeModel = new DefaultComboBoxModel<>();
        // elements 下拉框中的选项
        for (String element : elements) {
            codeTypeModel.addElement(element);
        }
        JComboBox<String> codeTypeBox = new JComboBox<>(codeTypeModel);
        codeTypeBox.setName(name);
        // 默认选中的下拉框选项
        codeTypeBox.setSelectedItem(selectedItem);
//        codeTypeBox.setSelectedItem(selectedIndex);
        codeTypeBox.setBounds(x, y, width, height);
        // 添加下拉框事件监听器
        codeTypeBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // 选择的下拉框选项
                    System.out.println(e.getItem());
                }
            }
        });
        return codeTypeBox;
    }

    public static void main(String[] args) {
        new SwingComponent().initPanel();
    }

    private void placeComponents(JPanel panel) {

        panel.setLayout(null);

        // 下拉框
        panel.add(buildJLabel("数据库类型", 30, 20, 80, 25));
        String[] dbs = new String[]{"mysql", "dm", "oracle"};
        panel.add(buildJComboBox("mysql", "mysql", dbs, 0, 10, 0, 165, 25));

        // 创建 Url
        dbUrlLabel.setBounds(10, 20, 80, 25);
        panel.add(dbUrlLabel);
        dbUrl.setBounds(100, 20, 165, 25);
        panel.add(dbUrl);

        // 输入username
        usernameLabel.setBounds(10, 50, 80, 25);
        panel.add(usernameLabel);
        usernameText.setBounds(100, 50, 165, 25);
        panel.add(usernameText);

        // 输入密码的文本域
        passwordLabel.setBounds(10, 80, 80, 25);
        panel.add(passwordLabel);
        passwordText.setBounds(100, 80, 165, 25);
        panel.add(passwordText);

        // 创建登录按钮
        testButton.setBounds(10, 120, 80, 25);
        addActionListener(testButton);
        panel.add(testButton);
    }

    private void addActionListener(JButton saveButton) {
        // 为按钮绑定监听器
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 对话框
                JOptionPane.showMessageDialog(null, dbUrl.getText().trim() + "保存成功！");
            }
        });
    }

}

package com.niu.page;

import com.alibaba.fastjson.JSONObject;
import com.niu.constants.CmdEnum;
import com.niu.tcp.Mysocket;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;

/**
 * @program: 登录页面
 * @description:
 * @author: niuzilian
 * @create: 2019-04-27 11:11
 **/
public class Login extends JFrame implements ActionListener {
    JPanel jPanel1, jPanel2, jPanel3;
    JLabel jLabel1, jLabel2;
    JButton jButton1, jButton2;
    JTextField jTextField;
    JPasswordField passwordField;


    public void getLoginFrame() {
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();

        jLabel1 = new JLabel("用户名");
        jLabel2 = new JLabel("密    码");

        jButton1 = new JButton("登录");
        jButton2 = new JButton("取消");

        jTextField = new JTextField(10);

        passwordField = new JPasswordField(10);
        this.setLayout(new GridLayout(3, 1));

        // 加入各个组件
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField);

        jPanel2.add(jLabel2);
        jPanel2.add(passwordField);

        jPanel3.add(jButton1);
        jPanel3.add(jButton2);

        // 加入到JFrame
        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);

        this.setSize(250, 150);
        this.setTitle("登录");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        setLocationRelativeTo(null);

        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
    }


    public static void main(String[] args) {
        Login login = new Login();
        login.getLoginFrame();


    }

    /**
     * 添加整个的页面的监听事件
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if ("登录".equals(cmd)) {
            String name = jTextField.getText();
            String password = passwordField.getText();
            if (StringUtils.isBlank(name) || StringUtils.isBlank(password)) {
                JOptionPane.showMessageDialog(this, "用户名或者密码不能为空", "通知", JOptionPane.ERROR_MESSAGE);
            } else if("admin".equals(name)&&"admin".equals(password)) {
                try {
                    String hostAddress = InetAddress.getLocalHost().getHostAddress();
                    Mysocket socket = new Mysocket(hostAddress,8082);
                    JSONObject body=new JSONObject();
                    body.put("username",1001);
                    while (true){
                        socket.sendJson(CmdEnum.LOGIN,body);
                    }
                } catch (IOException e1) {
                    System.out.println("异常了，看一下把");
                }

            }else{
                JOptionPane.showMessageDialog(this, "用户名密码错误请重新输入！", "通知", JOptionPane.ERROR_MESSAGE);
            }
        } else if ("取消".equals(cmd)) {
            System.exit(0);
        }


    }
}

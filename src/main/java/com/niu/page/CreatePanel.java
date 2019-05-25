package com.niu.page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: myChatClient
 * @description:
 * @author: niuzilian
 * @create: 2019-04-27 11:13
 **/
public class CreatePanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static final int WINDOW_WIDTH=430;
    public static final int WINDOW_HEIGHT=330;

    /**
     * 创建北部面板
     * @return
     */
    public static JPanel CreateNorthPanel(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(430, 180));
        //图片大小440x210
        ImageIcon image=new ImageIcon("images/top.jpg");
        JButton close=new JButton("✖");

        close.setContentAreaFilled(false);  //设置按钮透明

        JLabel background=new JLabel(image);

        background.setBounds(0,0,430,180);
        close.setBounds(380, 0, 50,30);
        close.setForeground(Color.white);
        panel.add(close);
        panel.add(background);

        close.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        return panel;
    }


    /**
     * 创建南部面板
     */
    public static JPanel CreateSouthPanel(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(420, 40));

        MyLineBorder myLineBorder = new MyLineBorder(new Color(192, 192, 192), 1 , true);

        /**
         * 登录按钮
         */
        ImageIcon image=new ImageIcon("images/02.jpg");
        JButton btn=new JButton(image);
        btn.setBounds(128,0,image.getIconWidth()-10,image.getIconHeight()-10);
        btn.setBorder(myLineBorder);

        panel.add(btn);
        return panel;
    }

    /**
     * 创建中部面板
     */
    public static JPanel CrateCenterPanel(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(420, 160));
        MyLineBorder myLineBorder = new MyLineBorder(new Color(192, 192, 192), 1 , true);


        JLabel JLUserName = new JLabel("用户名:");
        JLabel JLUserPaw = new JLabel("密  码:");
        JLUserName.setBounds(65, 20, 80, 20);
        JLUserName.setForeground(new Color(0,0,0));
        JLUserName.setFont(new Font("楷体",0,16));
        JLUserPaw.setBounds(65, 50, 60, 20);
        JLUserPaw.setForeground(new Color(0,0,0));
        JLUserPaw.setFont(new Font("楷体",0,16));

        /**
         * 用户名框
         */
        JTextField username=new JTextField();
        username.setBounds(130, 15, 175, 30);
        username.setBorder(myLineBorder);

        /**
         * 密码框
         */
        JPasswordField password=new JPasswordField(JPasswordField.LEFT);
        password.setBounds(130, 44, 175, 30);
        password.setBorder(myLineBorder);

        /**
         * 注册
         */
        JLabel regeist=new JLabel("注册");
        regeist.setForeground(new Color(100,149,238));
        regeist.setBounds(310, 20, 30, 20);
        regeist.setFont(new Font("宋体",0,14));

        /**
         * 注册
         */
        JLabel reset=new JLabel("重置");
        reset.setForeground(new Color(100,149,238));
        reset.setBounds(310, 50, 30, 20);
        reset.setFont(new Font("宋体",0,14));


        panel.add(JLUserName);
        panel.add(JLUserPaw);
        panel.add(username);
        panel.add(password);
        panel.add(regeist);
        panel.add(reset);


        return panel;
    }

}

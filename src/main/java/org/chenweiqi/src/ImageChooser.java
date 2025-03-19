package org.chenweiqi.src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageChooser {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton button = new JButton("Select Image");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    java.io.File selectedFile = fileChooser.getSelectedFile();
                    // 这里selectedFile就是用户选择的图像文件，后续可进行图像读取操作
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                }
            }
        });

        frame.add(button);
        frame.setVisible(true);
    }
}
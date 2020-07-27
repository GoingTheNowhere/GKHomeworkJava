package homeworkeight;

import javax.swing.*;

public class MagicButton extends JFrame {
    MagicButton(String windowName){
        super(windowName);
        this.setSize(500,300);
        this.setLocation(400, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        JLabel exitButtonDescription = new JLabel("Нажатие на кнопку сделает то, ради чего Вы запустили программу.");
        exitButtonDescription.setSize(400,70);
        exitButtonDescription.setLocation(50, 50);
        add(exitButtonDescription);
        JButton exitButton = new JButton("Закрыть программу");
        exitButton.setSize(250, 50);
        exitButton.setLocation(125, 140);
        Listener exitButtonListener = new Listener();
        exitButton.addActionListener(exitButtonListener);
        add(exitButton);
        setVisible(true);
    }

}

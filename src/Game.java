import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    public class Game {
        JFrame frame;
        JPanel titleNamePanel, startButtonPannel, mainTextPanel, choicebuttonPannel, playerPanel;
        JLabel titleNameLabel, hpLabel,hpLabelnumber, weaponLabel, weaponLabelNumber;
        JButton startButton, choicebutton1, choicebutton2, choicebutton3, choicebutton4;
        JTextArea mainTextArea;
        TitleScreenHandler tsHandler = new TitleScreenHandler();

        Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
        Font normalFont = new Font("Times New Roman", Font.PLAIN, 31);



        public Game() {
            try {
                UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch (Exception e) {
                e.printStackTrace();
            }
            frame = new JFrame();
            frame.setBounds(100, 100, 800,600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(Color.black);
            frame.setLayout(null);




            titleNamePanel = new JPanel();
            titleNamePanel.setBounds(100, 100, 600, 150);
            titleNamePanel.setBackground(Color.black);
            titleNameLabel = new JLabel("ADVENTURE");
            titleNameLabel.setForeground(Color.white);
            titleNameLabel.setFont(titleFont);

            startButtonPannel = new JPanel();
            startButtonPannel.setBounds(300, 400, 200, 100);
            startButtonPannel.setBackground(Color.black);

            startButton = new JButton("Start");
            startButton.setBackground(Color.black);
            startButton.setForeground(Color.white);
            startButton.setFont(normalFont);
            startButton.addActionListener(tsHandler);

            titleNamePanel.add(titleNameLabel);
            startButtonPannel.add(startButton);
            frame.add(titleNamePanel);
            frame.add(startButtonPannel);
            frame.setVisible(true);
        }
        public void createGameScreen() {
            titleNameLabel.setVisible(false);
            startButtonPannel.setVisible(false);

            mainTextPanel = new JPanel();
            mainTextPanel.setBounds(100, 100, 600, 250);
            mainTextPanel.setBackground(Color.black);
            frame.add(mainTextPanel);

            mainTextArea = new JTextArea("This is the main text");
            mainTextArea.setBounds(100, 100, 600, 250);
            mainTextArea.setBackground(Color.black);
            mainTextArea.setForeground(Color.white);
            mainTextArea.setFont(normalFont);
            mainTextArea.setLineWrap(true);
            mainTextPanel.add(mainTextArea);

            choicebuttonPannel = new JPanel();
            choicebuttonPannel.setBounds(250, 350, 300, 150);
            choicebuttonPannel.setBackground(Color.black);
            choicebuttonPannel.setLayout(new GridLayout(4, 1));
            frame.add(choicebuttonPannel);

            choicebutton1 = new JButton("choice 1");
            choicebutton1.setBackground(Color.black);
            choicebutton1.setForeground(Color.white);
            choicebuttonPannel.add(choicebutton1);

            choicebutton2 = new JButton("choice 2");
            choicebutton2.setBackground(Color.black);
            choicebutton2.setForeground(Color.white);
            choicebuttonPannel.add(choicebutton2);

            choicebutton3 = new JButton("choice 3");
            choicebutton3.setBackground(Color.black);
            choicebutton3.setForeground(Color.white);
            choicebuttonPannel.add(choicebutton3);

            choicebutton4 = new JButton("choice 4.");
            choicebutton4.setBackground(Color.black);
            choicebutton4.setForeground(Color.white);
            choicebuttonPannel.add(choicebutton4);

            playerPanel = new JPanel();
            playerPanel.setBounds(100, 15, 600, 50);
            playerPanel.setBackground(Color.blue);
            playerPanel.setLayout(new GridLayout(1, 4));
            frame.add(playerPanel);

        }
    }



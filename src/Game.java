import javax.swing.*;
import java.awt.*;

/**
 * Positionen der Elemente müssen noch bearbeitet werden
 * Bug: Text are muss markiert werden um angezeigt zu werden
 */

    public class Game {
        JFrame frame;
        JPanel titleNamePanel, startButtonPannel, mainTextPanel, choicebuttonPannel, playerPanel;
        JLabel titleNameLabel;
        JButton startButton, choicebutton1, choicebutton2, choicebutton3, choicebutton4;
        JTextArea mainTextArea;
        TitleScreenHandler tsHandler = new TitleScreenHandler();

        // Fonts stehen noch nicht fest. Bitte ändern
        Font titleFont = new Font("Futura", Font.PLAIN, 90);
        Font normalFont = new Font("Futura", Font.PLAIN, 31);



        public Game() {
            try {
                UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch (Exception e) {
                e.printStackTrace();
            }
            frame = new JFrame("Screen Size");
            frame.setBounds(100, 100, 1600,900);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(new Color(23, 32, 56));
            frame.setLayout(null);


            /**
             * bestimmt die Designelemente des Titelbildschirms
             * Titel muss noch geändert werden
             */

            titleNamePanel = new JPanel();
            titleNamePanel.setBounds(100, 100, 600, 150);
            titleNamePanel.setBackground(new Color(23, 32, 56));
            titleNameLabel = new JLabel("(Spiel Name)");
            titleNameLabel.setForeground(new Color(222, 158,65));
            titleNameLabel.setFont(titleFont);

            startButtonPannel = new JPanel();
            startButtonPannel.setBounds(300, 400, 200, 100);
            startButtonPannel.setBackground(new Color(23, 32, 56));

            startButton = new JButton("Start");
            startButton.setBackground(new Color(23, 32, 56));
            startButton.setForeground(new Color(222, 158,65));
            startButton.setFont(normalFont);
            startButton.addActionListener(tsHandler);

            titleNamePanel.add(titleNameLabel);
            startButtonPannel.add(startButton);
            frame.add(titleNamePanel);
            frame.add(startButtonPannel);
            frame.setVisible(true);
        }

        /**
         * Hauptlayout des Spieles
         * Wird noch bearbeitet
         */
        public void createGameScreen() {
            titleNameLabel.setVisible(false);
            startButtonPannel.setVisible(false);

            mainTextPanel = new JPanel();
            mainTextPanel.setBounds(100, 100, 600, 250);
            mainTextPanel.setBackground(new Color(23, 32, 56));
            frame.add(mainTextPanel);

            mainTextArea = new JTextArea("This is the main text");
            mainTextArea.setBounds(100, 100, 600, 250);
            mainTextArea.setBackground(new Color(23, 32, 56));
            mainTextArea.setForeground(new Color(222, 158,65));
            mainTextArea.setFont(normalFont);
            mainTextArea.setLineWrap(true);
            mainTextPanel.add(mainTextArea);

            choicebuttonPannel = new JPanel();
            choicebuttonPannel.setBounds(250, 350, 300, 150);
            choicebuttonPannel.setBackground(new Color(23, 32, 56));
            choicebuttonPannel.setLayout(new GridLayout(4, 1));
            frame.add(choicebuttonPannel);

            choicebutton1 = new JButton("choice 1");
            choicebutton1.setBackground(new Color(23, 32, 56));
            choicebutton1.setForeground(new Color(222, 158,65));
            choicebuttonPannel.add(choicebutton1);

            choicebutton2 = new JButton("choice 2");
            choicebutton2.setBackground(new Color(23, 32, 56));
            choicebutton2.setForeground(new Color(222, 158,65));
            choicebuttonPannel.add(choicebutton2);

            choicebutton3 = new JButton("choice 3");
            choicebutton3.setBackground(new Color(23, 32, 56));
            choicebutton3.setForeground(new Color(222, 158,65));
            choicebuttonPannel.add(choicebutton3);

            choicebutton4 = new JButton("choice 4.");
            choicebutton4.setBackground(new Color(23, 32, 56));
            choicebutton4.setForeground(new Color(222, 158,65));
            choicebuttonPannel.add(choicebutton4);
        }
    }



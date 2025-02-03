import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    JFrame frame;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel;
    JButton startButton, choiceButton1, choiceButton2, choiceButton3, choiceButton4;
    JTextArea mainTextArea;

    /**
     * Dies sind die Schriftarten. Nach belieben ändern
     */

    Font titleFont = new Font("Times New Roman", Font.PLAIN, 170);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 50);

    /**
     * Dies gibt die Position in der Story ein. Wichtig für ChoiceHandler
     */
    String position;

    public Game() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame = new JFrame();
        frame.setSize(1600, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(23, 32, 56));
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 1200, 250);
        titleNamePanel.setBackground(new Color(23, 32, 56));
        frame.add(titleNamePanel);


        titleNameLabel = new JLabel("(Spiel Name)");
        titleNameLabel.setForeground(new Color(222, 158,65));
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(545, 500, 300, 150);
        startButtonPanel.setBackground(new Color(23, 32, 56));

        startButton = new JButton("Start");
        startButton.setBackground(new Color(23, 32, 56));
        startButton.setForeground(new Color(222, 158,65));
        startButton.setFont(normalFont);
        startButton.addActionListener(new TitleScreenHandler());
        startButtonPanel.add(startButton);

        frame.add(titleNamePanel);
        frame.add(startButtonPanel);
        frame.setVisible(true);
    }

    public void createGameScreen() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(0,0,1600, 300);
        mainTextPanel.setBackground(new Color(23, 32, 56));
        frame.add(mainTextPanel);

        /**
         * Hier wird der Dialog angezeigt
         */

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 100, 950, 50);
        mainTextArea.setBackground(Color.blue);
        mainTextArea.setForeground(new Color(222, 158,65));
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        /**
         * Dies Feld beinhaltet die Buttons
         */

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(300, 350, 1000, 250);
        choiceButtonPanel.setBackground(new Color(23, 32, 56));
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        frame.add(choiceButtonPanel);

        choiceButton1 = new JButton();
        choiceButton1.setBackground(new Color(23, 32, 56));
        choiceButton1.setForeground(new Color(222, 158,65));
        choiceButton1.setFont(normalFont);
        choiceButton1.addActionListener(new ChoiceHandler());
        choiceButtonPanel.add(choiceButton1);

        choiceButton2 = new JButton();
        choiceButton2.setBackground(new Color(23, 32, 56));
        choiceButton2.setForeground(new Color(222, 158,65));
        choiceButton2.setFont(normalFont);
        choiceButton2.addActionListener(new ChoiceHandler());
        choiceButtonPanel.add(choiceButton2);

        choiceButton3 = new JButton();
        choiceButton3.setBackground(new Color(23, 32, 56));
        choiceButton3.setForeground(new Color(222, 158,65));
        choiceButton3.setFont(normalFont);
        choiceButton3.addActionListener(new ChoiceHandler());
        choiceButtonPanel.add(choiceButton3);

        choiceButton4 = new JButton();
        choiceButton4.setBackground(new Color(23, 32, 56));
        choiceButton4.setForeground(new Color(222, 158,65));
        choiceButton4.setFont(normalFont);
        choiceButton4.addActionListener(new ChoiceHandler());
        choiceButtonPanel.add(choiceButton4);

        /**
         * Dies Panel beinaltet die Stats des Spielers
         */

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.blue);
        playerPanel.setLayout(new GridLayout(1, 4));
        frame.add(playerPanel);
        startGame();
    }

    public void startGame() {
        position = "Scene 1";
        mainTextArea.setText("Dies ist der Anfangs Text der beim starten des Spieles Angezeigt wird\n" +
                "");
        choiceButton1.setText("hallo");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }


    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String choice = event.getActionCommand();

        }
    }
}
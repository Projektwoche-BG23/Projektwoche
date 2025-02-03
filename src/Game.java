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
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 50);

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

        /**
         * Dies ist der Hauptframe, auf dem alle anderen Frames hinzugefügt werden.
         */

        frame = new JFrame();
        frame.setSize(1600, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(23, 32, 56));
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        /**
         * Dieses Panel ist für das anzeigen des Titels
         */

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 1200, 250);
        titleNamePanel.setBackground(new Color(23, 32, 56));
        frame.add(titleNamePanel);

        /**
         * Dieses Label
         */

        titleNameLabel = new JLabel("(Spiel Name)");
        titleNameLabel.setForeground(new Color(222, 158,65));
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(545, 500, 300, 150);
        startButtonPanel.setBackground(new Color(23, 32, 56));

        /**
         * Dies ist für das Anzeigen des Start Buttons
         */

        startButton = new JButton("Start");
        startButton.setBackground(new Color(23, 32, 56));
        startButton.setForeground(new Color(222, 158,65));
        startButton.setFont(startButtonFont);
        startButton.addActionListener(new TitleScreenHandler());
        startButton.setFocusPainted(false);
        startButtonPanel.add(startButton);


        frame.add(titleNamePanel);
        frame.add(startButtonPanel);
        frame.setVisible(true);
    }

    public void createGameScreen() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        /**
         * Dies Panel beinhaltet das Dialog Feld
         */
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,1400, 200);
        mainTextPanel.setBackground(new Color(23, 32, 56));
        frame.add(mainTextPanel);

        /**
         * Hier wird der Dialog angezeigt
         */

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(0, 0, 1400, 200);
        mainTextArea.setBackground(new Color(23, 32, 56));
        mainTextArea.setForeground(new Color(222, 158,65));
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        /**
         * Dies Feld beinhaltet die Buttons
         */

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(50, 650, 1400, 200);
        choiceButtonPanel.setBackground(new Color(23, 32, 56));
        choiceButtonPanel.setLayout(new GridLayout(2, 2));
        frame.add(choiceButtonPanel);

        choiceButton1 = new JButton();
        choiceButton1.setBackground(new Color(23, 32, 56));
        choiceButton1.setForeground(new Color(222, 158,65));
        choiceButton1.setFont(normalFont);
        choiceButton1.addActionListener(new ChoiceHandler());
        choiceButton1.setFocusPainted(false);
        choiceButtonPanel.add(choiceButton1);

        choiceButton2 = new JButton();
        choiceButton2.setBackground(new Color(23, 32, 56));
        choiceButton2.setForeground(new Color(222, 158,65));
        choiceButton2.setFont(normalFont);
        choiceButton2.addActionListener(new ChoiceHandler());
        choiceButton2.setFocusPainted(false);
        choiceButtonPanel.add(choiceButton2);


        choiceButton3 = new JButton();
        choiceButton3.setBackground(new Color(23, 32, 56));
        choiceButton3.setForeground(new Color(222, 158,65));
        choiceButton3.setFont(normalFont);
        choiceButton3.addActionListener(new ChoiceHandler());
        choiceButton3.setFocusPainted(false);
        choiceButtonPanel.add(choiceButton3);

        choiceButton4 = new JButton();
        choiceButton4.setBackground(new Color(23, 32, 56));
        choiceButton4.setForeground(new Color(222, 158,65));
        choiceButton4.setFont(normalFont);
        choiceButton4.addActionListener(new ChoiceHandler());
        choiceButton4.setFocusPainted(false);
        choiceButtonPanel.add(choiceButton4);

        /**
         * Dies Panel beinaltet die Stats des Spielers
         */

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(new Color(23, 32, 56));
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
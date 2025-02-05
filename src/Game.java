import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    JFrame frame;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, healtbartextpanel, waffentextpanel;
    JLabel titleNameLabel, healtbartext, waffentext;
    JButton startButton, ladenButton, einstellungenButton, verlassenButton;
    JButton choiceButton1, choiceButton2, choiceButton3, choiceButton4;
    JTextArea mainTextArea;

    int healt;
    String waffe = "Fists";
    String position;

    public Font titleFont = new Font("Times New Roman", Font.PLAIN, 170);
    public Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    public Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 50);

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
        frame.setResizable(false);

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(0, 100, 1600, 300);
        titleNamePanel.setBackground(new Color(23, 32, 56));
        frame.add(titleNamePanel);

        titleNameLabel = new JLabel("(Spiel Name)", SwingConstants.CENTER);
        titleNameLabel.setForeground(new Color(222, 158, 65));
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 450, 1000, 350);
        startButtonPanel.setBackground(new Color(23, 32, 56));
        startButtonPanel.setLayout(new GridLayout(4, 1));

        startButton = new JButton("Start");
        startButton.setFont(startButtonFont);
        startButton.addActionListener(this::handleTitleScreenAction);
        startButtonPanel.add(startButton);

        ladenButton = new JButton("Laden");
        ladenButton.setFont(startButtonFont);
        startButtonPanel.add(ladenButton);

        einstellungenButton = new JButton("Einstellungen");
        einstellungenButton.setFont(startButtonFont);
        startButtonPanel.add(einstellungenButton);

        verlassenButton = new JButton("Verlassen");
        verlassenButton.setFont(startButtonFont);
        startButtonPanel.add(verlassenButton);

        frame.add(titleNamePanel);
        frame.add(startButtonPanel);
        frame.setVisible(true);
    }

    public void handleTitleScreenAction(ActionEvent event) {
        createGameScreen();
    }

    public void createGameScreen() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 1400, 200);
        frame.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setFont(normalFont);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(90, 630, 1400, 200);
        choiceButtonPanel.setLayout(new GridLayout(2, 2, 10, 10));
        frame.add(choiceButtonPanel);

        choiceButton1 = new JButton();
        choiceButton1.setFont(normalFont);
        choiceButton1.setActionCommand("c1");
        choiceButton1.addActionListener(this::handleChoiceAction);
        choiceButtonPanel.add(choiceButton1);

        choiceButton2 = new JButton();
        choiceButton2.setFont(normalFont);
        choiceButton2.setActionCommand("c2");
        choiceButton2.addActionListener(this::handleChoiceAction);
        choiceButtonPanel.add(choiceButton2);

        choiceButton3 = new JButton();
        choiceButton3.setFont(normalFont);
        choiceButton3.setActionCommand("c3");
        choiceButton3.addActionListener(this::handleChoiceAction);
        choiceButtonPanel.add(choiceButton3);

        choiceButton4 = new JButton();
        choiceButton4.setFont(normalFont);
        choiceButton4.setActionCommand("c4");
        choiceButton4.addActionListener(this::handleChoiceAction);
        choiceButtonPanel.add(choiceButton4);

        anfangsSzene1();
    }

    public void handleChoiceAction(ActionEvent event) {
        String yourChoice = event.getActionCommand();

        switch (position) {
            case "anfangsSzene":
                if ("c1".equals(yourChoice)) anfangsSzene2();
                break;
            case "anfangsSzene2":
                if ("c1".equals(yourChoice)) tavernSzene();
                break;
            case "tavern":
                if ("c1".equals(yourChoice)) tavernSzene2();
                break;
            case "tavern2":
                if ("c1".equals(yourChoice)) fightScene();
                break;
        }
    }

    public void anfangsSzene1() {
        position = "anfangsSzene";
        mainTextArea.setText("The year 384... The great royal family Seidler...");
        choiceButton1.setText("Weiter");
    }

    public void anfangsSzene2() {
        position = "anfangsSzene2";
        mainTextArea.setText("and the country .... can save is the one true blood heir to the throne...");
        choiceButton1.setText("Weiter");
    }

    public void tavernSzene() {
        position = "tavern";
        mainTextArea.setText("A drunken knight steps forward...");
        choiceButton1.setText("...");
    }

    public void tavernSzene2() {
        position = "tavern2";
        mainTextArea.setText("Drunken knight: Wrong answer");
        choiceButton1.setText("FIGHT");
    }

    public void fightScene() {
        position = "fight";
        mainTextArea.setText("The battle begins!");
    }
}
